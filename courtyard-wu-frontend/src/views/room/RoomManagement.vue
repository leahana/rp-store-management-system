<template>
  <div>
    <el-row style="margin-bottom: 20px">
      <el-col :span="8">
        <el-input
            placeholder="请输入房间名称"
            v-model="searchQuery"
            clearable
        />
      </el-col>
      <el-col :span="4" offset="1">
        <el-button type="primary" @click="showAddRoomDialog">新增房间</el-button>
      </el-col>
    </el-row>

    <room-table :refresh="refresh" @edit-room="handleEditRoom"/>

    <el-dialog
        title="编辑房间"
        :visible.sync="dialogVisible"
        width="500px"
    >
      <el-form :model="currentRoom" label-width="100px">
        <el-form-item label="房间名称">
          <el-input v-model="currentRoom.name"/>
        </el-form-item>
        <el-form-item label="描述">
          <el-input v-model="currentRoom.description"/>
        </el-form-item>
        <el-form-item label="状态">
          <el-select v-model="currentRoom.status" placeholder="请选择状态">
            <el-option label="正常" value="normal"/>
            <el-option label="禁用" value="disabled"/>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="saveRoom">保存</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script lang="ts">
import {defineComponent, reactive, ref, watch} from 'vue';
import RoomTable from '@/components/room/RoomTable.vue';
import {addRoom, updateRoom} from '@/services/roomApi.js';

// 定义房间类型
interface Room {
  id?: number;
  name: string;
  description: string;
  status: 'normal' | 'disabled';
}

export default defineComponent({
  name: 'RoomManagement',
  components: {RoomTable},
  setup() {
    const searchQuery = ref('');
    const dialogVisible = ref(false);
    const currentRoom = reactive<Room>({
      name: '',
      description: '',
      status: 'normal',
    });
    const refresh = ref(false);

    const fetchRooms = () => {
      console.log('Fetching rooms with query:', searchQuery.value);
      // 调用实际的 API
    };

    const showAddRoomDialog = () => {
      currentRoom.id = undefined;
      currentRoom.name = '';
      currentRoom.description = '';
      currentRoom.status = 'normal';
      dialogVisible.value = true;
    };

    const handleEditRoom = (room: Room) => {
      Object.assign(currentRoom, room);
      dialogVisible.value = true;
    };

    const saveRoom = async () => {
      try {
        if (currentRoom.id) {
          await updateRoom(currentRoom.id, currentRoom);
        } else {
          await addRoom(currentRoom);
        }
        dialogVisible.value = false;
        refresh.value = true; // 触发表格刷新
      } catch (err) {
        console.error('保存失败：', err);
      }
    };

    // 监听 searchQuery 变化并自动调用 fetchRooms
    watch(searchQuery, (newQuery, oldQuery) => {
      console.log(`Query changed from "${oldQuery}" to "${newQuery}"`);
      fetchRooms();
    });

    return {
      searchQuery,
      dialogVisible,
      currentRoom,
      refresh,
      fetchRooms,
      showAddRoomDialog,
      handleEditRoom,
      saveRoom,
    };
  },
});
</script>
