package com.example.amir.studentfacultyportal;

import java.util.ArrayList;
import java.util.List;

public class LiveDataProvider {
    public ArrayList<Login> users = new ArrayList<>();
    public LiveDataProvider()
    {
        Login user = new Login("maida", "abcd");
        users.add(user);
        user = new Login("admin", "1234");
        users.add(user);
        user = new Login("hafiz", "hafiz123");
        users.add(user);
        user = new Login("amir", "amir123");
        users.add(user);
        user = new Login("aqsa", "aqsa123");
        users.add(user);
        user = new Login("fatima", "fatima123");
        users.add(user);
    }
    public boolean validateUser(Login obj)
    {

        for(int i=0; i< users.size(); i++)
        {
          if(users.get(i).Email.equals(obj.Email) &&users.get(i).Password.equals(obj.Password))
          {
                return true;
          }

        }
        return false;
    }
}
