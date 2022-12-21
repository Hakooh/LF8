import Vue, { createApp } from "vue";
import App from "./App.vue";
import VeeValidate from 'vee-validate';

// import "~/styles/element/index.scss";

// import ElementPlus from "element-plus";
// import all element css, uncommented next line
// import "element-plus/dist/index.css";

// or use cdn, uncomment cdn link in `index.html`

import "~/styles/index.scss";
import 'uno.css'

// If you want to use ElMessage, import it.
import "element-plus/theme-chalk/src/message.scss"
import {ElementPlus} from "@element-plus/icons-vue";
import router from "~/router";
import Vuex from "vuex";

//library.add(faHome, faUser, faUserPlus, faSigninAlt, faSignOutAlt);

const app = createApp(App);
// app.use(ElementPlus);
app.use(router)
app.mount("#app");
