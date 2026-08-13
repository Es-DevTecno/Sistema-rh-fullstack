<template>
  <q-layout view="lHh Lpr lFf">

    <q-header class="bg-white text-primary shadow-2">
      <div class="bg-grey-1 text-grey-8 text-caption row justify-end items-center q-px-xl q-py-xs" style="min-height: 35px; border-bottom: 1px solid #e0e0e0;">
        <div class="row q-gutter-x-md">
          <div class="row items-center"><q-icon name="phone" size="xs" color="secondary" class="q-mr-xs" /> (51) 99807-8384</div>
          <div class="row items-center"><q-icon name="phone" size="xs" color="secondary" class="q-mr-xs" /> (51) 98141-0970</div>
          <div class="row items-center"><q-icon name="location_on" size="xs" color="secondary" class="q-mr-xs" /> Av. Senador Salgado Filho, 2000 - Viamão</div>
        </div>
      </div>

      <q-toolbar class="q-py-sm q-px-xl">
        <q-btn flat no-caps to="/" class="q-mr-lg" style="padding: 4px 8px;">
          <div class="text-h5 text-weight-bolder" style="letter-spacing: 1px;">
            <span class="text-primary">GGFV</span>
            <span class="text-secondary q-ml-sm">ASSESSORIA</span>
          </div>
        </q-btn>

        <div class="gt-sm row q-gutter-x-sm text-weight-bolder" style="font-size: 14px;">
          <q-btn flat label="QUEM SOMOS" to="/quem-somos" />
          <q-btn flat label="VAGAS" to="/vagas" />
          <q-btn flat label="SIMULADOR" @click="mostrarSimulador = true" />
        </div>

        <q-space />
      </q-toolbar>
    </q-header>

    <q-page-container>
      <router-view />
    </q-page-container>

    <!-- BOTÃO FLUTUANTE DO WHATSAPP -->
    <q-page-sticky position="bottom-right" :offset="[20, 20]">
      <q-btn
        fab
        color="green-6"
        icon="chat"
        tag="a"
        href="https://wa.me/5551998078384?text=Olá,%20vim%20pelo%20site%20da%20GGFV%20Assessoria%20e%20gostaria%20de%20mais%20informações."
        target="_blank"
        class="shadow-10"
      >
        <q-tooltip anchor="center left" self="center right" class="text-subtitle2 bg-dark">
          Fale conosco no WhatsApp
        </q-tooltip>
      </q-btn>
    </q-page-sticky>

    <!-- MODAL DO SIMULADOR -->
    <q-dialog v-model="mostrarSimulador">
      <q-card style="width: 550px; max-width: 90vw;" class="q-pa-sm">
        <q-card-section class="row items-center q-pb-none">
          <q-space />
          <q-btn icon="close" flat round dense v-close-popup />
        </q-card-section>

        <q-card-section class="q-pt-none">
          <h3 class="text-h6 text-weight-bold text-center q-mb-md text-primary">Simulador de Rescisão CLT</h3>

          <div class="row q-col-gutter-sm q-mb-md">
            <div class="col-12 col-sm-6">
              <q-input outlined dense v-model="formulario.salarioBase" label="Salário Base (R$)" type="number" />
            </div>
            <div class="col-12 col-sm-6">
              <q-input outlined dense v-model="formulario.mesesTrabalhados" label="Meses Trabalhados" type="number" />
            </div>
            <div class="col-12 col-sm-6">
              <q-select outlined dense v-model="formulario.tipoDemissao" :options="opcoesDemissao" label="Tipo de Desligamento" />
            </div>
            <div class="col-12 col-sm-6">
              <q-select outlined dense v-model="formulario.avisoPrevio" :options="opcoesAviso" label="Aviso Prévio" />
            </div>
          </div>

          <div class="text-center">
            <q-btn color="secondary" icon="calculate" label="Processar Cálculo" @click="enviarParaJava" class="q-px-lg text-weight-bold" rounded />
          </div>

          <div v-if="resultado" class="q-mt-md bg-grey-1 q-pa-sm rounded-borders shadow-1" style="border-left: 4px solid var(--q-secondary)">
            <h4 class="text-subtitle1 text-weight-bold q-mb-sm text-center">Demonstrativo de Verbas</h4>
            <div class="row justify-between q-mb-xs text-caption text-grey-9">
              <span>13º Proporcional:</span><strong>R$ {{ resultado.decimoTerceiro.toFixed(2) }}</strong>
            </div>
            <div class="row justify-between q-mb-xs text-caption text-grey-9">
              <span>Férias Proporcionais + 1/3:</span><strong>R$ {{ (resultado.ferias + resultado.tercoFerias).toFixed(2) }}</strong>
            </div>
            <div class="row justify-between q-mb-xs text-caption text-grey-9" v-if="resultado.avisoPrevio > 0">
              <span>Aviso Prévio Indenizado:</span><strong>R$ {{ resultado.avisoPrevio.toFixed(2) }}</strong>
            </div>
            <div class="row justify-between q-mb-xs text-caption text-negative">
              <span>Desconto INSS (Simulado):</span><strong>- R$ {{ resultado.descontoInss.toFixed(2) }}</strong>
            </div>
            <q-separator class="q-my-xs" />
            <div class="row justify-between q-mb-xs text-caption text-accent">
              <span>Saldo FGTS Depositado:</span><span>R$ {{ resultado.saldoFgts.toFixed(2) }}</span>
            </div>
            <div class="row justify-between q-mb-xs text-caption text-accent" v-if="resultado.multaFgts > 0">
              <span>Multa 40% FGTS:</span><span>R$ {{ resultado.multaFgts.toFixed(2) }}</span>
            </div>
            <q-separator class="q-my-xs" />
            <div class="row justify-between text-subtitle2 text-primary text-weight-bold">
              <span>Total Líquido a Receber:</span><span>R$ {{ resultado.totalRescisao.toFixed(2) }}</span>
            </div>
          </div>
        </q-card-section>
      </q-card>
    </q-dialog>

  </q-layout>
</template>

<script setup>
import { ref } from 'vue'

const mostrarSimulador = ref(false)

const formulario = ref({
  salarioBase: '',
  mesesTrabalhados: '',
  tipoDemissao: 'Sem Justa Causa',
  avisoPrevio: 'Indenizado'
})

const opcoesDemissao = ['Sem Justa Causa', 'Pedido de Demissão']
const opcoesAviso = ['Trabalhado', 'Indenizado', 'Dispensado / Nenhum']

const resultado = ref(null)

const enviarParaJava = () => {
  fetch('http://localhost:8080/api/dp/calcular', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      salarioBase: Number(formulario.value.salarioBase),
      mesesTrabalhados: Number(formulario.value.mesesTrabalhados),
      tipoDemissao: formulario.value.tipoDemissao,
      avisoPrevio: formulario.value.avisoPrevio
    })
  })
    .then(resposta => resposta.json())
    .then(dadosRecebidos => { resultado.value = dadosRecebidos })
    .catch(erro => { console.error(erro); alert("Erro na API."); })
}
</script>

<style scoped>
html {
  scroll-behavior: smooth;
}
</style>
