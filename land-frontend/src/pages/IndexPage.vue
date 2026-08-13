<template>
  <q-page class="bg-page">

    <!-- 1. HERO CAROUSEL COM APRESENTAÇÃO IMERSIVA -->
    <section id="home">
      <q-carousel
        animated
        v-model="slide"
        navigation
        infinite
        autoplay
        arrows
        transition-prev="slide-right"
        transition-next="slide-left"
        height="100vh"
        class="bg-dark text-white"
      >
        <!-- Slide 1: Principal GGFV -->
        <q-carousel-slide name="slide1" class="flex column justify-center q-px-xl relative-position hero-slide" style="background: url('https://images.unsplash.com/photo-1542744173-8e7e53415bb0?w=1600&q=80') center/cover no-repeat;">
          <div style="max-width: 950px; z-index: 2;" class="q-ml-xl">
            <div class="inline-block q-px-md q-py-xs rounded-pill bg-secondary-transparent text-secondary text-weight-bold q-mb-md text-caption uppercase tracking-wide">
              Excelência em Gestão Corporativa
            </div>
            <h1 class="text-h1 text-weight-bolder q-mb-md text-white" style="letter-spacing: -2px; font-size: clamp(2.5rem, 5vw, 4.5rem);">
              GGFV ASSESSORIA
            </h1>
            <p class="text-h5 text-weight-medium text-secondary q-mb-md" style="letter-spacing: 3px;">
              RH | DEPARTAMENTO PESSOAL
            </p>
            <p class="text-body1 text-grey-3 q-mb-xl" style="max-width: 600px; line-height: 1.6;">
              Gestão de Pessoas e soluções tecnológicas que transformam a base operacional do seu negócio com segurança jurídica absoluta.
            </p>
            <div class="row q-gutter-md">
              <q-btn color="secondary" size="lg" rounded label="Conheça Nossos Serviços" to="/quem-somos" class="text-weight-bold q-px-lg shadow-custom" />
              <q-btn outline color="white" size="lg" rounded label="Área do Cliente" to="/area-cliente" class="text-weight-bold q-px-lg" />
            </div>
          </div>
        </q-carousel-slide>

        <!-- Slide 2: Tecnologia e Cálculos -->
        <q-carousel-slide name="slide2" class="flex column justify-center q-px-xl relative-position hero-slide" style="background: url('https://images.unsplash.com/photo-1551836022-d5d88e9218df?w=1600&q=80') center/cover no-repeat;">
          <div style="max-width: 950px; z-index: 2;" class="q-ml-xl">
            <div class="inline-block q-px-md q-py-xs rounded-pill bg-accent-transparent text-accent text-weight-bold q-mb-md text-caption uppercase tracking-wide">
              Tecnologia e Precisão
            </div>
            <h2 class="text-h1 text-weight-bolder q-mb-md text-white" style="letter-spacing: -2px; font-size: clamp(2.5rem, 5vw, 4.5rem);">
              PRECISÃO E SEGURANÇA
            </h2>
            <p class="text-h5 text-weight-medium text-accent q-mb-md" style="letter-spacing: 3px;">
              AUTOMAÇÃO DE FOLHA E RESCISÕES
            </p>
            <p class="text-body1 text-grey-3 q-mb-xl" style="max-width: 600px; line-height: 1.6;">
              Cálculos trabalhistas complexos integrados a sistemas inteligentes para mitigar passivos e otimizar o tempo do RH.
            </p>
            <q-btn color="accent" size="lg" rounded label="Acessar Mural de Vagas" to="/vagas" class="text-weight-bold q-px-lg shadow-custom" />
          </div>
        </q-carousel-slide>

        <!-- Slide 3: Oportunidades -->
        <q-carousel-slide name="slide3" class="flex column justify-center q-px-xl relative-position hero-slide" style="background: url('https://images.unsplash.com/photo-1522071820081-009f0129c71c?w=1600&q=80') center/cover no-repeat;">
          <div style="max-width: 950px; z-index: 2;" class="q-ml-xl">
            <div class="inline-block q-px-md q-py-xs rounded-pill bg-secondary-transparent text-secondary text-weight-bold q-mb-md text-caption uppercase tracking-wide">
              Capital Humano
            </div>
            <h2 class="text-h1 text-weight-bolder q-mb-md text-white" style="letter-spacing: -2px; font-size: clamp(2.5rem, 5vw, 4.5rem);">
              BANCO DE TALENTOS
            </h2>
            <p class="text-h5 text-weight-medium text-secondary q-mb-md" style="letter-spacing: 3px;">
              CONEXÃO DE ALTO NÍVEL
            </p>
            <p class="text-body1 text-grey-3 q-mb-xl" style="max-width: 600px; line-height: 1.6;">
              Encontre oportunidades de carreira exclusivas ou candidate sua empresa para o nosso ecossistema de recrutamento.
            </p>
            <q-btn color="secondary" size="lg" rounded label="Ver Mural de Vagas" to="/vagas" class="text-weight-bold q-px-lg shadow-custom" />
          </div>
        </q-carousel-slide>
      </q-carousel>
    </section>

    <!-- 2. BENTO GRID DE SOLUÇÕES (Efeito Spotlight Interativo) -->
    <section class="q-pa-xl" style="background-color: #16191d; color: white; padding-top: 100px; padding-bottom: 100px;">
      <div class="text-center q-mb-xl">
        <span class="text-secondary text-weight-bold uppercase tracking-widest text-caption">Ecossistema GGFV</span>
        <h2 class="text-h3 text-weight-bold q-mt-sm q-mb-md">Soluções Feitas para o Futuro do Trabalho</h2>
        <p class="text-grey-5 text-subtitle1" style="max-width: 600px; margin: 0 auto;">
          Arquitetura moderna unindo assessoria jurídica trabalhista e alta tecnologia operacional.
        </p>
      </div>

      <div class="bento-container">

        <!-- Card 1: Quem Somos -->
        <div class="bento-card col-span-8 q-pa-xl flex column justify-between">
          <div>
            <div class="row items-center justify-between q-mb-md">
              <q-icon name="business_center" size="2.5rem" color="secondary" />
              <q-badge outline color="secondary" label="Institucional" />
            </div>
            <h3 class="text-h4 text-weight-bold q-mb-md">Tradição e Inovação em Viamão</h3>
            <p class="text-grey-4 text-body1" style="line-height: 1.7;">
              A GGFV Assessoria nasceu para descomplicar as rotinas corporativas. Unimos o rigor técnico das leis trabalhistas brasileiras com uma interface digital fluida.
            </p>
          </div>
          <div class="q-mt-lg">
            <q-btn flat color="secondary" icon-right="arrow_forward" label="Ler nossa história completa" to="/quem-somos" class="q-pa-none text-weight-bold" />
          </div>
        </div>

        <!-- Card 2: Vagas -->
        <div class="bento-card col-span-4 q-pa-xl flex column justify-between">
          <div>
            <div class="row items-center justify-between q-mb-md">
              <q-icon name="badge" size="2.5rem" color="accent" />
              <q-badge outline color="accent" label="Oportunidades" />
            </div>
            <h3 class="text-h5 text-weight-bold q-mb-sm">Mural de Vagas</h3>
            <p class="text-grey-4 text-body2">
              Explore posições abertas para analistas de DP e suporte técnico.
            </p>
          </div>
          <div class="q-mt-md">
            <q-btn outline color="accent" rounded label="Acessar Vagas" to="/vagas" class="full-width text-weight-bold" />
          </div>
        </div>

        <!-- Card 3: Suporte -->
        <div class="bento-card col-span-4 q-pa-xl flex column justify-between">
          <div>
            <div class="row items-center justify-between q-mb-md">
              <q-icon name="support_agent" size="2.5rem" color="secondary" />
              <q-badge outline color="secondary" label="Atendimento" />
            </div>
            <h3 class="text-h5 text-weight-bold q-mb-sm">Canais Diretos</h3>
            <p class="text-grey-4 text-body2">
              Fale via WhatsApp corporativo, e-mail dedicado ou redes sociais.
            </p>
          </div>
          <div class="q-mt-md">
            <q-btn outline color="secondary" rounded label="Fale Conosco" to="/contato" class="full-width text-weight-bold" />
          </div>
        </div>

        <!-- Card 4: Área do Cliente -->
        <div class="bento-card col-span-8 q-pa-xl flex column justify-between">
          <div>
            <div class="row items-center justify-between q-mb-md">
              <q-icon name="security" size="2.5rem" color="accent" />
              <q-badge outline color="accent" label="Portal Exclusivo" />
            </div>
            <h3 class="text-h4 text-weight-bold q-mb-md">Área do Cliente & Compliance</h3>
            <p class="text-grey-4 text-body1" style="line-height: 1.7;">
              Acesse relatórios consolidados de folha de pagamento, guias de recolhimento e acompanhamento jurídico em tempo real.
            </p>
          </div>
          <div class="q-mt-lg">
            <q-btn color="accent" rounded label="Entrar na Área do Cliente" to="/area-cliente" class="text-weight-bold q-px-xl" />
          </div>
        </div>

      </div>
    </section>

    <!-- 3. MEGA FOOTER PREMIUM -->
    <section class="bg-primary text-white q-pa-xl" style="border-top: 2px solid rgba(192, 138, 124, 0.2);">
      <div class="row q-col-gutter-xl justify-center" style="max-width: 1200px; margin: 0 auto;">

        <div class="col-12 col-md-3">
          <div class="text-h5 text-weight-bolder q-mb-md flex items-center" style="letter-spacing: 1px;">
            <span class="text-white">GGFV</span>
            <span class="text-secondary q-ml-sm">ASSESSORIA</span>
          </div>
          <p class="text-grey-4 text-caption q-mb-md">
            Transformando a complexidade do Departamento Pessoal em vantagem competitiva.
          </p>
          <q-btn outline rounded color="secondary" class="full-width bg-transparent text-weight-bold" label="ÁREA DO CLIENTE" to="/area-cliente" />
        </div>

        <div class="col-12 col-md-3">
          <h4 class="text-subtitle1 text-weight-bold text-uppercase q-mb-md text-secondary">Navegação</h4>
          <div class="column q-gutter-y-sm text-body2">
            <router-link to="/" class="text-grey-4 text-decoration-none hover-link">> Início</router-link>
            <router-link to="/quem-somos" class="text-grey-4 text-decoration-none hover-link">> Quem Somos</router-link>
            <router-link to="/vagas" class="text-grey-4 text-decoration-none hover-link">> Mural de Vagas</router-link>
            <router-link to="/contato" class="text-grey-4 text-decoration-none hover-link">> Contato Direto</router-link>
          </div>
        </div>

        <div class="col-12 col-md-3">
          <h4 class="text-subtitle1 text-weight-bold text-uppercase q-mb-md text-secondary">Localização</h4>
          <p class="text-weight-bold q-mb-xs text-white">Rio Grande do Sul:</p>
          <p class="q-mb-xs text-grey-4 text-body2">Tel.: (51) 99807-8384</p>
          <p class="q-mb-md text-grey-4 text-body2">Tel.: (51) 98141-0970</p>
          <p class="q-mb-xs text-grey-4 text-body2">
            <strong>Endereço:</strong><br>
            Av. Senador Salgado Filho, 2000<br>
            Viamão - RS
          </p>
        </div>

        <div class="col-12 col-md-3">
          <h4 class="text-subtitle1 text-weight-bold text-uppercase q-mb-md text-secondary">Newsletter Executiva</h4>
          <p class="q-mb-sm text-grey-4 text-body2">Receba atualizações trabalhistas mensais.</p>
          <q-input bg-color="dark" dark outlined dense placeholder="Seu e-mail corporativo" class="q-mb-md" />
          <q-btn color="secondary" rounded class="full-width text-weight-bold" label="INSCREVER-SE" />
        </div>

      </div>
    </section>

    <!-- BARRA DE DIREITOS AUTORAIS -->
    <div class="bg-black text-grey-6 text-center q-pa-md text-caption" style="border-top: 1px solid rgba(255,255,255,0.05);">
      Todos os direitos reservados. © 2026 | GGFV ASSESSORIA - RH & DEPARTAMENTO PESSOAL
    </div>

  </q-page>
