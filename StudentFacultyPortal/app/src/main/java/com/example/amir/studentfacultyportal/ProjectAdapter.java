package com.example.amir.studentfacultyportal;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import com.example.amir.studentfacultyportal.Project;
import com.example.amir.studentfacultyportal.R;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.MyViewHolder>{
private List<Project> projectList;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView Title;
    public TextView Description;
    public TextView Type;
    public TextView InitiatedBy;
    public Button Upvote;
    public Button DownVote;
    public Button Bid;


    public MyViewHolder(View view) {
        super(view);
        Title = (TextView) view.findViewById(R.id.tv_newsfeedtitleshow);
        Description= (TextView) view.findViewById(R.id.tv_description_projectshow);
        Type = (TextView) view.findViewById(R.id.tv_type_project);
        InitiatedBy=(TextView) view.findViewById(R.id.tv_initiatedby_project);
        DownVote=(Button) view.findViewById(R.id.btn_upvotenewsfeed);
        Upvote=(Button)view.findViewById(R.id.btn_upvotenewsfeed);
        Upvote.setOnClickListener(this);
    }

        @Override
        public void onClick(View v) {
            String upvotes=Upvote.getText().toString();
            String prevCount = upvotes.substring(upvotes.indexOf("(")+1,upvotes.indexOf(")"));
            int count= Integer.parseInt(prevCount)+1;
          //  upvotes.replace(prevCount,count+"");
            Upvote.setText("Upvotes("+count+")");
            Log.e("Cell Button", count+"" );

        }
    }

    public ProjectAdapter(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Project project = projectList.get(position);

        holder.Title.setText(project.getTitle());
        holder.Description.setText(project.getDescription());
        holder.Type.setText(project.getType());
        holder.InitiatedBy.setText(project.getIntiatedBy());
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }
}
