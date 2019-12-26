package com.example.kotlinpracticeapp;

public class UserDataBean {

    String UserName;
    String UserSurName;

    public UserDataBean(String userName, String userSurName) {
        UserName = userName;
        UserSurName = userSurName;
    }


    public String getUserName() {
        return UserName;
    }

    public String getUserSurName() {
        return UserSurName;
    }
}
