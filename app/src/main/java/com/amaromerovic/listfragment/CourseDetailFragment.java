package com.amaromerovic.listfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.amaromerovic.listfragment.databinding.FragmentCourseDetailBinding;
import com.amaromerovic.listfragment.model.Course;
import com.amaromerovic.listfragment.model.CourseViewModel;


public class CourseDetailFragment extends Fragment {
    private FragmentCourseDetailBinding binding;
    private CourseViewModel courseViewModel;

    public static CourseDetailFragment newInstance() {
        return new CourseDetailFragment();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        courseViewModel = new ViewModelProvider(requireActivity()).get(CourseViewModel.class);
        Course course = courseViewModel.getCourse().getValue();

        assert course != null;
        binding.detailCourseName.setText(course.getCourseName());
        binding.detailCourseImage.setImageResource(course.getCourseImage());
        binding.detailsCourseDescription.setText("This is just a test :)");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCourseDetailBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }


}