import { createWebHistory, createRouter} from "vue-router";
import HelloWorld from "~/components/Sites/Home/Home.vue";
import festivalTable from "~/components/Sites/FestivalTable/Festivals.vue";
import pageNotFound from "~/components/Sites/PageNotFound/PageNotFound.vue";
import FestivalDetails from "~/components/Sites/FestivalDetails/FestivalDetails.vue";
import ShopDetails from "~/components/Sites/ShopDetails/ShopDetails.vue";
import LoginPage from "~/components/Sites/LogIn/Login.vue";

const routes = [
    {
        path:'/',
        name:'Home',
        component: HelloWorld,
        props: true
    },
    {
        path:'/festivals',
        name:'festivalTable',
        component: festivalTable,
        props: true
    },
    {
      path:'/festivals/:id',
      name:'festival_details',
      component: FestivalDetails,
        props: true
    },
    {
        path:'/festivals/shops/:id',
        name:'shop_details',
        component: ShopDetails,
        props: true
    },
    {
        path:'/:pathMatch(.*)*',
        name:'pageNotFound',
        component: pageNotFound,
        props: true
    },
    {
        path: '/login',
        name: 'loginPage',
        component: LoginPage,
        props: true
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router;