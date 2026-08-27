<template>
  <q-page class="dashboard-page q-pa-md q-pa-lg-xl">
    <div class="dashboard-container">
      <header class="dashboard-header q-mb-lg">
        <div>
          <div class="text-overline text-secondary text-weight-bold">GGFV CLIENTES</div>
          <h1 class="text-h4 text-weight-bold q-my-xs">Área do cliente</h1>
          <p class="text-body1 text-grey-7 q-ma-none">Acompanhe seus documentos e solicitações em um só lugar.</p>
        </div>
        <q-btn
          outline
          color="primary"
          icon="logout"
          label="Sair"
          @click="sair"
        />
      </header>

      <section class="welcome-panel q-pa-lg q-mb-lg">
        <div>
          <div class="text-h6 text-weight-bold">Login realizado com sucesso</div>
          <div class="text-body2 q-mt-sm">Sua sessão está ativa. Escolha uma opção para continuar.</div>
        </div>
        <q-icon name="verified_user" size="3rem" aria-hidden="true" />
      </section>

      <section class="dashboard-grid" aria-label="Serviços disponíveis">
        <q-card flat bordered class="dashboard-card q-pa-lg">
          <q-icon name="description" color="secondary" size="2rem" />
          <h2 class="text-h6 text-weight-bold q-mt-md q-mb-sm">Documentos</h2>
          <p class="text-body2 text-grey-7 q-ma-none">Consulte holerites, comprovantes e arquivos da sua empresa.</p>
          <q-btn flat no-caps color="primary" label="Acessar documentos" class="q-px-none q-mt-md" disable />
        </q-card>

        <q-card flat bordered class="dashboard-card q-pa-lg">
          <q-icon name="support_agent" color="secondary" size="2rem" />
          <h2 class="text-h6 text-weight-bold q-mt-md q-mb-sm">Suporte</h2>
          <p class="text-body2 text-grey-7 q-ma-none">Entre em contato com a equipe da GGFV para tirar dúvidas.</p>
          <q-btn flat no-caps color="primary" label="Falar com suporte" to="/contato" class="q-px-none q-mt-md" />
        </q-card>

        <q-card flat bordered class="dashboard-card q-pa-lg">
          <q-icon name="business" color="secondary" size="2rem" />
          <h2 class="text-h6 text-weight-bold q-mt-md q-mb-sm">Dados da empresa</h2>
          <p class="text-body2 text-grey-7 q-ma-none">Mantenha as informações cadastrais sempre atualizadas.</p>
          <q-btn flat no-caps color="primary" label="Em breve" class="q-px-none q-mt-md" disable />
        </q-card>
      </section>
    </div>
  </q-page>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const sair = () => {
  router.push('/area-cliente')
}
</script>

<style scoped>
.dashboard-page {
  background: #f3f6f8;
}

.dashboard-container {
  width: min(100%, 1120px);
  margin: 0 auto;
}

.dashboard-header {
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
  gap: 1rem;
}

.welcome-panel {
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 1rem;
  color: #ffffff;
  background: linear-gradient(120deg, var(--q-primary), #246b78);
  border-radius: 8px;
}

.dashboard-grid {
  display: grid;
  grid-template-columns: repeat(3, minmax(0, 1fr));
  gap: 1rem;
}

.dashboard-card {
  min-height: 220px;
  border-radius: 8px;
  background: #ffffff;
}

@media (max-width: 720px) {
  .dashboard-header {
    align-items: stretch;
    flex-direction: column;
  }

  .dashboard-header .q-btn {
    align-self: flex-start;
  }

  .dashboard-grid {
    grid-template-columns: 1fr;
  }
}
</style>