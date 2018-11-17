package com.example.amir.studentfacultyportal;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class ShareIdeaActivity extends AppCompatActivity implements View.OnClickListener{


    Project project;
    EditText etTitle;
    EditText etDescription;
    Button btnSubmit;
    CheckBox cbType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shareidea);
        etTitle=(EditText)findViewById(R.id.et_title_shareidea);
        etDescription=(EditText)findViewById(R.id.et_description_shareidea);
        cbType=(CheckBox)
        btnSubmit= (Button)findViewById(R.id.btn_submit_shareidea);

    }

    @Override
    public void onClick(View v) {
            project.Title=etTitle.getText().toString();
            project.Description=etDescription.getText().toString();
            project.type=
    }
}