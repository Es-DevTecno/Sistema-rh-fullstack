<template>
  <q-page class="text-white" style="background-color: #16191d; min-height: 100vh; padding-bottom: 80px;">

    <!-- Hero Header do Mural -->
    <section class="q-pa-xl text-center relative-position" style="padding-top: 80px; padding-bottom: 40px; background: linear-gradient(180deg, #14171a 0%, #16191d 100%);">
      <div style="max-width: 800px; margin: 0 auto;">
        <span class="text-secondary text-weight-bold uppercase tracking-widest text-caption">Banco de Talentos GGFV</span>
        <h1 class="text-h2 text-weight-bolder q-mt-sm q-mb-md text-white" style="letter-spacing: -1.5px;">Oportunidades de Carreira</h1>
        <p class="text-h6 text-grey-4 font-weight-light">Filtre as vagas por suas preferências, região e faça parte do nosso ecossistema.</p>
      </div>

      <!-- PAINEL DE FILTROS AVANÇADOS -->
      <div class="q-mt-xl q-pa-lg bento-card" style="max-width: 1100px; margin: 0 auto; background: #1e2227; border-radius: 20px; border: 1px solid rgba(255, 255, 255, 0.08);">
        <div class="row q-col-gutter-md items-center">

          <!-- Busca por texto -->
          <div class="col-12 col-md-3">
            <q-input
              dark
              outlined
              dense
              v-model="termoBusca"
              placeholder="Cargo ou tecnologia..."
              bg-color="dark"
              clearable
            >
              <template v-slot:prepend>
                <q-icon name="search" color="secondary" />
              </template>
            </q-input>
          </div>

          <!-- Filtro por Área / Preferência -->
          <div class="col-12 col-md-3">
            <q-select
              dark
              outlined
              dense
              v-model="categoriaSelecionada"
              :options="opcoesCategorias"
              label="Área de Preferência"
              bg-color="dark"
              emit-value
              map-options
            >
              <template v-slot:prepend>
                <q-icon name="category" color="secondary" />
              </template>
            </q-select>
          </div>

          <!-- Filtro por Estado -->
          <div class="col-12 col-md-3">
            <q-select
              dark
              outlined
              dense
              v-model="estadoSelecionado"
              :options="opcoesEstados"
              label="Estado"
              bg-color="dark"
              emit-value
              map-options
              @update:model-value="aoMudarEstado"
            >
              <template v-slot:prepend>
                <q-icon name="map" color="accent" />
              </template>
            </q-select>
          </div>

          <!-- Filtro por Município -->
          <div class="col-12 col-md-3">
            <q-select
              dark
              outlined
              dense
              v-model="municipioSelecionado"
              :options="opcoesMunicipios"
              label="Município"
              bg-color="dark"
              emit-value
              map-options
              :disable="estadoSelecionado === 'Todos'"
            >
              <template v-slot:prepend>
                <q-icon name="location_city" color="accent" />
              </template>
            </q-select>
          </div>

        </div>

        <!-- Indicador de filtros ativos e botão de limpar -->
        <div class="row justify-between items-center q-mt-md text-caption text-grey-5" v-if="temFiltroAtivo">
          <span>Filtrando vagas de acordo com suas preferências geográficas e profissionais.</span>
          <q-btn flat dense color="secondary" label="Limpar Filtros" @click="limparFiltros" icon="refresh" />
        </div>
      </div>
    </section>

    <!-- Grid de Vagas Dinâmico -->
    <section class="q-px-xl" style="max-width: 1200px; margin: 0 auto; padding-top: 40px;">

      <div v-if="vagasFiltradas.length === 0" class="text-center q-pa-xl">
        <q-icon name="sentiment_dissatisfied" size="4rem" color="grey-6" class="q-mb-md" />
        <h3 class="text-h5 text-grey-4">Nenhuma vaga encontrada.</h3>
        <p class="text-grey-6">Tente alterar o estado, município ou a categoria de preferência.</p>
      </div>

      <div class="row q-col-gutter-lg justify-center">
        <div class="col-12 col-md-4" v-for="(vaga, index) in vagasFiltradas" :key="index">
          <div class="bento-card q-pa-lg flex column justify-between" style="height: 100%; background: #1e2227; border-radius: 20px; border: 1px solid rgba(255, 255, 255, 0.08);">
            <div>
              <div class="row items-center justify-between q-mb-md">
                <q-badge outline :color="vaga.corBadge" :label="vaga.categoria" />
                <span class="text-caption text-secondary text-weight-bold">{{ vaga.local }}</span>
              </div>
              <h3 class="text-h5 text-weight-bold text-white q-mb-sm">{{ vaga.titulo }}</h3>
              <p class="text-body2 text-grey-4 q-mb-md" style="line-height: 1.6;">
                {{ vaga.descricao }}
              </p>
            </div>

            <div class="q-mt-lg">
              <q-separator dark class="q-mb-md" style="opacity: 0.1;" />
              <q-btn
                color="secondary"
                rounded
                class="full-width text-weight-bold"
                label="Ver Detalhes e Aplicar"
                @click="abrirModal(vaga)"
              />
            </div>
          </div>
        </div>
      </div>

      <!-- Botão de Voltar -->
      <div class="text-center q-mt-xl" style="padding-top: 40px;">
        <q-btn outline rounded color="secondary" size="lg" icon="arrow_back" label="Voltar para a Página Inicial" to="/" class="text-weight-bold q-px-xl" />
      </div>

    </section>

    <!-- MODAL DE CANDIDATURA INTERATIVA -->
    <q-dialog v-model="modalAberto">
      <q-card style="width: 550px; max-width: 90vw; background: #1e2227; color: white; border-radius: 20px; border: 1px solid rgba(192, 138, 124, 0.3);" class="q-pa-md">
        <q-card-section class="row items-center q-pb-none">
          <div>
            <span class="text-secondary text-caption text-weight-bold uppercase">Candidatura Rápida</span>
            <h3 class="text-h6 text-weight-bold q-my-none text-white">{{ vagaSelecionada.titulo }}</h3>
          </div>
          <q-space />
          <q-btn icon="close" flat round dense v-close-popup color="grey-4" />
        </q-card-section>

        <q-card-section class="q-pt-md">
          <p class="text-grey-4 text-subtitle2 q-mb-md">
            Local: <strong>{{ vagaSelecionada.local }}</strong>
          </p>

          <q-form @submit.prevent="enviarCandidatura" class="q-gutter-y-md">
            <q-input dark outlined dense v-model="candidato.nome" label="Nome Completo" lazy-rules :rules="[val => !!val || 'Campo obrigatório']" />
            <q-input dark outlined dense v-model="candidato.email" type="email" label="E-mail Profissional" lazy-rules :rules="[val => !!val || 'Campo obrigatório']" />
            <q-input dark outlined dense v-model="candidato.telefone" label="Telefone / WhatsApp" mask="(##) #####-####" lazy-rules :rules="[val => !!val || 'Campo obrigatório']" />
            <q-input dark outlined dense v-model="candidato.linkedin" label="Link do LinkedIn ou GitHub" />

            <div class="q-mt-lg">
              <q-btn type="submit" color="secondary" rounded size="lg" label="Enviar Currículo e Candidatar-se" class="full-width text-weight-bold shadow-custom" />
            </div>
          </q-form>
        </q-card-section>
      </q-card>
    </q-dialog>

  </q-page>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'
