<template>
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
        />
      </el-menu-item>
      <el-menu-item index="2">包间</el-menu-item>
      <el-menu-item index="3">人物</el-menu-item>
      <el-menu-item index="5" disabled>qq群</el-menu-item>
      <el-menu-item index="6">加入我们</el-menu-item>
    </el-menu>

  </div>

  <div class="main-content">
    <p class="page-description">这是一个图片展示页面</p>
    <div class="section">
      <div class="posts">
        <div
            v-for="(post, index) in paginatedPosts"
            :key="post.id"
            :itemid="index"
            class="post-card"
            @click="goToPost(post.id)"
        >
          <img :src="post.image" alt="Post Image" class="post-image"/>
<!--          <div class="post-content">-->
<!--            <h3>{{ post.title }}</h3>-->
<!--            <p class="post-summary">{{ post.description }}</p>-->
<!--          </div>-->
        </div>
      </div>

      <el-pagination
          :current-page="currentPage"
          :page-size="postsPerPage"
          :total="currentPosts.length"
          layout="prev, pager, next"
          @current-change="handlePageChange"
          class="pagination"
      />
    </div>

  </div>
</template>

<script>
import {ref, computed} from 'vue';
import {useRouter} from 'vue-router';
// import img1 from '/images/fff1902d-5e8e-49e4-8414-7dae9f9964ff-iShot_2025-01-20_11.02.10.png'
export default {
  name: 'Home',
  setup() {
    const router = useRouter();
    const activeIndex = ref('1');
    const currentPage = ref(1);
    const postsPerPage = 9;
    const currentPosts = ref([
      {id: 1, image: "http://localhost:8081/c516eedc-7da0-4612-8380-562c3471d84d-iShot_2025-01-20_11.02.10.png", title: '美丽风景', description: '这是一张美丽的风景照片。'},
      {id: 2, image: '/assets/images/image2.jpg', title: '城市夜景', description: '都市的夜晚，光影交错。'},
      {id: 3, image: '/assets/images/image3.jpg', title: '山脉与云海', description: '壮丽的山脉与迷雾中的云海。'},
      {id: 4, image: '/assets/images/image4.jpg', title: '海边日落', description: '宁静的海滩与日落景色。'},
      {id: 5, image: '/assets/images/image5.jpg', title: '森林晨雾', description: '清晨的森林被薄雾笼罩。'},
      {id: 6, image: '/assets/images/image6.jpg', title: '雪山与湖泊', description: '雪山映衬下的湖泊景色。'},
      {id: 7, image: '/assets/images/image7.jpg', title: '夜空星轨', description: '长曝光下的星空轨迹。'},
      {id: 8, image: '/assets/images/image8.jpg', title: '城市街头', description: '繁忙的都市街头景象。'},
      {id: 9, image: '/assets/images/image9.jpg', title: '沙漠风光', description: '无尽沙丘与烈日下的沙漠景观。'}
    ]);

    // 计算分页后的帖子数据
    const paginatedPosts = computed(() => {
      const start = (currentPage.value - 1) * postsPerPage;
      const end = currentPage.value * postsPerPage;
      return currentPosts.value.slice(start, end);
    });

    const handleSelect = (index) => {
      console.log("router:", router)
      activeIndex.value = index;
      if (index === '1') {
        router.push('/');
      } else if (index === '2') {
        router.push('/room');
      } else if (index === '3') {
        router.push('/character');
      }
    };

    const goToPost = (postId) => {
      router.push({name: 'Post', params: {id: postId}});
    };

    const handlePageChange = (page) => {
      currentPage.value = page;
    };

    return {
      activeIndex,
      currentPage,
      postsPerPage,
      currentPosts,
      paginatedPosts,
      handleSelect,
      goToPost,
      handlePageChange
    };
  },
  created() {
    document.title = "Courtyard-Wu";
  }
};
</script>

<style scoped>
/*确保父级容器没有额外的空间*/
body, html {
  margin: 0;
  padding: 0;
  height: 100%;
  box-sizing: border-box; /* 防止 padding 和 border 影响布局 */
}

/* 顶部菜单容器样式 */
.header-container {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 64px; /* 根据 el-menu 高度调整 */
  z-index: 1000;
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


/* 防止 Logo 受到菜单样式的影响 */
.logo-item {
  cursor: default; /* 禁用手势样式 */
  margin-right: auto; /* 将其他菜单项推到右侧 */
  border-radius: 8px; /* 添加圆角效果 */
  display: flex; /* 保证内容居中 */
  align-items: center;
  justify-content: center;
  pointer-events: none; /* 禁止点击 */
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

.el-menu--horizontal > .el-menu-item:nth-child(2) {
  margin-left: auto; /* 从第 2 个菜单项开始，推向右侧 */

}

.page-description {
  padding: 20px;
  text-align: center;
  font-size: 1.25rem;
  margin-bottom: 40px;
  color: #777;
}

.pagination {
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  margin-top: 20px; /* 可选，调整距离页面顶部的间距 */
}


.main-content {
  width: 100%; /* 确保父容器宽度为100% */
  padding: 0; /* 防止父容器有额外的内边距 */
  margin: 0; /* 防止父容器有外边距 */
}

/* 九宫格样式 */
.posts {
  display: grid;
  grid-template-columns: repeat(3, 1fr); /* 默认三列 */
  grid-template-rows: repeat(3, 1fr); /* 默认三行 */
  gap: 20px;
  width: 88%; /* 使用视口单位，填充宽度 */
  height: 80%; /* 高度占据70%视口高度 */
  max-width: 100%; /* 可选: 限制最大宽度，避免过宽 */
  margin: 0 auto; /* 使容器居中 */
  padding: 10px;
  justify-items: center; /* 确保卡片水平居中 */
  align-items: center; /* 确保卡片垂直居中 */
  box-sizing: border-box; /* 确保边框和内边距不影响尺寸 */
}

.post-card {
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  cursor: pointer;
  overflow: hidden;
  aspect-ratio: 16/9; /* 使卡片自适应 */
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  width: 90%; /* 设置固定宽度 */
  height: auto; /* 高度自适应 */
  padding: 2px; /* 控制内边距 */
}

.post-card:hover {
  transform: translateY(-10px); /* 增加悬停效果 */
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
}

.post-image {
  width:98%;
  height: 98%; /* 增大图片的显示区域 */
  object-fit: cover; /* 保证图片裁剪合适，填充整个区域 */
}

.post-content {
  padding: 20px; /* 增加内边距，使得文字和边缘有更多的间距 */
}

.post-content h3 {
  font-size: 1.8rem; /* 增加标题的字体大小 */
  margin-bottom: 0.75rem;
}

.post-summary {
  font-size: 1.2rem; /* 增加描述的字体大小 */
  color: #555;
}

/* 响应式样式 */
@media (max-width: 768px) {
  .posts {
    grid-template-columns: repeat(2, 1fr); /* 屏幕较小时显示2列 */
  }
}

@media (max-width: 480px) {
  .posts {
    grid-template-columns: 1fr; /* 手机屏幕时显示1列 */
  }
}
</style>