</template>

<script setup>
import { ref, onMounted } from 'vue'

const slide = ref('slide1')

onMounted(() => {
  const cards = document.querySelectorAll('.bento-card')

  cards.forEach(card => {
    card.addEventListener('mousemove', e => {
      const rect = card.getBoundingClientRect()
      const x = e.clientX - rect.left
      const y = e.clientY - rect.top

      card.style.setProperty('--mouse-x', `${x}px`)
      card.style.setProperty('--mouse-y', `${y}px`)
    })
  })
})
</script>

<style scoped>
.hero-slide::after {
  content: '';
  position: absolute;
  inset: 0;
  background: linear-gradient(90deg, rgba(20,23,26,0.95) 0%, rgba(20,23,26,0.7) 60%, rgba(20,23,26,0.3) 100%);
  z-index: 1;
  pointer-events: none; /* Permite clicar nas setas e bolinhas do carrossel */
}

.bg-secondary-transparent {
  background: rgba(192, 138, 124, 0.15);
}

.bg-accent-transparent {
  background: rgba(93, 121, 144, 0.15);
}

.shadow-custom {
  box-shadow: 0 10px 30px rgba(0,0,0,0.3);
}

.hover-link {
  transition: color 0.3s ease, transform 0.3s ease;
}
.hover-link:hover {
  color: #C08A7C !important;
  padding-left: 4px;
}
.text-decoration-none {
  text-decoration: none;
}

