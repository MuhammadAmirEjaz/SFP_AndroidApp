package com.example.amir.studentfacultyportal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.ProgressDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    public Login obj = new Login();
    ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_login=(Button)findViewById(R.id.email_sign_in_button);
        btn_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText  mEmailView = findViewById(R.id.email);
                EditText mPasswordView = (EditText) findViewById(R.id.password);
                obj.Email = mEmailView.getText().toString();
                obj.Password = mPasswordView.getText().toString();
                if(obj.Email.equals("") || obj.Password.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_LONG).show();
                }
                else {
                    new ValidateUser().execute();
                }
            }
        });
    }
    private class ValidateUser extends AsyncTask<Void, Void, Boolean>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                    LiveDataProvider  liveDataProvider = new  LiveDataProvider();
                if(liveDataProvider.validateUser(obj))
                {
                    return true;
                }

                else
                {
                    return false;
                }
            }catch (Exception e){

            }
            return null;
        }

        @Override
        protected void onPostExecute(Boolean flag)
        {
            super.onPostExecute(flag);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            if(flag)
            {
                final Bundle loginInfo = new Bundle();
                loginInfo.putString("username", obj.Email);
                loginInfo.putString("password", obj.Password);
                Log.e("Login", "onCreate:LoginActivity");
                Intent intent = new Intent(getApplicationContext(), HomeWallActivity.class);
                startActivity(intent, loginInfo);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Invalide username or password", Toast.LENGTH_LONG).show();

            }
        }
    }
}
