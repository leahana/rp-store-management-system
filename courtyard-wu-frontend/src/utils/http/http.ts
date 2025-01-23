import request from './request';

// 封装通用的请求方法
export const http = {
    get<T>(url: string, params?: Record<string, any>) {
        return request.get<T>(url, { params });
    },

    post<T>(url: string, data: Record<string, any>) {
        return request.post<T>(url, data);
    },

    put<T>(url: string, data: Record<string, any>) {
        return request.put<T>(url, data);
    },

    delete<T>(url: string) {
        return request.delete<T>(url);
    },
};
