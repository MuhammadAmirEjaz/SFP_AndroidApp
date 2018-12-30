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
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class ShareIdeaActivity extends AppCompatActivity {
    public static final String URL = "http://192.168.8.100:8888/api/Project/ShareIdea";
    Project project;
    EditText etTitle;
    EditText etDescription;
    Button btnSubmit;
    CheckBox cbType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shareidea);
        /*etTitle = (EditText) findViewById(R.id.et_shareidea_title);
        etDescription = (EditText) findViewById(R.id.et_shareidea_description);
        cbType=(CheckBox)*/
        btnSubmit = (Button) findViewById(R.id.btn_shareidea_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(ShareIdeaActivity.this, "SharIdea Clicked", Toast.LENGTH_LONG).show();
                project.Title = /*etTitle.getText().toString()*/"FYP";
                project.Description = /*etDescription.getText().toString()*/"Student Faculty Portal";

                Toast.makeText(ShareIdeaActivity.this, project.getTitle(), Toast.LENGTH_LONG).show();
                /*project.type=*/

                StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("isResponse", response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse (VolleyError e){
                        Toast toast=Toast.makeText(ShareIdeaActivity.this, "Something's not good", Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
                RequestQueue requestQueue = Volley.newRequestQueue(ShareIdeaActivity.this);
                requestQueue.add(request);
            }
            });
    }
}