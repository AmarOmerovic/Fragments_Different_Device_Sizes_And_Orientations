package com.amaromerovic.listfragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.amaromerovic.listfragment.databinding.ActivityMainBinding;
import com.amaromerovic.listfragment.model.Course;
import com.amaromerovic.listfragment.model.CourseViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private CourseViewModel courseViewModel;
    private List<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        courseViewModel = new ViewModelProvider(this).get(CourseViewModel.class);

        courses = new ArrayList<>();
        Course course = new Course("FirstCourse", R.drawable.firstcourse);
        courses.add(course);
        course = new Course("SecondCourse", R.drawable.secondcourse);
        courses.add(course);
        course = new Course("ThirdCourse", R.drawable.thirdcourse);
        courses.add(course);
        course = new Course("FourthCourse", R.drawable.fourthcourse);
        courses.add(course);
        course = new Course("FifthCourse", R.drawable.fifthcourse);
        courses.add(course);
        course = new Course("SixthCourse", R.drawable.sixthcourse);
        courses.add(course);
        course = new Course("SeventhCourse", R.drawable.seventhcourse);
        courses.add(course);

        courseViewModel.setCourses(courses);

    }

}