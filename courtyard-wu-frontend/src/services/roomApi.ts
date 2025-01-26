// src/services/articleService.ts
import {http} from '@/utils/http/http';

// 获取文章列表
export const getArticles = () => {
    return http.get('/');
};

// 创建新文章
export const createArticle = (data: Record<string, any>) => {
    return http.post('/articles', data);
};

export function fetchRooms(params) {
    return http.get('', {params});
}

export function addRoom(data) {
    return http.post('', data);
}

export function updateRoom(id, data) {
    return http.put(`${id}`, data);
}

export function deleteRoom(id) {
    return http.delete(`${id}`);
}
