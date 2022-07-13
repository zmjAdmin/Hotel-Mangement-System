<template>
  <div>

    <!--搜索区域-->
    <el-form :inline="true">
      <el-form-item
          label="姓名"
      >
        <el-input
            placeholder="请输入姓名"
            v-model="formData.guest.guestName"
        ></el-input>
      </el-form-item>
      <el-form-item
          style="margin-left: 40px"
          label="VIP卡号"
      >
        <el-input
            placeholder="请输入VIP卡号"
            v-model="formData.vipcard"
        ></el-input>
      </el-form-item>
      <el-button
          type="primary"
          style="float: right; margin-left: 20px"
          @click="search"
      >
        <i class="el-icon-search"></i>&nbsp;
        搜索
      </el-button>
      <el-button
          type="info"
          style="float: right"
          @click="reset"
      >
        <i class="el-icon-refresh"></i>&nbsp;
        重置
      </el-button>
    </el-form>

    <!--操作区域-->
    <div style="margin-bottom: 20px">
      <el-button
          type="primary"
          icon="el-icon-edit"
          :disabled="operate.editDisabled"
          @click="updateMore"
      >修改
      </el-button>
      <el-button
          type="danger"
          icon="el-icon-delete"
          :disabled="operate.delDisabled"
          @click="delMore"
      >删除
      </el-button>
      <el-button
          type="primary"
          icon="el-icon-plus"
          :disabled="operate.addDisabled"
          @click="addRoomType"
      >添加
      </el-button>
    </div>

    <!--表格区域-->
    <el-card>
      <el-table
          ref="multipleTable"
          :data="tableData"
          tooltip-effect="dark"
          style="width: 100%"
          @selection-change="handleSelectionChange"
      >
        <el-table-column
            type="selection"
            width="55">
        </el-table-column>
        <el-table-column
            type="index"
            width="50">
        </el-table-column>
        <el-table-column
            prop="guest.guestName"
            label="姓名"
        >
        </el-table-column>
        <el-table-column
            prop="guest.guestGander"
            label="性别"
        >
        </el-table-column>
        <el-table-column
            prop="vipCard"
            label="VIP卡号"
            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
            prop="vipIntegral"
            label="积分"
            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
            label="操作"
            show-overflow-tooltip
        >
          <template slot-scope="scope">
            <span
                style="text-decoration: underline; color: #1890ff; cursor: pointer"
                @click="updateHandler(scope.row.vipId)"
            ><i class="el-icon-edit"></i>&nbsp;修改 / 详情</span>
            &nbsp;&nbsp;&nbsp;
            <span
                style="text-decoration: underline; color: red; cursor: pointer"
                @click="deleteHandler(scope.row.vipId)"
            ><i class="el-icon-delete"></i>&nbsp;删除</span>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <!--分页区域-->
    <div style="margin-top: 20px">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pagination.currentPage"
          :page-sizes="[10, 20, 30]"
          :page-size="pagination.pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="pagination.total">
      </el-pagination>
    </div>

  </div>
</template>

<script>
import msgbox from "@/common/msgbox";
import axios from "@/api/http"
import { getVipListUrl } from "@/api/url"
export default {
  name: "Vip",
  data(){
    return {
      formData: {
        guest: {
          guestName: ""
        },
        vipCard: ""
      },
      operate: {
        editDisabled: true,
        delDisabled: true,
        addDisabled: false
      },
      selected: [],
      tableData: [],
      //分页
      pagination: {
        currentPage: 1,
        pageSize: 10,
        total: 0
      },
    }
  },
  methods: {
    getList(){
      axios.get(getVipListUrl(this.pagination.currentPage, this.pagination.pageSize, this.formData))
          .then((response) => {
            this.tableData = response.data.data.data
            if(this.tableData.length === 0 && this.pagination.currentPage > 1){
              this.pagination.currentPage -= 1
              this.getList()
            }else {
              this.pagination.total = response.data.data.total
              msgbox(response)
            }
          })
    },
    //搜索区域
    search(){
      this.getList()
    },
    reset(){
      for(let key in this.formData){
        this.formData[key] = ""
      }
      this.getList()
    },
    //操作区域
    updateMore(){

    },
    delMore(){

    },
    addRoomType(){

    },
    handleSelectionChange(val){
      this.selected = val
      if (val.length === 0) {
        this.operate.editDisabled = true
        this.operate.delDisabled = true
      } else if (val.length === 1) {
        this.operate.editDisabled = false
        this.operate.delDisabled = false
      } else {
        this.operate.editDisabled = true
        this.operate.delDisabled = false
      }
    },
    //表格操作区域
    updateHandler(roomId){
      console.log(roomId)
    },
    deleteHandler(roomId){
      console.log(roomId)
    },
    //分页区域
    handleSizeChange(val){
      this.pagination.currentPage = 1
      this.pagination.pageSize = val
      this.getList()
    },
    handleCurrentChange(val){
      this.pagination.currentPage = val
      this.getList()
    }
  },
  mounted(){
    this.getList()
  }
}
</script>

<style scoped>

</style>