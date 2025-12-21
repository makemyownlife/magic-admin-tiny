<template>
  <div class="model-create-container">
    <h2>创建模型</h2>
    <el-card>
      <el-form :model="modelForm" label-width="100px">
        <el-form-item label="模型名称" required>
          <el-input v-model="modelForm.name" placeholder="请输入模型名称" />
        </el-form-item>
        <el-form-item label="模型类型" required>
          <el-select v-model="modelForm.type" placeholder="请选择模型类型">
            <el-option label="分类模型" value="classification" />
            <el-option label="回归模型" value="regression" />
            <el-option label="推荐模型" value="recommendation" />
            <el-option label="聚类模型" value="clustering" />
          </el-select>
        </el-form-item>
        <el-form-item label="模型描述">
          <el-input v-model="modelForm.description" type="textarea" :rows="4" placeholder="请输入模型描述" />
        </el-form-item>
        <el-form-item label="模型状态">
          <el-switch v-model="modelForm.status" active-value="active" inactive-value="inactive" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleSubmit">提交</el-button>
          <el-button @click="$router.go(-1)">取消</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'

const router = useRouter()

// 模型表单数据
const modelForm = ref({
  name: '',
  type: '',
  description: '',
  status: 'active'
})

// 提交表单
const handleSubmit = () => {
  // 简单的表单验证
  if (!modelForm.value.name) {
    ElMessage.error('请输入模型名称')
    return
  }
  if (!modelForm.value.type) {
    ElMessage.error('请选择模型类型')
    return
  }
  
  // 模拟提交数据
  ElMessage.success('模型创建成功！')
  console.log('模型数据:', modelForm.value)
  
  // 跳转到模型列表页面
  router.push('/domain/list')
}
</script>

<style scoped>
.model-create-container {
  padding: 20px;
}
</style>