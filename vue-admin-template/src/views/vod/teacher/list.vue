<template>
  <div class="app-container">
    讲师列表
    <!--查询表单-->
    <el-card class="operate-container" shadow="never">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item label="名称">
          <el-input v-model="searchObj.name" placeholder="讲师名"/>
        </el-form-item>

        <el-form-item label="头衔">
          <el-select v-model="searchObj.level" clearable placeholder="头衔">
            <el-option value="1" label="高级讲师"/>
            <el-option value="0" label="首席讲师"/>
          </el-select>
        </el-form-item>

        <el-form-item label="入驻时间">
          <el-date-picker
            v-model="searchObj.joinDateBegin"
            placeholder="开始时间"
            value-format="yyyy-MM-dd"/>
        </el-form-item>
        <el-form-item label="-">
          <el-date-picker
            v-model="searchObj.joinDateEnd"
            placeholder="结束时间"
            value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>

        <el-button type="primary" icon="el-icon-search" @click="fetchData()">查询</el-button>
        <el-button type="default" @click="resetData()">清空</el-button>
      </el-form>
    </el-card>
    <!-- 工具按钮 -->
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">数据列表</span>
      <el-button class="btn-add" @click="add()" style="margin-left: 10px;">添加</el-button>
      <el-button class="btn-add" :disabled="isMultBtn" @click="batchRemove()">批量删除</el-button>
    </el-card>
    <!-- 表格 -->
    <el-table
      :data="list"
      border
      stripe
      @selection-change="handleSelectionChange">
      <el-table-column type="selection"/>
      <el-table-column
        label="#"
        width="50">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column prop="name" label="名称" width="80"/>
      <el-table-column label="头衔" width="90">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.level === 1" type="success" size="mini">高级讲师</el-tag>
          <el-tag v-if="scope.row.level === 0" size="mini">首席讲师</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="intro" label="简介"/>
      <el-table-column prop="sort" label="排序" width="60"/>
      <el-table-column prop="joinDate" label="入驻时间" width="160"/>
      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <el-popconfirm
            title="是否确定删除吗?"
            @onConfirm="removeById(scope.row.id)"
            @cancel=""
          >
            <el-button type="text" size="mini" slot="reference">删除</el-button>
          </el-popconfirm>
          <router-link :to="'/vod/teacher/edit/'+scope.row.id">
            <el-button type="text" size="mini">修改</el-button>
          </router-link>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      :current-page="page"
      :page-sizes="[10, 100, 300, 500]"
      :page-size="limit"
      :total="total"
      layout="total, sizes, prev, pager, next, jumper"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange">
    </el-pagination>
  </div>
</template>
<script>
// 引入定义接口的js文件
import teacherApi from '@/api/vod/teacher'

export default {
  name: "list",
  data() { // 定义变量和初始值
    return {
      list: [], // 讲师列表
      total: 0, // 总记录数
      page: 1, // 页码
      limit: 10, // 每页记录数
      searchObj: {}, // 查询条件
      isMultBtn: true,
      multipleSelection: []// 批量删除选中的记录列表
    }
  },
  created() { // 页面渲染前执行
    this.fetchData()
  },
  methods: { // 具体方法
    fetchData() {
      // 调用api
      teacherApi.pageList(this.page, this.limit, this.searchObj)
        .then(response => {
          this.list = response.data.records
          this.total = response.data.total
          console.log(this.total)
        })
        .catch(err => {
          this.$message.error(err.message)
          console.log(err)
        })
    },
    // 改变每页显示记录数
    handleSizeChange(size) {
      this.limit = size
      this.fetchData()
      console.log(`每页 ${size} 条`)
    },
    // 改变页码数
    handleCurrentChange(page) {
      this.page = page
      this.fetchData()
      console.log(`当前页: ${page}`)
    },
    // 重置表单
    resetData() {
      this.searchObj = {}
      this.fetchData()
    },
    // 讲师删除调用
    removeById(id) {
      teacherApi.removeTeacherId(id).then(response => {
        // 消息提示成功
        this.$message({
          message: '成功删除',
          type: 'success'
        })
        //  刷新页面
        this.fetchData()
      })
        .catch(response => {
          this.$message({
            message: response.message,
            type: 'error'
          })
        })
    },
    // 调转到添加的表单页面
    add() {
      this.$router.push({path: '/vod/teacher/create'})
    },
    // 批量删除
    batchRemove() {
      if (this.multipleSelection.length === 0) {
        this.$message.warning('请选择要删除的记录！')
        return
      }
      this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // 点击确定，远程调用ajax
        // 遍历selection，将id取出放入id列表
        var idList = []
        this.multipleSelection.forEach(item => {
          idList.push(item.id)
        })
        // 调用api
        return teacherApi.batchRemove(idList)
      }).then((response) => {
        this.fetchData()
        this.$message.success(response.message)
      }).catch(error => {
        if (error === 'cancel') {
          this.$message.info('取消删除')
        }
      })
    },
    // 当多选选项发生变化的时候调用
    handleSelectionChange(selection) {
      // console.log(selection)
      this.isMultBtn = false
      this.multipleSelection = selection
    }
  }
}
</script>

<style scoped>

</style>
