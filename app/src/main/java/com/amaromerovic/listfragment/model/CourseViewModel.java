package com.amaromerovic.listfragment.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class CourseViewModel extends ViewModel {

    private final MutableLiveData<List<Course>> courses = new MutableLiveData<>();
    private final MutableLiveData<Course> course = new MutableLiveData<>();

    public LiveData<List<Course>> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courseList) {
        this.courses.setValue(courseList);
    }


    public LiveData<Course> getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course.setValue(course);
    }


}
