import Vue from "vue"
import VueRouter from "vue-router"

Vue.use(VueRouter)

const routes = [
    {
        path: "/",
        name: "Main",
        component: () => import("../views/Main"),
        redirect: "/login",
        children: [
            {
                path: "/home",
                name: "Home",
                component: () => import("@/views/main/Home")
            },
            {
                path: "/record",
                name: "Record",
                component: () => import("@/views/main/Record")
            },
            {
                path: "/room",
                name: "Room",
                component: () => import("@/views/main/Room")
            },
            {
                path: "/roomType",
                name: "RoomType",
                component: () => import("@/views/main/RoomType")
            },
            {
                path: "/guest",
                name: "Guest",
                component: () => import("@/views/main/Guest")
            },
            {
                path: "/vip",
                name: "Vip",
                component: () => import("@/views/main/Vip")
            },
            {
                path: "systemSetting",
                name: "SystemSetting",
                component: () => import("@/views/main/SystemSetting")
            },
            {
                path: "personal",
                name: "Personal",
                component: () => import("@/views/main/Personal")
            },
            {
                path: "aboutUs",
                name: "AboutUs",
                component: () => import("@/views/main/AboutUs")
            }
        ]
    },
    {
        path: "/login",
        name: "Login",
        component: () => import("../views/Login")
    }
]

const router = new VueRouter({
    mode: "history",
    routes
})

export default router
