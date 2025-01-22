<template>
  <div class="file-upload">
    <el-upload
        class="upload-demo"
        action="YOUR_UPLOAD_API_URL"
    :on-preview="handlePreview"
    :on-remove="handleRemove"
    :on-success="handleSuccess"
    :on-error="handleError"
    :before-upload="beforeUpload"
    :file-list="fileList"
    accept=".jpg, .png, .gif, .pdf"
    >
    <el-button slot="trigger" type="primary">Select File</el-button>
    <el-button slot="upload" type="success" :disabled="fileList.length === 0">Upload</el-button>
    </el-upload>
<!--    <p v-if="fileList.length">Files selected: {{ fileList.length }}</p>-->
  </div>
</template>

<script>
import { ElUpload, ElButton } from 'element-plus';

export default {
  name:"FileUpload",
  components: {
    ElUpload,
    ElButton
  },
  data() {
    return {
      fileList: [], // 存储已选择的文件
    };
  },
  methods: {
    handlePreview(file) {
      console.log("Preview file:", file);
    },
    handleRemove(file, fileList) {
      console.log("Removed file:", file);
      this.fileList = fileList;
    },
    handleSuccess(response, file, fileList) {
      console.log("Upload success:", response);
      this.fileList = fileList;
    },
    handleError(error, file, fileList) {
      console.error("Upload error:", error);
    },
    beforeUpload(file) {
      // 可以在文件上传前进行验证，例如文件大小，文件类型等
      const isValid = file.size / 1024 / 1024 < 2; // 允许上传小于2MB的文件
      if (!isValid) {
        this.$message.error('File size should be smaller than 2MB');
      }
      return isValid;
    },
  },
};
</script>

<style scoped>
.file-upload {
  width: 400px;
  margin: 20px auto;
}

.upload-demo i {
  font-size: 24px;
}
</style>