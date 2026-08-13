<template>
  <q-page class="bg-grey-1 q-pa-xl">

    <!-- Cabeçalho da Página -->
    <div class="text-center q-mb-xl">
      <!-- Ícone usando a cor Rose Gold (secondary) -->
      <q-icon name="connect_without_contact" size="4rem" color="secondary" class="q-mb-md" />
      <h1 class="text-h3 text-weight-bold text-primary q-mt-none q-mb-sm">Fale Conosco</h1>
      <p class="text-h6 text-grey-7">Escolha o melhor canal para falar com a nossa equipe.</p>
    </div>

    <!-- Grid com os 3 Cartões de Contato -->
    <div class="row q-col-gutter-lg justify-center" style="max-width: 1000px; margin: 0 auto;">

      <!-- Cartão WhatsApp -->
      <div class="col-12 col-md-4">
        <q-card flat bordered class="q-pa-lg text-center bg-white transition-hover" style="height: 100%;">
          <q-icon name="chat" size="3.5rem" color="green-6" class="q-mb-md" />
          <h3 class="text-h5 text-weight-bold q-mb-sm text-primary">WhatsApp</h3>
          <p class="text-grey-8 q-mb-lg">Atendimento rápido para tirar suas dúvidas de DP.</p>
          <q-btn
            color="green-6"
            label="Chamar no Whats"
            class="full-width text-weight-bold"
            tag="a"
            href="https://wa.me/5551998078384"
            target="_blank"
          />
        </q-card>
      </div>

      <!-- Cartão Email -->
      <div class="col-12 col-md-4">
        <q-card flat bordered class="q-pa-lg text-center bg-white transition-hover" style="height: 100%;">
          <q-icon name="mail" size="3.5rem" color="accent" class="q-mb-md" />
          <h3 class="text-h5 text-weight-bold q-mb-sm text-primary">E-mail</h3>
          <p class="text-grey-8 q-mb-lg">Envie sua solicitação, currículo ou orçamento.</p>
          <q-btn
            color="accent"
            label="Enviar E-mail"
            class="full-width text-weight-bold"
            tag="a"
            href="mailto:contato@ggfvassessoria.com.br"
          />
        </q-card>
      </div>

      <!-- Cartão Instagram -->
      <div class="col-12 col-md-4">
        <q-card flat bordered class="q-pa-lg text-center bg-white transition-hover" style="height: 100%;">
          <q-icon name="photo_camera" size="3.5rem" color="purple-6" class="q-mb-md" />
          <h3 class="text-h5 text-weight-bold q-mb-sm text-primary">Instagram</h3>
          <p class="text-grey-8 q-mb-lg">Acompanhe nossas dicas de RH e novidades.</p>
          <q-btn
            color="purple-6"
            label="Seguir no Insta"
            class="full-width text-weight-bold"
            tag="a"
            href="https://instagram.com"
            target="_blank"
          />
        </q-card>
      </div>

    </div>

    <!-- Botão de Voltar -->
    <div class="text-center q-mt-xl" style="padding-top: 40px;">
      <q-btn outline color="primary" size="lg" icon="arrow_back" label="Voltar para o Início" to="/" />
    </div>

  </q-page>
</template>

<script setup>
</script>

<style scoped>
.transition-hover {
  transition: all 0.3s ease;
}
.transition-hover:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 20px rgba(0,0,0,0.1) !important;
  border-color: var(--q-secondary);
}
</style>
