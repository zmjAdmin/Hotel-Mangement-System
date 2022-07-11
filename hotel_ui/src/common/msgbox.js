import {Message} from "element-ui";

//弹窗
function msgbox(response, success, error){
    if (response.data.flag) {
        if(success === null || success === undefined || success === ""){
            Message.success(response.data.msg)
        } else {
            Message.success(success)
        }
    } else {
        if(error === null || error === undefined || error === ""){
            Message.success(response.data.msg)
        } else {
            Message.success(error)
        }
    }
}

export default msgbox
