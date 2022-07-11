import axios from "axios"
import {Message} from 'element-ui'

const E401 = "请您登录"
const E403 = "登录过期，请重新登录"
const E404 = "找不到您要访问的资源"
const E = "访问出错"

//根据环境设置地址
//axios.defaults.baseURL = "http://localhost:8081/api"
//设置超时时间
axios.defaults.timeout = 200000
// //跨域访问
axios.defaults.withCredentials = true
//设置请求头
axios.defaults.headers["Content-Type"] = "application/json;charset=UTF-8"
//axios.defaults.headers["Access-Control-Allow-Origin"] = "http://localhost:8081"
axios.defaults.transformRequest = data => JSON.stringify(data)

//设置请求拦截器，加入token
axios.interceptors.request.use(config => {
    //携带token(vuex/本地存储)
    let token = localStorage.getItem("token")
    token && (config.headers.Authorization = token)
    return config
}, error => {
    return Promise.reject(error)
})

//响应拦截器
axios.interceptors.response.use(response => {
    //只留数据部分
    // if (response.data.flag) {
    //     Message.success(response.data.msg)
    // } else {
    //     Message.error(response.data.msg)
    // }
    // return response.data.data
    return response
}, error => {
    let {response} = error
    if (response) {
        switch (response.status) {
            case 401:
                //权限
                Message.info(E401)
                this.$router.push("/login")
                break
            case 403:
                //token/session过期
                Message.info(E403)
                this.$router.push("/login")
                break
            case 404:
                //找不到页面
                Message.info(E404)
                break
            default:
                //报错
                Message.info(E)
                break
        }
    } else {
        if (!window.navigator.onLine) {
            //断网了：跳转断网也页面或者提示用户
            return
        }
        //服务器崩了
        return Promise.reject(error);
    }
})

export default axios
