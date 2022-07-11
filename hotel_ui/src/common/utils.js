import { MessageBox } from 'element-ui';

//数组中提取属性
function getSpecificAttr(target, attr){
    let arr = []
    for(let i = 0; i < target.length; i++){
        arr[arr.length] = target[i][attr];
    }
    return arr
}

//提示信息
function delConfirm(msg, callback){
    MessageBox.confirm(msg, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
    }).then(callback)
}

export {
    getSpecificAttr,
    delConfirm
}