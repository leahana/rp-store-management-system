// src/services/articleService.ts
import { http } from '@/utils/http';

// 获取文章列表
export const getArticles = () => {
    return http.get('/');
};

// 创建新文章
export const createArticle = (data: Record<string, any>) => {
    return http.post('/articles', data);
};
