package com.ccu.server.controller;

import com.ccu.server.common.utils.web.AjaxResult;
import com.ccu.server.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    /**
     * 登录
     *
     * @param user 用户实体类型
     * @return 登录结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody User user){
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()){
            //1. 封装UsernamePasswordToken
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            //2. 登录认证
            try {
                currentUser.login(token);
            }catch (AuthenticationException ae){
                ae.printStackTrace();
                return AjaxResult.error(ae.getMessage(), null);
            }
        }
        return AjaxResult.success("登录成功", null);
    }

    /**
     * 退出登录
     *
     * @return 退出登录结果
     */
    @PostMapping("/logout")
    public AjaxResult logout(){
        Subject currentUser = SecurityUtils.getSubject();
        if(currentUser.isAuthenticated()){
            currentUser.logout();
        }
        return AjaxResult.success("退出成功", null);
    }

}
