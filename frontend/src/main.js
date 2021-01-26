import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import routes from './routes'
import store from './vuex/store'
import vuetify from './plugins/vuetify'
import './plugins/firebase'
import VueGeolocation from 'vue-browser-geolocation';


Vue.config.productionTip = false

Vue.use(VueRouter)
Vue.use(VueGeolocation);

const router = new VueRouter({
    routes,
    mode: 'history',
});

new Vue({
    router,
    store,
    vuetify,
    render: h => h(App)
}).$mount('#app');