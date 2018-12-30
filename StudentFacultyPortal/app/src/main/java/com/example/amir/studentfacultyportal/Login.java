package com.example.amir.studentfacultyportal;

import android.util.Log;

public class Login{
    public String UserName;
    public String Password;
    public String Email;
    public Login()
    {
        this.Email = null;
        this.Password = null;
    }
    public Login(String e, String p)
    {
        this.Email = e;
        this.Password = p;
    }
}
