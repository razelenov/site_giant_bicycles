import Vue from "vue"
import vuetify from './plugins/vuetify.js'
import router from "./router";
import App from "./App.vue"

new Vue({
    vuetify,
    router,
    render: h => h(App)
}).$mount('#app')