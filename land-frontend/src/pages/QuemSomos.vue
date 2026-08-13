<template>
  <q-page class="bg-page text-white" style="background-color: #16191d; min-height: 100vh;">

    <!-- Hero Header Institucional -->
    <section class="q-pa-xl text-center relative-position" style="padding-top: 80px; padding-bottom: 60px; background: linear-gradient(180deg, #14171a 0%, #16191d 100%);">
      <div style="max-width: 800px; margin: 0 auto;">
        <span class="text-secondary text-weight-bold uppercase tracking-widest text-caption">Institucional</span>
        <h1 class="text-h2 text-weight-bolder q-mt-sm q-mb-md text-white" style="letter-spacing: -1.5px;">Nossa História</h1>
        <p class="text-h6 text-grey-4 font-weight-light">Tradição, excelência e compromisso absoluto com o seu negócio.</p>
      </div>
    </section>

    <!-- Conteúdo Principal -->
    <section class="q-px-xl q-pb-xl" style="max-width: 1100px; margin: 0 auto;">

      <!-- Card da História (Estilo Bento Grid) -->
      <div class="bento-card q-pa-xl q-mb-xl" style="background: #1e2227; border-radius: 20px; border: 1px solid rgba(255, 255, 255, 0.08);">
        <div class="row items-center q-mb-lg">
          <q-icon name="auto_stories" size="3rem" color="secondary" class="q-mr-md" />
          <div>
            <h2 class="text-h4 text-weight-bold text-white q-my-none">Como Tudo Começou</h2>
            <span class="text-caption text-grey-5">GGFV Assessoria • Viamão, RS</span>
          </div>
        </div>

        <p class="text-body1 text-grey-3 q-mb-md" style="line-height: 1.8; font-size: 1.1rem;">
          Fundada em Viamão, no Rio Grande do Sul, a <strong>GGFV Assessoria</strong> nasceu da necessidade real de modernizar a gestão de pessoas e simplificar as rotinas complexas de Departamento Pessoal para empresas de todos os portes.
        </p>
        <p class="text-body1 text-grey-3 q-mb-none" style="line-height: 1.8; font-size: 1.1rem;">
          O que começou como uma consultoria especializada local rapidamente evoluiu para uma parceira estratégica indispensável, unindo o rigor jurídico das leis trabalhistas brasileiras com inovação tecnológica de ponta.
        </p>
      </div>

      <!-- Grid de Missão, Visão e Valores -->
      <div class="row q-col-gutter-lg q-mb-xl">

        <div class="col-12 col-md-4">
          <div class="bento-card q-pa-lg text-center flex column justify-between" style="height: 100%; background: #1e2227; border-radius: 20px; border: 1px solid rgba(255, 255, 255, 0.08);">
            <div>
              <q-icon name="flag" size="3rem" color="secondary" class="q-mb-md" />
              <h3 class="text-h5 text-weight-bold text-white q-mb-sm">Missão</h3>
              <p class="text-body2 text-grey-4">Fornecer soluções inovadoras, seguras e eficientes em Departamento Pessoal e gestão corporativa.</p>
            </div>
          </div>
        </div>

        <div class="col-12 col-md-4">
          <div class="bento-card q-pa-lg text-center flex column justify-between" style="height: 100%; background: #1e2227; border-radius: 20px; border: 1px solid rgba(255, 255, 255, 0.08);">
            <div>
              <q-icon name="visibility" size="3rem" color="accent" class="q-mb-md" />
              <h3 class="text-h5 text-weight-bold text-white q-mb-sm">Visão</h3>
              <p class="text-body2 text-grey-4">Ser a principal referência em assessoria e gestão estratégica de RH no sul do país.</p>
            </div>
          </div>
        </div>

        <div class="col-12 col-md-4">
          <div class="bento-card q-pa-lg text-center flex column justify-between" style="height: 100%; background: #1e2227; border-radius: 20px; border: 1px solid rgba(255, 255, 255, 0.08);">
            <div>
              <q-icon name="diamond" size="3rem" color="secondary" class="q-mb-md" />
              <h3 class="text-h5 text-weight-bold text-white q-mb-sm">Valores</h3>
              <p class="text-body2 text-grey-4">Transparência absoluta, ética inegociável, inovação constante e foco total no cliente.</p>
            </div>
          </div>
        </div>

      </div>

      <!-- Botão de Voltar Arredondado -->
      <div class="text-center q-mt-xl">
        <q-btn outline rounded color="secondary" size="lg" icon="arrow_back" label="Voltar para a Página Inicial" to="/" class="text-weight-bold q-px-xl" />
      </div>

    </section>

  </q-page>
</template>

<script setup>
</script>

<style scoped>
.bento-card {
  transition: transform 0.4s cubic-bezier(0.165, 0.84, 0.44, 1), border-color 0.4s ease;
}

.bento-card:hover {
  transform: translateY(-5px);
  border-color: rgba(192, 138, 124, 0.4);
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.4);
}
</style>
