<template>
  <q-page class="bg-grey-1 q-pa-xl flex flex-center">

    <div style="width: 100%; max-width: 450px;">

      <!-- Cabeçalho do Card de Login -->
      <div class="text-center q-mb-lg">
        <div class="text-h4 text-weight-bolder text-primary q-mb-xs" style="letter-spacing: 1px;">
          GGFV <span class="text-secondary">CLIENTES</span>
        </div>
        <p class="text-grey-7 text-subtitle2">Acesse sua área exclusiva para ver folha e documentos</p>
      </div>


      <q-card flat bordered class="q-pa-lg bg-white shadow-2" style="border-top: 4px solid var(--q-secondary); border-radius: 12px;">
        <q-form @submit.prevent="fazerLogin" class="q-gutter-y-md">

          <q-input
            outlined
            v-model="cnpj"
            label="CNPJ da Empresa"
            mask="##.###.###/####-##"
            placeholder="00.000.000/0001-00"
            lazy-rules
            :rules="[val => !!val || 'Informe o CNPJ']"
          >
            <template v-slot:prepend>
              <q-icon name="business" color="secondary" />
            </template>
          </q-input>

          <q-input
            outlined
            v-model="senha"
            type="password"
            label="Senha de Acesso"
            lazy-rules
            :rules="[val => !!val || 'Informe a senha']"
          >
            <template v-slot:prepend>
              <q-icon name="lock" color="secondary" />
            </template>
          </q-input>

          <div class="q-mt-md">
            <q-btn
              type="submit"
              color="primary"
              rounded
              size="lg"
              label="Entrar na Área do Cliente"
              class="full-width text-weight-bold"
              :loading="carregando"
              :disabled="carregando"
            />
          </div>

        </q-form>

      </q-card>

      <!-- Botão de Voltar -->
      <div class="text-center q-mt-xl">
        <q-btn outline color="primary" rounded size="md" icon="arrow_back" label="Voltar para a Página Inicial" to="/" />
      </div>

    </div>

  </q-page>
</template>

<script setup>
import { ref } from 'vue'
import { useQuasar } from 'quasar'
import { useRouter } from 'vue-router'

const $q = useQuasar()
const router = useRouter()
const cnpj = ref('')
const senha = ref('')
const carregando = ref(false)

const fazerLogin = async () => {
  carregando.value = true

  try {
    const apiUrl = import.meta.env.VITE_API_URL || 'http://localhost:8080'
    const resposta = await fetch(`${apiUrl}/api/clientes/login`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ cnpj: cnpj.value, senha: senha.value })
    })
    const mensagem = await resposta.text()

    if (!resposta.ok) {
      throw new Error(mensagem || 'CNPJ ou senha inválidos.')
    }

$q.notify({ color: 'positive', message: 'Acesso liberado!', icon: 'check' })
    await router.push('/dashboard-cliente')
  } catch (erro) {
    $q.notify({
      color: 'negative',
      message: erro.message || 'Não foi possível conectar ao servidor.',
      icon: 'error'
    })
  } finally {
    carregando.value = false
  }
}
</script>
