import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify'
import store from './store.js'
import VueMask from 'v-mask';

Vue.config.productionTip = false
Vue.use(VueMask)

new Vue({
  router,
  vuetify,
  store,

  render: h => h(App)
}).$mount('#app')
