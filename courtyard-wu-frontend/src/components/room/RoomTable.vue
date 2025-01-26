<template>
  <el-table
      :data="rooms"
      border
      style="width: 100%"
      @row-click="handleRowClick"
  >
    <el-table-column prop="id" label="ID" width="80"/>
    <el-table-column prop="name" label="房间名称"/>
    <el-table-column prop="description" label="描述"/>
    <el-table-column prop="status" label="状态"/>
    <el-table-column label="操作" width="180">
      <template #default="scope">
        <el-button size="mini" @click="editRoom(scope.row)">编辑</el-button>
        <el-button size="mini" type="danger" @click="deleteRoom(scope.row.id)">
          删除
        </el-button>
      </template>
    </el-table-column>
  </el-table>

  <el-pagination
      class="pagination"
      v-model:current-page="currentPage"
      :page-size="pageSize"
      :total="total"
      layout="prev, pager, next"
      @current-change="fetchData"
  />
</template>

<script lang="ts">
// import {fetchRooms, deleteRoom} from '@/services/roomApi';
import {ref} from 'vue'
import '@/assets/styles/pagination.css';

export default {
  name: 'RoomTable',
  setup() {
    const currentPage = ref(1)
    const pageSize = ref(10)
    const total = ref(10);
    const fetchData = () => {
      console.log("fetchData()...")
    }
    const rooms = []
    const handleRowClick = () => {
      console.log("handleRowClick()...")
    }
    const editRoom = (param: any) => {
      console.log("editRoom()...", param)
    }
    const deleteRoom = (id: string) => {
      console.log("deleteRoom()...", id)
    }


    return {rooms, currentPage, pageSize, total, fetchData, handleRowClick, editRoom, deleteRoom}
  }
  // props: {
  //   refresh: Boolean, // 是否刷新表格
  // },
  // data() {
  //   return {
  //     rooms: [],
  //     currentPage: 1,
  //     pageSize: 10,
  //     total: 0,
  //   };
  // },
  // watch: {
  //   refresh(val) {
  //     if (val) {
  //       this.fetchData();
  //     }
  //   },
  // },
  // methods: {
  //   async fetchData() {
  //     try {
  //       const {data} = await fetchRooms({
  //         page: this.currentPage,
  //         size: this.pageSize,
  //       });
  //       this.rooms = data.records;
  //       this.total = data.total;
  //     } catch (err) {
  //       this.$message.error('获取房间列表失败！');
  //     }
  //   },
  //   async deleteRoom(id) {
  //     try {
  //       await deleteRoom(id);
  //       this.$message.success('删除成功');
  //       await this.fetchData();
  //     } catch (err) {
  //       this.$message.error('删除失败！');
  //     }
  //   },
  //   editRoom(room) {
  //     this.$emit('edit-room', room); // 触发父组件编辑事件
  //   },
  // },
  // mounted() {
  //   this.fetchData();
  // },
};
</script>
