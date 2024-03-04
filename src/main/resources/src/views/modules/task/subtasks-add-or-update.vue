<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="父任务ID" prop="taskId">
      <el-input v-model="dataForm.taskId" placeholder="父任务ID"></el-input>
    </el-form-item>
    <el-form-item label="子任务名称" prop="subTaskName">
      <el-input v-model="dataForm.subTaskName" placeholder="子任务名称"></el-input>
    </el-form-item>
    <el-form-item label="子任务描述" prop="subTaskDescription">
      <el-input v-model="dataForm.subTaskDescription" placeholder="子任务描述"></el-input>
    </el-form-item>
    <el-form-item label="子任务类型" prop="subTaskType">
      <el-input v-model="dataForm.subTaskType" placeholder="子任务类型"></el-input>
    </el-form-item>
    <el-form-item label="开始时间" prop="startTime">
      <el-input v-model="dataForm.startTime" placeholder="开始时间"></el-input>
    </el-form-item>
    <el-form-item label="结束时间" prop="endTime">
      <el-input v-model="dataForm.endTime" placeholder="结束时间"></el-input>
    </el-form-item>
    <el-form-item label="任务等级" prop="level">
      <el-input v-model="dataForm.level" placeholder="任务等级"></el-input>
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
          subTaskId: 0,
          taskId: '',
          subTaskName: '',
          subTaskDescription: '',
          subTaskType: '',
          startTime: '',
          endTime: '',
          level: '',
          createTime: '',
          createdUser: '',
          updateTime: '',
          updatedUser: '',
          isDelete: ''
        },
        dataRule: {
          taskId: [
            { required: true, message: '父任务ID不能为空', trigger: 'blur' }
          ],
          subTaskName: [
            { required: true, message: '子任务名称不能为空', trigger: 'blur' }
          ],
          subTaskDescription: [
            { required: true, message: '子任务描述不能为空', trigger: 'blur' }
          ],
          subTaskType: [
            { required: true, message: '子任务类型不能为空', trigger: 'blur' }
          ],
          startTime: [
            { required: true, message: '开始时间不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '结束时间不能为空', trigger: 'blur' }
          ],
          level: [
            { required: true, message: '任务等级不能为空', trigger: 'blur' }
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
        this.dataForm.subTaskId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.subTaskId) {
            this.$http({
              url: this.$http.adornUrl(`/task/subtasks/info/${this.dataForm.subTaskId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.taskId = data.subTasks.taskId
                this.dataForm.subTaskName = data.subTasks.subTaskName
                this.dataForm.subTaskDescription = data.subTasks.subTaskDescription
                this.dataForm.subTaskType = data.subTasks.subTaskType
                this.dataForm.startTime = data.subTasks.startTime
                this.dataForm.endTime = data.subTasks.endTime
                this.dataForm.level = data.subTasks.level
                this.dataForm.createTime = data.subTasks.createTime
                this.dataForm.createdUser = data.subTasks.createdUser
                this.dataForm.updateTime = data.subTasks.updateTime
                this.dataForm.updatedUser = data.subTasks.updatedUser
                this.dataForm.isDelete = data.subTasks.isDelete
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
              url: this.$http.adornUrl(`/task/subtasks/${!this.dataForm.subTaskId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'subTaskId': this.dataForm.subTaskId || undefined,
                'taskId': this.dataForm.taskId,
                'subTaskName': this.dataForm.subTaskName,
                'subTaskDescription': this.dataForm.subTaskDescription,
                'subTaskType': this.dataForm.subTaskType,
                'startTime': this.dataForm.startTime,
                'endTime': this.dataForm.endTime,
                'level': this.dataForm.level,
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
