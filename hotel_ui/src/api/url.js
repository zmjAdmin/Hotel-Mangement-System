import qs from "qs"

const BASE_URL = "/api"

const ROOM_TYPE_URL = BASE_URL + "/roomType"
const ROOM_URL = BASE_URL + "/room"

//获取登录url
function getLoginUrl(){
    return  BASE_URL + "/login"
}

//房间类型列表url
function getRoomTypeListUrl(page, pageSize, queryCriteria){
    return ROOM_TYPE_URL + "/" + page + "/" + pageSize + "?" + qs.stringify(queryCriteria)
}
//根据主键查询房间类型
function getRoomTypeByIdUrl(id){
    return ROOM_TYPE_URL + "/" + id
}
//添加房间类型
function getAddRoomTypeUrl(){
    return ROOM_TYPE_URL
}
//修改房间类型
function getUpdateRoomTypeUrl(){
    return ROOM_TYPE_URL
}
//删除房间类型url
function getDelRoomTypeUrl(id){
    return ROOM_TYPE_URL + "/" + id
}
//批量删除房间类型
function getBatchDelRoomTypeUrl(){
    return ROOM_TYPE_URL + "/batch"
}

//获取房间列表
function getRoomListUrl(page, pageSize, queryCriteria){
    return ROOM_URL + "/" + page + "/" + pageSize + "?" + qs.stringify(queryCriteria)
}

export {
    getLoginUrl,

    getRoomTypeByIdUrl,
    getAddRoomTypeUrl,
    getRoomTypeListUrl,
    getUpdateRoomTypeUrl,
    getDelRoomTypeUrl,
    getBatchDelRoomTypeUrl,

    getRoomListUrl
}
