package com.ccu.server.common.shiro;

import com.ccu.server.dao.UserDao;
import com.ccu.server.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthenticatingRealm {

    @Autowired
    private UserDao userDao;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1. 将token转换为UsernamePasswordToken
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //2. 根据用户名去查找
        //String userUsername = token.getUsername();
//        String dbUsername = "admin";
//        String dbPassword = "123123";
        User user = userDao.queryByUsername(token.getUsername());
        //3. 抛出各种异常
        if (user == null || user.getUserDel() == 1){
            throw new UnknownAccountException("没有此用户");
        }
        if(user.getUserStatus() != 0){
            throw new DisabledAccountException("用户状态错误");
        }
        //4. 返回AuthenticationInfo对象
        //ByteSource salt = ByteSource.Util.bytes(dbUsername);
        //return new SimpleAuthenticationInfo(dbUsername, dbPassword, salt, getName());
        return new SimpleAuthenticationInfo(user.getUserId(), user.getPassword(), getName());
    }

}
