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
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class HomeWallActivity extends AppCompatActivity {
    private List<Project> projectList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProjectAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homewall);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new ProjectAdapter(projectList);
        //recyclerView.setHasFixedSize(true);
        // vertical RecyclerView
        // keep movie_list_row.xml width to `match_parent`
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        // horizontal RecyclerView
        // keep movie_list_row.xml width to `wrap_content`
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);

        // adding inbuilt divider line
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL, 16));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);

        // row click listener
       /* recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Movie movie = movieList.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        */

        prepareSampleProjectData();
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


}

