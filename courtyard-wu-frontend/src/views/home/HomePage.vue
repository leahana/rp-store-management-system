<template>
  <!--    <p class="page-description">这是一个图片展示页面</p>-->
  <div class="posts">
    <div
        v-for="(post, index) in paginatedPosts"
        :key="index"
        :itemid="post.id"
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
</template>

<script lang="ts">
import {ref, computed} from 'vue';
import '@/assets/styles/pagination.css';

export default {
  name: 'HomePage',
  setup() {
    const {
      currentPosts,
      currentPage,
      postsPerPage,
      paginatedPosts,
      handlePageChange
    } = usePaginatedPost();
    return {
      currentPosts,
      currentPage,
      postsPerPage,
      paginatedPosts,
      handlePageChange,
      goToPost
    }
  },
  created() {
    document.title = "Courtyard-Wu";
  }
};
const usePaginatedPost = () => {
  const currentPosts = ref([
    {
      id: '1',
      image: "http://localhost:8081/c516eedc-7da0-4612-8380-562c3471d84d-iShot_2025-01-20_11.02.10.png",
      title: '美丽风景',
      description: '这是一张美丽的风景照片。'
    },
    {id: '2', image: '/assets/images/image2.jpg', title: '城市夜景', description: '都市的夜晚，光影交错。'},
    {id: '3', image: '/assets/images/image3.jpg', title: '山脉与云海', description: '壮丽的山脉与迷雾中的云海。'},
    {id: '4', image: '/assets/images/image4.jpg', title: '海边日落', description: '宁静的海滩与日落景色。'},
    {id: '5', image: '/assets/images/image5.jpg', title: '森林晨雾', description: '清晨的森林被薄雾笼罩。'},
    {id: '6', image: '/assets/images/image6.jpg', title: '雪山与湖泊', description: '雪山映衬下的湖泊景色。'},
    {id: '7', image: '/assets/images/image7.jpg', title: '夜空星轨', description: '长曝光下的星空轨迹。'},
    {id: '8', image: '/assets/images/image8.jpg', title: '城市街头', description: '繁忙的都市街头景象。'},
    {id: '9', image: '/assets/images/image9.jpg', title: '沙漠风光', description: '无尽沙丘与烈日下的沙漠景观。'}
  ]);
  const currentPage = ref(1);
  const postsPerPage = 9;

  // 计算分页后的帖子数据
  const paginatedPosts = computed(() => {
    const start = (currentPage.value - 1) * postsPerPage;
    const end = currentPage.value * postsPerPage;
    return currentPosts.value.slice(start, end);
  });

  const handlePageChange = (page: number) => {
    currentPage.value = page;
  };

  return {currentPosts, currentPage, postsPerPage, paginatedPosts, handlePageChange}
}
const goToPost = (postId: string) => {
  console.log("goToPost() postId=", postId)
};


</script>

<style scoped>

/* 九宫格样式 */
.posts {

  margin: 0 auto; /* 保持居中 */
  display: grid;
  grid-template-columns: repeat(3, 1fr); /* 默认三列 */
  grid-template-rows: repeat(3, 1fr); /* 默认三行 */
  gap: 20px;
  width: 84%;
  height: 80%;
  max-width: 100%; /* 可选: 限制最大宽度，避免过宽 */
  padding: 10px;
  justify-items: center; /* 确保卡片水平居中 */
  align-items: center; /* 确保卡片垂直居中 */
  box-sizing: border-box; /* 确保边框和内边距不影响尺寸 */
  flex-direction: column;
  justify-content: center;
  text-align: center; /* 保证文字居中 */
}


.post-card {
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  cursor: pointer;
  overflow: hidden;
  aspect-ratio: 16/9; /* 使卡片自适应 */
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  width: 95%; /* 设置固定宽度 */
  height: auto; /* 高度自适应 */
  padding: 2px; /* 控制内边距 */
}

.post-card:hover {
  transform: translateY(-10px); /* 增加悬停效果 */
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
}

.post-image {
  width: 100%;
  object-fit: cover; /* 保证图片裁剪合适，填充整个区域 */
  height: auto; /* 确保图片适配 */
  border-radius: 4px; /* 图片圆角 */
}

.post-content {
  padding: 20px; /* 增加内边距，使得文字和边缘有更多的间距 */
  font-size: 1.2em;
  font-weight: bold;
  margin: 10px 0 5px;
  color: #333;
}

.post-description {
  font-size: 0.9em;
  color: #666;
  line-height: 1.5;
  padding: 0 10px;
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
