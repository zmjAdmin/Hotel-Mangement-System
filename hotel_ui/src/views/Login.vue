<template>
  <div id="Login">
    <div class="content">
      <div class="sys-title">
        <img src="../assets/logo.png" alt="logo">
        酒店管理系统
      </div>
      <el-form ref="form">

        <!--账号-->
        <el-form-item>
          <el-input
              placeholder="请输入账号"
              prefix-icon="el-icon-user-solid"
              v-model="user.username"
          >
          </el-input>
        </el-form-item>
        <!--密码-->
        <el-form-item>
          <el-input
              placeholder="请输入密码"
              prefix-icon="el-icon-lock"
              type="password"
              v-model="user.password"
          >
          </el-input>
        </el-form-item>
        <!--验证码-->
        <el-row>
          <el-col span="14">
            <el-form-item>
              <el-input
                  placeholder="验证码"
                  prefix-icon="el-icon-key"
                  v-model="user.checkCode"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <img class="yanzhengcode" alt="logo" src="../assets/logo.png">
        </el-row>

        <div class="remember-me">
          <el-checkbox
              label="记住我"
              v-model="user.rememberMe"
          ></el-checkbox>
        </div>

        <el-button type="primary" @click="loginHandler">
          <i :class="loginButton.loginButtonLoad" :style="loginButton.loginButtonLoadStyle"></i>
          登&ensp;&ensp;&ensp;&ensp;录
        </el-button>

      </el-form>
    </div>
  </div>
</template>

<script>

import axios from "@/api/http";
import { getLoginUrl } from "@/api/url"
import msgbox from "@/common/msgbox";

export default {
  name: "Login",
  data(){
    return {
      user: {
        username: "",
        password: "",
        rememberMe: false,
        checkCode: ""
      },
      loginButton: {
        loginButtonLoad: "",
        loginButtonLoadStyle: ""
      }
    }
  },
  methods: {
    loginHandler(){
      const loginButtonLoad = "el-icon-loading";
      const loginButtonLoadStyle = "margin-right: 20px";
      this.loginButton.loginButtonLoad = loginButtonLoad;
      this.loginButton.loginButtonLoadStyle = loginButtonLoadStyle;

      axios.post(getLoginUrl(), this.user)
          .then((response) => {
            msgbox(response)
            //页面转跳
            this.$router.push("/home")
          })

    }
  }
}
</script>

<style scoped>
#Login{
  background-color: #304964;
  height: 100vh;
}

.content{
  width: 370px;
  height: 325px;
  background-color: #fff;
  border-radius: 10px;
  position: absolute;
  top: 50%;
  left: 50%;
  margin-top: -220px;
  margin-left: -185px;
  padding: 30px;
  padding-top: 10px;
}

.sys-title{
  line-height: 60px;
  color: #707070;
  text-align: center;
  font-size: 20px;
  font-weight: 600;
  margin-bottom: 10px;
}

.sys-title img{
  height: 40px;
  vertical-align: middle;
}

.el-form .el-button{
  display: block;
  width: 100%;
}

.remember-me{
  margin-bottom: 20px;
}

.content .el-form-item{
  margin-bottom: 18px;
  margin-bottom: 18px;
}

.yanzhengcode{
  height: 40px;
  float: right;
  margin-right: 20px;
}
</style>
