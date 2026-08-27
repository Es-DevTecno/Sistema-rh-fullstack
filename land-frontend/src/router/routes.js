const routes = [
  {
    path: '/',
    component: () => import('../layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('../pages/IndexPage.vue') },
      { path: 'vagas', component: () => import('../pages/VagasPage.vue') },
      { path: 'quem-somos', component: () => import('../pages/QuemSomos.vue') },
      { path: 'contato', component: () => import('../pages/ContatoPage.vue') },
      { path: 'area-cliente', component: () => import('../pages/ClientePage.vue') },
      { path: 'dashboard-cliente', component: () => import('../pages/DashboardCliente.vue') },
    ]
  },
  {
    path: '/:catchAll(.*)*',
    component: () => import('../pages/ErrorNotFound.vue')
  }
]

export default routes
