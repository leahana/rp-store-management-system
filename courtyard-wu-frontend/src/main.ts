import {createApp} from 'vue'
import App from './App.vue'
import router from "./router";
import 'element-plus/dist/index.css'
import {useElementPlus} from "@/utils/plugin/element";
const app = createApp(App);
app.use(router);
app.use(useElementPlus);
app.mount('#app')
