import {
    createRouter, createWebHistory
} from 'vue-router';
import Home from '@/views/home'
import Room from '@/views/room'

const routes = [
    // 主页
    {
        path: "/",
        name: "Home",
        component: Home,
    },
    // 房间
    {
        path: "/room",
        name: "Room",
        component: Room
    }

];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
