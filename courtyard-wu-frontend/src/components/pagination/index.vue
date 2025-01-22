<!-- src/components/Pagination.vue -->
<template>
  <div class="pagination">
    <button
        @click="changePage(currentPage - 1)"
        :disabled="currentPage === 1"
        class="pagination-button"
    >
      Previous
    </button>

    <span class="pagination-info">
      Page {{ currentPage }} of {{ totalPages }}
    </span>

    <button
        @click="changePage(currentPage + 1)"
        :disabled="currentPage===totalPages"
        class="pagination-button"
    >
      Next
    </button>
  </div>
</template>

<script>
export default {
  props: {
    currentPage: {
      type: Number,
      required: true
    },
    totalPages: {
      type: Number,
      required: true
    }
  },
  methods: {
    changePage(page) {
      this.$emit('update:currentPage', page);
    }
  }
};
</script>

<style scoped>
.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 10px;
  margin-top: 20px;
}

.pagination-button {
  padding: 10px;
  background-color: #42b883;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
}

.pagination-button:disabled {
  background-color: #d3d3d3;
}

.pagination-info {
  font-size: 16px;
  font-weight: bold;
}
</style>