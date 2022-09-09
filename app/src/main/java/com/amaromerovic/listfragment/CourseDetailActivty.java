package com.amaromerovic.listfragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.amaromerovic.listfragment.databinding.ActivityCourseDetailActivtyBinding;

public class CourseDetailActivty extends AppCompatActivity {
    private ActivityCourseDetailActivtyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCourseDetailActivtyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        binding.detailCourseName.setText(intent.getStringExtra("CourseName"));
        binding.detailCourseImage.setImageResource(intent.getIntExtra("CourseImage", R.drawable.ic_launcher_background));
        binding.detailsCourseDescription.setText("This is just a test :)");

    }
}