import { useQuasar } from 'quasar'

const $q = useQuasar()

const termoBusca = ref('')
const categoriaSelecionada = ref('Todas')

const listaEstados = ref([])
const listaMunicipios = ref([])
const estadoSelecionado = ref('Todos')
const municipioSelecionado = ref('Todos')

const opcoesEstados = computed(() => {
  const estadosFormatados = listaEstados.value.map(uf => ({
    label: `${uf.nome} (${uf.sigla})`,
    value: uf.sigla
  }))
  return [{ label: 'Todos os Estados', value: 'Todos' }, ...estadosFormatados]
})

const opcoesMunicipios = computed(() => {
  const cidadesFormatadas = listaMunicipios.value.map(cidade => ({
    label: cidade.nome,
    value: cidade.nome
  }))
  return [{ label: 'Todas as Cidades', value: 'Todos' }, ...cidadesFormatadas]
})

onMounted(async () => {
  try {
    const resposta = await fetch('https://servicodados.ibge.gov.br/api/v1/localidades/estados?orderBy=nome')
    listaEstados.value = await resposta.json()
  } catch (erro) {
    console.error('Erro ao carregar estados do IBGE:', erro)
  }
})

const aoMudarEstado = async (siglaUf) => {
  municipioSelecionado.value = 'Todos'
  listaMunicipios.value = []

  if (siglaUf === 'Todos' || !siglaUf) return

  try {
    const resposta = await fetch(`https://servicodados.ibge.gov.br/api/v1/localidades/estados/${siglaUf}/municipios?orderBy=nome`)
    listaMunicipios.value = await resposta.json()
  } catch (erro) {
    console.error('Erro ao carregar municípios:', erro)
  }
}

