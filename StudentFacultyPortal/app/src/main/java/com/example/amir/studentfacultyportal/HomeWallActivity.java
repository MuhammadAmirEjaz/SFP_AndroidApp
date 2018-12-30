package com.example.amir.studentfacultyportal;
import android.content.Context;
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
import android.widget.Toast;

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


public class HomeWallActivity extends AppCompatActivity {
    private List<Project> projectList;
    private RecyclerView recyclerView;
    private ProjectAdapter projectAdapter;
    private RequestQueue pQueue;
    private String basePath;
    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homewall);
        basePath= getResources().getString(R.string.base_url);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        projectList = new ArrayList<>();
        pQueue = Volley.newRequestQueue(this);

        ParseProjectJSON();
    }

    private void ParseProjectJSON() {
        String url=basePath + "Project/GetAllProjects";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
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
                                projectAdapter =new ProjectAdapter(projectList);
                                recyclerView.setAdapter(projectAdapter);
                                projectAdapter.notifyDataSetChanged();
                            }
                            projectAdapter =new ProjectAdapter(projectList);
                            recyclerView.setAdapter(projectAdapter);
                            projectAdapter.notifyDataSetChanged();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
            }
        });
            pQueue.add(request);
    }

    public void ShareIdea(android.view.View view)
    {
        Toast.makeText(HomeWallActivity.this, "SharIdea Clicked", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,ShareIdeaActivity.class);
        startActivity(intent);

    }
    public void UserProfile(android.view.View view)
    {
        Toast.makeText(HomeWallActivity.this, "UserProfile", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
    public void Vote(android.view.View v)
    {
        int UpOrDown = 0;
        if(v.getId()==R.id.btn_upvotenewsfeed) {
            UpOrDown = 1;
            String upvotes = ((Button)v).getText().toString();
            String prevCount = upvotes.substring(upvotes.indexOf("(") + 1, upvotes.indexOf(")"));
            int count = Integer.parseInt(prevCount) + 1;
            ((Button)v).setText("Upvotes(" + count + ")");
            Log.e("Cell Button", count + "");
        }
        else if(v.getId()==R.id.btn_Downvotenewsfeed)
        {
            UpOrDown = 0;
            String downvotes = ((Button)v).getText().toString();
            String prevCount = downvotes.substring(downvotes.indexOf("(") + 1, downvotes.indexOf(")"));
            int count = Integer.parseInt(prevCount) + 1;
            ((Button)v).setText("Downvotes(" + count + ")");
        }
        String url = basePath+"/Project/VoteProject";
        Log.e("URL : ",url);
        HashMap<String, Integer> params = new HashMap<String, Integer>();
        int UserId=1;
        int Upvote=0;
        int downVote=1;
        params.put("UserId", 1);
        if(UpOrDown==0) {
            Upvote=1;
            downVote=0;
            params.put("Upvote", 0);
            params.put("DownVote", 1);
        }
        else
        {
            Upvote=0;
            downVote=1;
            params.put("Upvote", 1);
            params.put("DownVote", 0);
        }
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,new JSONObject(params),
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

                });
        String downvotes = ((Button)v).getText().toString();
        String prevCount = downvotes.substring(downvotes.indexOf("(") + 1, downvotes.indexOf(")"));
        int count = Integer.parseInt(prevCount) + 1;
        ((Button)v).setText("Downvotes(" + count + ")");

    }



}

