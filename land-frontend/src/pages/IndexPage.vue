<template>
  <q-page>
    <section class="q-pa-xl text-center bg-grey-1">
      <h1 class="text-h2 text-weight-bolder q-mb-md text-primary">
        Transformamos a Gestão de Pessoas
      </h1>
      <p class="text-h6 text-grey-8 q-mb-xl q-mx-auto" style="max-width: 700px">
        Soluções completas em Recrutamento, Seleção e Administração de Departamento Pessoal para impulsionar o crescimento do seu negócio.
      </p>
    </section>

    <!-- SEÇÃO DE SERVIÇOS -->
    <section class="q-pa-xl">
      <h2 class="text-h4 text-center text-weight-bold q-mb-xl text-dark">
        Nossas Especialidades
      </h2>
      <div class="row q-col-gutter-md justify-center">

        <div class="col-12 col-md-4">
          <q-card flat bordered class="text-center q-pa-md h-100">
            <q-card-section>
              <q-icon name="calculate" size="4rem" color="primary" />
              <div class="text-h6 q-mt-sm text-weight-bold">Cálculos Trabalhistas</div>
            </q-card-section>
            <q-card-section class="text-grey-7">
              Garantia de precisão na automação de cálculos complexos.
            </q-card-section>
          </q-card>
        </div>
      </div>
    </section>

    <section class="q-pa-xl bg-grey-2">
      <div class="row justify-center">
        <div class="col-12 col-md-6">
          <q-card flat bordered class="q-pa-lg">
            <h3 class="text-h5 text-weight-bold text-center q-mb-md text-primary">
              Simulador de Rescisão Base
            </h3>

            <div class="row q-col-gutter-md">
              <div class="col-12 col-sm-6">
                <q-input outlined v-model="formulario.salarioBase" label="Salário Base (R$)" type="number" />
              </div>
              <div class="col-12 col-sm-6">
                <q-input outlined v-model="formulario.mesesTrabalhados" label="Meses Trabalhados" type="number" />
              </div>
            </div>

            <div class="text-center q-mt-lg">
              <q-btn color="positive" size="lg" label="Calcular no Java" @click="enviarParaJava" />
            </div>

            <div v-if="resultado" class="q-mt-xl bg-white q-pa-md rounded-borders shadow-1">
              <h4 class="text-h6 text-weight-bold q-mb-sm text-center text-secondary">Resultado Processado:</h4>
              <div class="row justify-between q-mb-xs">
                <span>13º Proporcional:</span>
                <strong>R$ {{ resultado.decimoTerceiro.toFixed(2) }}</strong>
              </div>
              <div class="row justify-between q-mb-xs">
                <span>Férias Proporcionais:</span>
                <strong>R$ {{ resultado.ferias.toFixed(2) }}</strong>
              </div>
              <div class="row justify-between q-mb-xs">
                <span>1/3 Férias:</span>
                <strong>R$ {{ resultado.tercoFerias.toFixed(2) }}</strong>
              </div>
              <q-separator class="q-my-sm" />
              <div class="row justify-between text-h6 text-primary text-weight-bold">
                <span>Total Estimado:</span>
                <span>R$ {{ resultado.totalRescisao.toFixed(2) }}</span>
              </div>
            </div>

          </q-card>
        </div>
      </div>
    </section>

  </q-page>
</template>

<script setup>
import { ref } from 'vue'

const formulario = ref({
  salarioBase: '',
  mesesTrabalhados: ''
})

const resultado = ref(null)

const enviarParaJava = () => {

  fetch('http://localhost:8080/api/dp/calcular', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    // Transforma os dados da tela em texto (JSON) para enviar
    body: JSON.stringify({
      salarioBase: Number(formulario.value.salarioBase),
      mesesTrabalhados: Number(formulario.value.mesesTrabalhados)
    })
  })
    .then(resposta => resposta.json())
    .then(dadosRecebidos => {
      resultado.value = dadosRecebidos
      console.log("Cálculo recebido:", dadosRecebidos)
    })
    .catch(erro => {
      console.error("Erro na comunicação:", erro)
      alert("Ocorreu um erro ao conectar com o servidor Java.")
    })
}
</script>

<style scoped>
.h-100 { height: 100%; }
</style>