const opcoesCategorias = [
  { label: 'Todas as Áreas', value: 'Todas' },
  { label: 'Tecnologia / Suporte', value: 'Tecnologia / Suporte' },
  { label: 'Engenharia de Software', value: 'Engenharia de Software' },
  { label: 'Departamento Pessoal', value: 'Departamento Pessoal' }
]

const modalAberto = ref(false)
const vagaSelecionada = ref({})

const candidato = ref({
  nome: '',
  email: '',
  telefone: '',
  linkedin: ''
})

const listaDeVagas = ref([
  {
    titulo: 'Analista de Suporte Júnior (TI)',
    local: 'Viamão - RS',
    categoria: 'Tecnologia / Suporte',
    corBadge: 'secondary',
    descricao: 'Buscamos um profissional dedicado para atendimento a usuários, manutenção de infraestrutura, redes corporativas e suporte aos sistemas internos.'
  },
  {
    titulo: 'Desenvolvedor Full Stack',
    local: 'Porto Alegre - RS',
    categoria: 'Engenharia de Software',
    corBadge: 'accent',
    descricao: 'Oportunidade para atuar com desenvolvimento web moderno utilizando tecnologias como Vue.js no front-end e Java / Spring Boot no back-end.'
  },
  {
    titulo: 'Analista de Departamento Pessoal',
    local: 'São Paulo - SP',
    categoria: 'Departamento Pessoal',
    corBadge: 'secondary',
    descricao: 'Foco em fechamento de folha de pagamento, cálculo de rescisões, férias, encargos sociais e envio de obrigações acessórias.'
  }
])

const temFiltroAtivo = computed(() => {
  return termoBusca.value !== '' || categoriaSelecionada.value !== 'Todas' || estadoSelecionado.value !== 'Todos' || municipioSelecionado.value !== 'Todos'
})

const limparFiltros = () => {
  termoBusca.value = ''
  categoriaSelecionada.value = 'Todas'
  estadoSelecionado.value = 'Todos'
  municipioSelecionado.value = 'Todos'
  listaMunicipios.value = []
}

const vagasFiltradas = computed(() => {
  return listaDeVagas.value.filter(vaga => {
    const correspondeBusca = termoBusca.value === '' ||
      vaga.titulo.toLowerCase().includes(termoBusca.value.toLowerCase()) ||
      vaga.descricao.toLowerCase().includes(termoBusca.value.toLowerCase())

    const correspondeCategoria = categoriaSelecionada.value === 'Todas' || vaga.categoria === categoriaSelecionada.value

    const correspondeEstado = estadoSelecionado.value === 'Todos' || vaga.local.includes(estadoSelecionado.value)
    const correspondeMunicipio = municipioSelecionado.value === 'Todos' || vaga.local.includes(municipioSelecionado.value)

    return correspondeBusca && correspondeCategoria && correspondeEstado && correspondeMunicipio
  })
})

const abrirModal = (vaga) => {
  vagaSelecionada.value = vaga
  modalAberto.value = true
}

const enviarCandidatura = () => {
  modalAberto.value = false
  $q.notify({
    color: 'positive',
    message: 'Candidatura enviada com sucesso! Nossa equipe de RH entrará em contato.',
    icon: 'check_circle',
    position: 'top'
  })
  candidato.value = { nome: '', email: '', telefone: '', linkedin: '' }
}
</script>

<style scoped>
.bento-card {
  transition: transform 0.4s cubic-bezier(0.165, 0.84, 0.44, 1), border-color 0.4s ease;
}

.bento-card:hover {
  transform: translateY(-6px);
  border-color: rgba(192, 138, 124, 0.4);
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.5);
}

.shadow-custom {
  box-shadow: 0 10px 30px rgba(192, 138, 124, 0.3);
}
</style>
