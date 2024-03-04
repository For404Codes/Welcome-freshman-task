<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="任务名称" prop="taskName">
      <el-input v-model="dataForm.taskName" placeholder="任务名称"></el-input>
    </el-form-item>
    <el-form-item label="任务描述" prop="taskDescription">
      <el-input v-model="dataForm.taskDescription" placeholder="任务描述"></el-input>
    </el-form-item>
    <el-form-item label="任务类型" prop="taskType">
      <el-input v-model="dataForm.taskType" placeholder="任务类型"></el-input>
    </el-form-item>
    <el-form-item label="开始时间" prop="startTime">
      <el-input v-model="dataForm.startTime" placeholder="开始时间"></el-input>
    </el-form-item>
    <el-form-item label="结束时间" prop="endTime">
      <el-input v-model="dataForm.endTime" placeholder="结束时间"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="创建者用户ID" prop="createdUser">
      <el-input v-model="dataForm.createdUser" placeholder="创建者用户ID"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="更新者用户ID" prop="updatedUser">
      <el-input v-model="dataForm.updatedUser" placeholder="更新者用户ID"></el-input>
    </el-form-item>
    <el-form-item label="是否删除（1是，0否）" prop="isDelete">
      <el-input v-model="dataForm.isDelete" placeholder="是否删除（1是，0否）"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          taskId: 0,
          taskName: '',
          taskDescription: '',
          taskType: '',
          startTime: '',
          endTime: '',
          createTime: '',
          createdUser: '',
          updateTime: '',
          updatedUser: '',
          isDelete: ''
        },
        dataRule: {
          taskName: [
            { required: true, message: '任务名称不能为空', trigger: 'blur' }
          ],
          taskDescription: [
            { required: true, message: '任务描述不能为空', trigger: 'blur' }
          ],
          taskType: [
            { required: true, message: '任务类型不能为空', trigger: 'blur' }
          ],
          startTime: [
            { required: true, message: '开始时间不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '结束时间不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          createdUser: [
            { required: true, message: '创建者用户ID不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          updatedUser: [
            { required: true, message: '更新者用户ID不能为空', trigger: 'blur' }
          ],
          isDelete: [
            { required: true, message: '是否删除（1是，0否）不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.taskId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.taskId) {
            this.$http({
              url: this.$http.adornUrl(`/task/tasks/info/${this.dataForm.taskId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.taskName = data.tasks.taskName
                this.dataForm.taskDescription = data.tasks.taskDescription
                this.dataForm.taskType = data.tasks.taskType
                this.dataForm.startTime = data.tasks.startTime
                this.dataForm.endTime = data.tasks.endTime
                this.dataForm.createTime = data.tasks.createTime
                this.dataForm.createdUser = data.tasks.createdUser
                this.dataForm.updateTime = data.tasks.updateTime
                this.dataForm.updatedUser = data.tasks.updatedUser
                this.dataForm.isDelete = data.tasks.isDelete
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/task/tasks/${!this.dataForm.taskId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'taskId': this.dataForm.taskId || undefined,
                'taskName': this.dataForm.taskName,
                'taskDescription': this.dataForm.taskDescription,
                'taskType': this.dataForm.taskType,
                'startTime': this.dataForm.startTime,
                'endTime': this.dataForm.endTime,
                'createTime': this.dataForm.createTime,
                'createdUser': this.dataForm.createdUser,
                'updateTime': this.dataForm.updateTime,
                'updatedUser': this.dataForm.updatedUser,
                'isDelete': this.dataForm.isDelete
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
