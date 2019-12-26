package com.example.kotlinpracticeapp.datamodels;

public class UserDataBean {

   public String UserName;
   public String UserSurName;
   public String Marks;
   public String Percentage;

    public UserDataBean(String userName, String userSurName,String marks, String percentage) {
        UserName = userName;
        UserSurName = userSurName;
        Marks=marks;
        Percentage=percentage;
    }

    public String getMarks() {
        return Marks;
    }

    public String getPercentage() {
        return Percentage;
    }

    public String getUserName() {
        return UserName;
    }

    public String getUserSurName() {
        return UserSurName;
    }
}
