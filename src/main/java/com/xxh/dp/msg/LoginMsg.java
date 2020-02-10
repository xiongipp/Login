package com.xxh.dp.msg;

import lombok.Data;

@Data
public class LoginMsg {
    private int state;
    private String msg;
    public LoginMsg(){
        state=-1;
        msg="初始化消息";
    }

    public void error(){
        this.state=0;
        msg="用户不存在或密码错误";
    }
    public  void succ(){
        msg="登录成功";
        this.state=2;
    }
}
