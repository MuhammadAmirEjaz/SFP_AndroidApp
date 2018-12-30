package com.example.amir.studentfacultyportal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    private List<Project> projectList;
    private RecyclerView recyclerView;
    private ProjectAdapter projectAdapter;
    HashMap<String, String> parms ;
    private RequestQueue pQueue;
    private String basePath;

    Project project;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofilewall);
        basePath= getResources().getString(R.string.base_url);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        parms = new HashMap<String, String>();
        projectList = new ArrayList<>();
        pQueue = Volley.newRequestQueue(this);

        ParseProjectJSON();

    }

    private void ParseProjectJSON() {
        String url=basePath + "UserWall/GetProjectsByUserId";
        parms.put("UserId","1");
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(parms),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject data = response.getJSONObject("data");
                            JSONArray projArray = data.getJSONArray("ProjectList");
                            Project project;
                            for (int i = 0; i < projArray.length(); i++) {
                                JSONObject proj = projArray.getJSONObject(i);
                                String title = proj.getString("ProjectTitle");
                                String description = proj.getString("Description");
                                String intiatedBy = proj.getString("InitiatedBy");
                                String type = "Development";
                                project = new Project(title,description,type,intiatedBy);
                                projectList.add(project);

                            }
                            projectAdapter =new ProjectAdapter(projectList);
                            recyclerView.setAdapter(projectAdapter);
                            projectAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        // mAdapter = new
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        pQueue.add(request);
    }

}

