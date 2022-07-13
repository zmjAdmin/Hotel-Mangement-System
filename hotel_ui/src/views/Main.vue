<template>
  <div id="main">
    <el-container>

      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <div class="sys-title">
          <img src="../assets/logo.png" alt="logo">
          酒店管理系统
        </div>
        <el-menu
            background-color="#304156"
            text-color="#fff"
            active-text-color="#1890ff"
            unique-opened
        >
          <router-link to="/home" active-class="myActive">
            <el-menu-item index="1" style="text-align: left"><i class="el-icon-menu"></i>&nbsp;&nbsp;首页</el-menu-item>
          </router-link>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-s-platform"></i>&nbsp;&nbsp;业务管理</template>
            <el-menu-item-group>
              <router-link to="/record" active-class="myActive">
                <el-menu-item index="2-1"><i class="el-icon-edit-outline"></i>&nbsp;&nbsp;入住记录</el-menu-item>
              </router-link>
              <router-link to="/room" active-class="myActive">
                <el-menu-item index="2-2"><i class="el-icon-s-home"></i>&nbsp;&nbsp;房间管理</el-menu-item>
              </router-link>
              <router-link to="/roomType" active-class="myActive">
                <el-menu-item index="2-3"><i class="el-icon-coin"></i>&nbsp;&nbsp;房间类型</el-menu-item>
              </router-link>
              <router-link to="/guest" active-class="myActive">
                <el-menu-item index="2-4"><i class="el-icon-s-custom"></i>&nbsp;&nbsp;顾客管理</el-menu-item>
              </router-link>
              <router-link to="/vip" active-class="myActive">
                <el-menu-item index="2-5"><i class="el-icon-star-on"></i>&nbsp;&nbsp;VIP顾客</el-menu-item>
              </router-link>
            </el-menu-item-group>
          </el-submenu>
          <router-link to="/personal" active-class="myActive">
            <el-menu-item index="3" style="text-align: left"><i class="el-icon-user"></i>&nbsp;&nbsp;个人中心</el-menu-item>
          </router-link>
          <router-link to="/aboutUs" active-class="myActive">
            <el-menu-item index="4" style="text-align: left"><i class="el-icon-s-promotion"></i>&nbsp;&nbsp;关于我们</el-menu-item>
          </router-link>
        </el-menu>
      </el-aside>

      <el-container>

        <el-header style="text-align: right; font-size: 12px">
          <el-dropdown>
            <div class="wode">
              <img class="touxiang" alt="头像" src="../assets/logo.png">
              <i class="el-icon-caret-bottom touxiangIcon"></i>
            </div>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人中心</el-dropdown-item>
              <el-dropdown-item><div @click="logout()">退出登录</div></el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-header>
        <div class="split"></div>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import axios from "@/api/http";
import { getLogoutUrl } from "@/api/url";
import msgbox from "@/common/msgbox";

export default {
  name: "Main",
  methods: {
    logout(){
      console.log("lalala")
      axios.post(getLogoutUrl())
        .then(response => {
          msgbox(response)
          this.$router.push("/login")
        })
    }
  }
}
</script>

<style scoped>
.el-header {
  background-color: #eee;
  color: #333;
  line-height: 60px;
}

.sys-title{
  line-height: 60px;
  color: #fff;
  text-align: center;
  font-size: 16px;
  font-weight: bold;
}

.sys-title img{
  height: 20px;
  vertical-align: middle;
}

.el-aside {
  color: #333;
  height: 100vh;
  background-color: #304156 !important;
}

.el-menu{
  width: 200px !important;
  border: none !important;
}

.el-container{
  border: none !important;
}

.el-main{
  height: 100vh !important;
}

.el-container .el-container{
  height: 100vh;
}

.el-menu-item{
  text-align: center;
}

.myActive .el-menu-item{
  color: #1890ff !important;
}

.split{
  height: 5px;
}

.touxiang{
  height: 30px;
  border-radius: 15px;
  margin-top: 5px;
  margin-right: 15px;
}

.el-header > *{
  float: right;
}

.touxiangIcon{
  margin-top: 30px;
}

.wode{
  cursor: pointer;
  width: 80px;
}
</style>
