<template>
  <div class="main-layout">
    <div class="header-container">
      <el-menu
          :default-active="activeIndex"
          class="courtyard-wu-menu"
          mode="horizontal"
          @select="handleSelect"
      >
        <el-menu-item index="0" class="logo-item">
          <img
              style="width: 100px"
              src="@/assets/imgs/wulogo169.png"
              alt="logo"
              class="menu-logo"
              @click="returnHomePage"
          />
        </el-menu-item>
        <el-menu-item index="1">包间</el-menu-item>
        <el-menu-item index="2">人物</el-menu-item>
        <el-menu-item index="3" @click="joinQQGroup()">qq群</el-menu-item>
        <el-menu-item index="4" disabled>加入我们</el-menu-item>
        <el-menu-item index="5">房间管理</el-menu-item>
      </el-menu>
    </div>
    <!-- Slot for main content -->
    <div class="main-content">
      <router-view></router-view> <!-- 这里会根据当前路由动态展示内容 -->
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent, ref} from 'vue';
import {useRouter} from "vue-router";

export default defineComponent({
  name: 'MainLayout',
  setup() {
    const {activeIndex, handleSelect, returnHomePage, goTo} = usePushRouter()
    return {
      activeIndex, handleSelect, returnHomePage, goTo, joinQQGroup
    };


  },

  created() {
    console.log('MainLayout loaded');
    document.title = "Courtyard-Wu";
  },

});
const joinQQGroup = () => {
  const qqGroupUrl = 'https://jq.qq.com/?_wv=1027&k=xxxxxxx'; // 替换为你的QQ群链接
  window.open(qqGroupUrl, '_blank');
}

const usePushRouter = () => {
  const router = useRouter();
  const activeIndex = ref('0')
  const handleSelect = (index: string) => {
    activeIndex.value = index
    // 根据选中的菜单项跳转路由
    switch (index) {
      case '1':
        router.push('/room');
        break;
      case '2':
        router.push('/character');
        break;
      case '3':
        router.push('/qqgroup');
        break;
      case '4':
        router.push('/join-us');
        break;
      case '5':
        router.push("/room-management");
        break;
      default:
        router.push('/');
    }
  }
  const returnHomePage = () => {
    router.push("/")
  }
  const goTo = (routeName) => {
    router.push({name: routeName})
  }
  return {activeIndex, handleSelect, returnHomePage, goTo};

}
</script>


<style scoped>


/* 顶部菜单容器样式 */
.header-container {
  position: fixed; /* 固定在顶部 */
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1000; /* 保证在其他内容之上 */
  background-color: white; /* 确保背景不透明 */
  /*box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); !* 添加阴影 *!*/
  height: 64px; /* 根据 el-menu 高度调整 */
  display: flex;
  align-items: center; /* 垂直居中 */
  justify-content: center; /* 水平居中 */
}

/* el-menu 样式 */
.courtyard-wu-menu {
  width: 100%;
  display: flex;
  justify-content: center; /* 确保菜单项水平居中 */
  z-index: 1;
  align-items: center;
  border-bottom: none;
  padding: 10px;
}

.el-menu--horizontal > .el-menu-item:nth-child(2) {
  margin-left: auto; /* 从第 2 个菜单项开始，推向右侧 */

}

/* 防止 Logo 受到菜单样式的影响 */
.logo-item {
  width: 100px;
  /*cursor: default; !* 禁用手势样式 *!*/
  margin-right: auto; /* 将其他菜单项推到右侧 */
  border-radius: 8px; /* 添加圆角效果 */
  display: flex; /* 保证内容居中 */
  align-items: center;
  justify-content: center;
  /*pointer-events: none; !* 禁止点击 *!*/
}

/* 确保 Logo 可见且不受其他菜单项影响 */
.menu-logo {
  height: 60px;
  width: auto;
  display: block;
  z-index: 100;
  position: relative;
  align-self: center;
}


.main-content {
  margin-top: 64px; /* 根据 .header-container 的高度调整 */
  padding: 20px; /* 添加适当的内边距 */
  width: 100%; /* 确保父容器宽度为100% */
}
</style>
