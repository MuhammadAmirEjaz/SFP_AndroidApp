package com.example.amir.studentfacultyportal;

public class Project {
    public String Title;
    public String Description;
    public String type;
    public String IntiatedBy;

    public Project(String title, String description, String type, String intiatedBy) {
        Title = title;
        Description = description;
        this.type = type;
        IntiatedBy = intiatedBy;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntiatedBy() {
        return IntiatedBy;
    }

    public void setIntiatedBy(String intiatedBy) {
        IntiatedBy = intiatedBy;
    }

    }
