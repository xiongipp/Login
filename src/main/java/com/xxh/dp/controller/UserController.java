package com.xxh.dp.controller;

import com.xxh.dp.dao.userDao;
import com.xxh.dp.msg.LoginMsg;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("/login")
    public Object checkUser(String name,String pwd) throws SQLException {
//调试用
        System.out.println("==============");
        System.out.println("密码="+pwd);
        System.out.println("用户名="+name);
        System.out.println("====================");
        userDao uDao = new userDao();
        LoginMsg loginMsg = new LoginMsg();
        if(uDao.findUser(name,pwd)){
            loginMsg.succ();
        }else {
            loginMsg.error();
        }
        return loginMsg;
    }

}
