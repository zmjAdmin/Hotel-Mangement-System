<template>
  <div>

    <!--搜索区域-->
    <el-form :inline="true">
      <el-form-item
          label="名称"
      >
        <el-input
            placeholder="请输入房间类型名称"
            v-model="formData.roomTypeName"
        ></el-input>
      </el-form-item>
      <el-form-item
          style="margin-left: 40px"
          label="日价格"
      >
        <el-input
            placeholder="请输入房间类型日价格"
            v-model="formData.dayPrice"
        ></el-input>
      </el-form-item>
      <el-form-item
          style="margin-left: 40px"
          label="4小时价格"
      >
        <el-input
            placeholder="请输入房间类型4小时价格"
            v-model="formData.hourPrice"
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
            prop="roomTypeName"
            label="房间类型名称"
        >
        </el-table-column>
        <el-table-column
            prop="roomTypeDescription"
            label="描述"
        >
        </el-table-column>
        <el-table-column
            prop="dayPrice"
            label="日价格"
            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
            prop="hourPrice"
            label="4小时价格"
            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
            label="操作"
            show-overflow-tooltip
        >
          <template slot-scope="scope">
            <span
                style="text-decoration: underline; color: #1890ff; cursor: pointer"
                @click="updateHandler(scope.row.roomTypeId)"
            ><i class="el-icon-edit"></i>&nbsp;修改 / 详情</span>
            &nbsp;&nbsp;&nbsp;
            <span
                style="text-decoration: underline; color: red; cursor: pointer"
                @click="deleteHandler(scope.row.roomTypeId)"
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

    <!--弹窗区域-->
    <el-dialog
        :visible.sync="editDialog.dialogVisible"
        :title="editDialog.title"
    >
      <el-form ref="elForm" :model="formData" size="medium" label-width="100px" :rules="editDialog.rules">
        <el-form-item label="房间类型" prop="roomTypeName">
          <el-input v-model="editDialog.formData.roomTypeName" placeholder="请输入房间类型" clearable :style="{width: '100%'}">
          </el-input>
        </el-form-item>
        <el-form-item label="日价格 " prop="dayPrice">
          <el-input v-model="editDialog.formData.dayPrice" placeholder="请输入日价格 " clearable :style="{width: '100%'}">
          </el-input>
        </el-form-item>
        <el-form-item label="4小时价格 " prop="hourPrice">
          <el-input v-model="editDialog.formData.hourPrice" placeholder="请输入4小时价格 " clearable :style="{width: '100%'}">
          </el-input>
        </el-form-item>
        <el-form-item label="描述" prop="roomTypeDescription">
          <el-input v-model="editDialog.formData.roomTypeDescription" type="textarea" placeholder="请输入描述"
                    :autosize="{minRows: 4, maxRows: 4}" :style="{width: '100%'}"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer">
        <el-button @click="editDialogClose">取消</el-button>
        <el-button type="primary" @click="editDialogConfirm">确定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import axios from "@/api/http";
import { getRoomTypeListUrl, getDelRoomTypeUrl, getBatchDelRoomTypeUrl, getRoomTypeByIdUrl, getUpdateRoomTypeUrl, getAddRoomTypeUrl } from "@/api/url"
import msgbox from "@/common/msgbox"
import { getSpecificAttr, delConfirm } from "@/common/utils"
export default {
  name: "RoomType",
  data(){
    return {
      formData: {
        roomTypeName: "",
        dayPrice: "",
        hourPrice: ""
      },
      operate: {
        editDisabled: true,
        delDisabled: true,
        addDisabled: false
      },
      tableData: [],
      selected: [],
      //分页
      pagination: {
        currentPage: 1,
        pageSize: 10,
        total: 0
      },
      //编辑弹窗
      editDialog: {
        dialogVisible: false,
        formData: {},
        flag: 0,
        title: "",
        rules: {
          roomTypeName: [
            { required: true, message: '请输入房间类型名称', trigger: 'blur' }
          ],
          dayPrice: [
            { required: true, message: '请输入日价格', trigger: 'blur' }
          ],
          hourPrice: [
            { required: true, message: '请输入4小时价格', trigger: 'blur' }
          ]
        }
      }
    }
  },
  methods: {
    getList(){
      axios.get(getRoomTypeListUrl(this.pagination.currentPage, this.pagination.pageSize, this.formData))
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
      this.updateHandler(this.selected[0].roomTypeId)
    },
    delMore(){
      delConfirm("此操作将删除这些数据, 是否继续?", () => {
        axios.delete(getBatchDelRoomTypeUrl(), {
          data: getSpecificAttr(this.selected, "roomTypeId")
        }).then((response) => {
          msgbox(response)
          this.getList()
        })
      })
    },
    addRoomType(){
      this.editDialog.title = "添加房间类型"
      this.editDialog.flag = 1
      for(let key in this.editDialog.formData){
        this.editDialog.formData[key] = ""
      }
      this.editDialog.dialogVisible = true;
    },
    //表格区域
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
    updateHandler(roomTypeId){
      this.editDialog.title = "房间类型详情"
      this.editDialog.flag = 0
      this.editDialog.formData = ""
      axios.get(getRoomTypeByIdUrl(roomTypeId))
        .then((response) => {
          this.editDialog.formData = response.data.data
        })
      this.editDialog.dialogVisible = true;
    },
    deleteHandler(roomTypeId){
      delConfirm("此操作将删除该数据, 是否继续?", () => {
        axios.delete(getDelRoomTypeUrl(roomTypeId))
            .then((response) => {
              msgbox(response)
              this.getList()
            })
      })
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
    },
    //弹窗区域
    editDialogClose(){
      this.editDialog.dialogVisible = false;
    },
    editDialogConfirm() {
      if(this.editDialog.flag === 0){
        delConfirm("此操作将修改该数据, 是否继续?", () => {
          axios.put(getUpdateRoomTypeUrl(), this.editDialog.formData)
              .then((response) => {
                msgbox(response)
                this.getList()
                this.editDialog.dialogVisible = false;
              })
        })
      }
      if(this.editDialog.flag === 1){
        delConfirm("此操作将添加房间类型, 是否继续?", () => {
          axios.post(getAddRoomTypeUrl(), this.editDialog.formData)
              .then((response) => {
                msgbox(response)
                this.getList()
                this.editDialog.dialogVisible = false;
              })
        })
      }
    }
  },
  mounted() {
    this.getList()
  }
}
</script>

<style scoped>

</style>