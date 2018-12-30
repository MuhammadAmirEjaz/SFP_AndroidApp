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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class HomeWallActivity extends AppCompatActivity {
    private ArrayList<Project> projectList;
    private RecyclerView recyclerView;
    private ProjectAdapter mAdapter;
    private RequestQueue pQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homewall);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        projectList=new ArrayList<>();
        pQueue = Volley.newRequestQueue(this);
        parseJson();
    }

    private void parseJson(){
        String url = "http://192.168.43.79:8888/api/Project/f";
        Log.e("URL : ",url);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //try {
                        Log.e("msg","KKK");
                        // String str = response.getString("data");
                        //System.out.print(str);
                        Log.e("msg","KKK");
                        //} catch (JSONException e) {
                        Log.e("ERR","catch");
                        //   e.printStackTrace();
                        // }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("ERRR","err");
                        error.printStackTrace();
                    }

                }){
            @Override
            protected VolleyError parseNetworkError(VolleyError volleyError) {
                String json;
                if (volleyError.networkResponse != null && volleyError.networkResponse.data != null) {
                    try {
                        json = new String(volleyError.networkResponse.data,
                                HttpHeaderParser.parseCharset(volleyError.networkResponse.headers));
                    } catch (UnsupportedEncodingException e) {
                        return new VolleyError(e.getMessage());
                    }
                    return new VolleyError(json);
                }
                return volleyError;
            }
            @Override
            public void deliverError(VolleyError error) {
                super.deliverError(error);
            }
        };

        pQueue.add(request);

    }

    private void prepareSampleProjectData() {
        Project project = new Project("SFP", "Student Faculty Portal", "Devlopment","Muhmmad Amir");
        projectList.add(project);
        project = new Project("LMS", "Library Management System", "Devlopment","Hafiz Zahid");
        projectList.add(project);
        project = new Project("PMS", "Productivity Measurement System", "Devlopment","Maida Tayyab");
        projectList.add(project);
        project = new Project("Driver Assist", "It provides Driver Assist", "Devlopment","Hafiz Irfan");
        projectList.add(project);
        project = new Project("EatOrganic", "Buying and Selling of organic", "Devlopment","Muhmmad Amir");
        projectList.add(project);
        project = new Project("SFP", "Student Faculty Portal", "Devlopment","Muhmmad Amir");
        projectList.add(project);
        project = new Project("LMS", "Library Management System", "Devlopment","Hafiz Zahid");
        projectList.add(project);
        project = new Project("PMS", "Productivity Measurement System", "Devlopment","Maida Tayyab");
        projectList.add(project);
        project = new Project("Driver Assist", "It provides Driver Assist", "Devlopment","Hafiz Irfan");
        projectList.add(project);
        project = new Project("EatOrganic", "Buying and Selling of organic", "Devlopment","Muhmmad Amir");
        projectList.add(project);
        mAdapter.notifyDataSetChanged();
    }

}

