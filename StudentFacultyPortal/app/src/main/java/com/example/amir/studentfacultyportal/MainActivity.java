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
        Button btn_login=(Button)findViewById(R.id.email_sign_in_button);
        btn_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText  mEmailView = findViewById(R.id.email);
                EditText mPasswordView = (EditText) findViewById(R.id.password);
                String  email = mEmailView.getText().toString();
                String  pass = mPasswordView.getText().toString();
                if(email.equals("") || pass.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_LONG).show();
                }
                if(email.equals("admin") && pass.equals("admin")) {
                    final Bundle loginInfo = new Bundle();
                    loginInfo.putString("username", email);
                    loginInfo.putString("password", pass);
                    Log.e("Login", "onCreate:LoginActivity");
                    Intent intent = new Intent(v.getContext(), HomeWallActivity.class);
                    startActivity(intent, loginInfo);
                }
            }
        });
    }
}
