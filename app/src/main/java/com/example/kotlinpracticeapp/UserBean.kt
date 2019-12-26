package com.example.kotlinpracticeapp

import android.R

class UserBean
{

    var userName :String?=null ;
    var UserSurName : R.string?=null;


    constructor(userName: String?, UserSurName: R.string?) {
        this.userName = userName
        this.UserSurName = UserSurName
    }



}