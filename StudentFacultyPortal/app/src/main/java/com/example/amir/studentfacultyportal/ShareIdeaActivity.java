package com.example.amir.studentfacultyportal;
import android.content.Intent;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import javax.xml.transform.Templates;


public class ShareIdeaActivity extends AppCompatActivity {
    Project project;
    EditText etTitle;
    EditText etDescription;
    Button btnSubmit;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shareidea);


        btnSubmit = (Button) findViewById(R.id.btn_shareidea_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                etTitle = (EditText) findViewById(R.id.et_shareidea_title);
                etDescription = (EditText) findViewById(R.id.et_shareidea_description);
                radioGroup = (RadioGroup) findViewById(R.id.rg_type);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                String type="Development";
                if(selectedId==R.id.radio_res)
                    type="Research";
                Toast.makeText(getApplicationContext(), selectedId+"",Toast.LENGTH_LONG).show();
                final String URL = "http://192.168.43.231:8888/api/Project/ShareIdea";
                Project project = new Project(etTitle.getText().toString(), etDescription.getText().toString(),type,"BCSF15M004");

                HashMap<String, String> params = new HashMap<String, String>();
                params.put("ProjectTitle", project.getTitle());
                params.put("Description", project.getDescription());
                params.put("type", project.getType());
                params.put("InitiatedBy", project.getIntiatedBy());
                final JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, URL, new JSONObject(params),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    //Process os success response
                                    Log.e("isResponse", "Success");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError e) {
                        Toast toast = Toast.makeText(ShareIdeaActivity.this, "Idea Share Successful", Toast.LENGTH_LONG);
                        toast.show();
                        Intent i = new Intent(ShareIdeaActivity.this,HomeWallActivity.class);
                        startActivity(i);
                    }
                });
                RequestQueue requestQueue = Volley.newRequestQueue(ShareIdeaActivity.this);
                requestQueue.add(request);

            }
        });
    }
}