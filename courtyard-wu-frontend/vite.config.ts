import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path';
import Components from 'unplugin-vue-components/vite'
import {ElementPlusResolver} from 'unplugin-vue-components/resolvers'
// https://vite.dev/config/
export default defineConfig({
    plugins: [
        vue(),
        Components({
            resolvers: [ElementPlusResolver()]
        })],
    resolve: {
        extensions: ['.js', '.vue', '.json', '.ts'],
        alias: {
            '@': path.resolve(__dirname, './src'),
        },
    },


})


