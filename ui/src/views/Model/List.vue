<template>
  <div class="model-list-container">
    <h2>模型列表</h2>
    <el-card class="mb-4">
      <el-button type="primary" @click="$router.push('/domain/create')">创建模型</el-button>
    </el-card>
    <el-card>
      <el-table :data="modelList" style="width: 100%">
        <el-table-column prop="id" label="ID" width="80" />
        <el-table-column prop="name" label="模型名称" />
        <el-table-column prop="type" label="模型类型" />
        <el-table-column prop="createTime" label="创建时间" width="180" />
        <el-table-column prop="status" label="状态" width="100">
          <template #default="scope">
            <el-tag :type="scope.row.status === 'active' ? 'success' : 'danger'">
              {{ scope.row.status === 'active' ? '启用' : '禁用' }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="200" fixed="right">
          <template #default="scope">
            <el-button size="small" @click="handleEdit(scope.row)">编辑</el-button>
            <el-button size="small" type="danger" @click="handleDelete(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'

const router = useRouter()

// 模拟模型数据
const modelList = ref([
  { id: 1, name: '用户画像模型', type: '分类模型', createTime: '2023-10-01 10:00:00', status: 'active' },
  { id: 2, name: '推荐算法模型', type: '推荐模型', createTime: '2023-10-05 14:30:00', status: 'active' },
  { id: 3, name: '风险评估模型', type: '评分模型', createTime: '2023-10-10 09:15:00', status: 'inactive' }
])

// 编辑模型
const handleEdit = (row: any) => {
  ElMessage.success(`编辑模型：${row.name}`)
  // 实际开发中可以跳转到编辑页面
  // router.push(`/domain/edit/${row.id}`)
}

// 删除模型
const handleDelete = (row: any) => {
  ElMessage.warning(`删除模型：${row.name}`)
  // 实际开发中可以添加确认对话框和删除逻辑
}
</script>

<style scoped>
.model-list-container {
  padding: 20px;
}

.mb-4 {
  margin-bottom: 20px;
}
</style>