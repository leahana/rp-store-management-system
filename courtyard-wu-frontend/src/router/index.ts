import {createRouter, createWebHistory, RouteRecordRaw} from 'vue-router';

const routes: RouteRecordRaw[] = [
    {
        path: '/',
        component: () => import('@/layouts/MainLayout.vue'), // 主布局
        children: [
            {
                path: '', // 默认子路由
                component: () => import('@/views/home/HomePage.vue'),
            },
            {
                path: 'room',
                component: () => import('@/views/room/RoomPage.vue'),
            },
            {
                path: '/room-management',
                name: 'RoomManagement',
                component: () => import('@/views/room/RoomManagement.vue'),
            },
            {
                path: 'character',
                component: () => import('@/views/character/CharacterPage.vue'),
            },
            {
                path: 'join-us',
                component: () => import('@/views/join/JoinUs.vue'),
            },
        ],
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
