import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/gloable.css'
import request from "@/utils/request";
import { download } from "@/utils/request";
import plugins from './plugins' // plugins
import { parseTime, resetForm, addDateRange, selectDictLabel, selectDictLabels, handleTree } from "@/utils/ruoyi";
// 分页组件
import Pagination from "@/components/Pagination";
import VCharts from 'v-charts'
Vue.use(VCharts)

Vue.config.productionTip = false
Vue.prototype.parseTime = parseTime
Vue.prototype.resetForm = resetForm
Vue.use(ElementUI, { size: "mini" });

Vue.component('Pagination', Pagination)

Vue.use(plugins)

Vue.prototype.request=request
Vue.prototype.download = download
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
