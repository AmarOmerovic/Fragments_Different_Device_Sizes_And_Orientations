package com.amaromerovic.listfragment.model;

public class Course {
    private String courseName;
    private int courseImage;

    public Course(String courseName, int courseImage) {
        this.courseName = courseName;
        this.courseImage = courseImage;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(int courseImage) {
        this.courseImage = courseImage;
    }
}
