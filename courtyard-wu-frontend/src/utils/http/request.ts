import axios, { AxiosInstance, AxiosRequestConfig, AxiosResponse } from 'axios';

// 创建 axios 实例
const request: AxiosInstance = axios.create({
    baseURL: import.meta.env.VITE_API_BASE_URL, // 可以在 .env 文件中配置基础 URL
    timeout: 5000, // 设置请求超时
});

// 请求拦截器：可以在请求发送之前做一些处理
request.interceptors.request.use(
    (config: AxiosRequestConfig) => {
        // 在这里添加 token 或其他请求头
        const token = localStorage.getItem('token');
        if (token) {
            config.headers['Authorization'] = `Bearer ${token}`;
        }
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);

// 响应拦截器：可以对响应进行统一处理，比如统一错误提示
request.interceptors.response.use(
    (response: AxiosResponse) => {
        // 根据返回的状态码处理不同的响应
        if (response.status === 200) {
            return response.data; // 返回响应的数据部分
        }
        return Promise.reject('请求失败');
    },
    (error) => {
        // 可以根据不同的错误类型做不同处理
        if (error.response) {
            // 服务器响应的错误信息
            console.error('Error response:', error.response);
        } else if (error.request) {
            // 请求已发出，但没有收到响应
            console.error('Error request:', error.request);
        } else {
            // 其他错误
            console.error('Error message:', error.message);
        }
        return Promise.reject(error);
    }
);

export default request;
