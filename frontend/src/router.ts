import { createWebHistory, createRouter} from "vue-router";
import HelloWorld from "~/components/HelloWorld.vue";
import festivalTable from "~/components/festivalTable.vue";

const routes = [
    {
        path:'/',
        name:'Home',
        component: HelloWorld
    },
    {
        path:'/festivalTable',
        name:'festivalTable',
        component: festivalTable
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})


export default router;