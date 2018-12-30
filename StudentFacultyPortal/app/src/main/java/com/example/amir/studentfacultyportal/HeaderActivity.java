package com.example.amir.studentfacultyportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HeaderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.header);
        /*Button btn = findViewById(R.id.btn_shareyouridea);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(HeaderActivity.this, "SharIdea Clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(),ShareIdeaActivity.class);
                startActivity(intent);

            }
        });*/

    }
   /* public void ShareIdea(android.view.View view)
    {
        Toast.makeText(HeaderActivity.this, "SharIdea Clicked", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,ShareIdeaActivity.class);
        startActivity(intent);

    }
    public void UserProfile(android.view.View view)
    {
        Toast.makeText(HeaderActivity.this, "UserProfile", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);

    }*/


}
