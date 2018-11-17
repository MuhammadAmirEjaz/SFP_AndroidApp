package com.example.amir.studentfacultyportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class homewall extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homewall);
        Intent i=getIntent();
        Bundle loginInfo=i.getExtras();
        String username=loginInfo.getString("username");
        String password=loginInfo.getString("password");
    }
}
