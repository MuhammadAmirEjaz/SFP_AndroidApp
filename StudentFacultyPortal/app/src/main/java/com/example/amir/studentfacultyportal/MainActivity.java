package com.example.amir.studentfacultyportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_login=(Button)findViewById(R.id.btn_Submit);
        final Bundle loginInfo=new Bundle();
       /* EditText et_username=(EditText)findViewById(R.id.et_username);
        EditText et_password=(EditText)findViewById(R.id.et_password);
        String username=et_username.getText().toString();
        String password=et_password.getText().toString();

        loginInfo.putString("username",username);
        loginInfo.putString("password",password);*/
        btn_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Log.e("Login", "onCreate:LoginActivity" );
                Intent intent = new Intent(v.getContext(),HomeWallActivity.class);
                startActivity(intent,loginInfo);
        }});

    }

}