.bento-container {
  display: grid;
  grid-template-columns: repeat(12, 1fr);
  gap: 24px;
  max-width: 1200px;
  margin: 0 auto;
}

.col-span-8 {
  grid-column: span 8;
}

.col-span-4 {
  grid-column: span 4;
}

@media (max-width: 900px) {
  .col-span-8, .col-span-4 {
    grid-column: span 12;
  }
}

.bento-card {
  position: relative;
  background: #1e2227;
  border-radius: 20px;
  border: 1px solid rgba(255, 255, 255, 0.08);
  overflow: hidden;
  transition: transform 0.4s cubic-bezier(0.165, 0.84, 0.44, 1), border-color 0.4s ease;
}

.bento-card::before {
  content: '';
  position: absolute;
  inset: 0;
  background: radial-gradient(
    600px circle at var(--mouse-x, 0) var(--mouse-y, 0),
    rgba(192, 138, 124, 0.18),
    transparent 50%
  );
  opacity: 0;
  transition: opacity 0.4s ease;
  pointer-events: none;
}

.bento-card:hover::before {
  opacity: 1;
}

.bento-card:hover {
  transform: translateY(-6px);
  border-color: rgba(192, 138, 124, 0.4);
  box-shadow: 0 25px 50px rgba(0, 0, 0, 0.5);
}
</style>
