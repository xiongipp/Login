package com.xxh.dp.dao;

import com.xxh.dp.Domain.User;
import com.xxh.dp.utill.dbutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userDao {
    dbutils dt;
    Statement sts;
    ResultSet rs;
    User user;
    Connection connection;
    public userDao(){
        dt=new dbutils();
    }
//    先检查用户是否存在，再判断密码正确性，若都正确，返回true
    public boolean findUser(String username,String psw) throws SQLException {
        connection = dt.getConnection();
        sts=connection.createStatement();
        rs=sts.executeQuery("select * from student ");
        user=new User();
        while (rs.next()){
            String dbname=rs.getString("username");
            if(dbname.equals(username)){
             user.setId(rs.getInt("id"));
             user.setPassword(rs.getString("password"));
             user.setSalary(rs.getString("salary"));
             user.setUsername(username);
             break;
            }
        }
        if(checkPwd(user,psw)){
            return true;
        }
        return false;
    }
//    检查密码是否正确
    public  boolean checkPwd(User user,String pwd){
        if(user.getPassword().equals(pwd)){
            return true;
        }
        return false;
    }
}
