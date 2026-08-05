<template>
  <q-layout view="hHh lpR fFf">

    <!-- Cabeçalho (Header) Azul -->
    <q-header elevated class="bg-primary text-white">
      <q-toolbar>

        <!-- O Título do  site -->
        <q-toolbar-title class="text-weight-bold">
          Recruta Mais
        </q-toolbar-title>

        <!-- Botões de navegação no topo -->
        <q-btn flat label="Nossos Serviços" />
        <q-btn flat label="Sobre Nós" />

      </q-toolbar>
    </q-header>

    <!-- O Container principal onde o IndexPage aparece -->
    <q-page-container>
      <router-view />
    </q-page-container>

  </q-layout>
</template>

<script setup>

</script>
