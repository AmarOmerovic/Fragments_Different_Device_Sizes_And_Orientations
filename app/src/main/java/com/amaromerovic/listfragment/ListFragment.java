package com.amaromerovic.listfragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.amaromerovic.listfragment.Util.ScreenUtility;
import com.amaromerovic.listfragment.adapter.CoursesRecyclerViewAdapter;
import com.amaromerovic.listfragment.adapter.OnCourseClickListener;
import com.amaromerovic.listfragment.databinding.ListFragmentBinding;
import com.amaromerovic.listfragment.model.Course;
import com.amaromerovic.listfragment.model.CourseViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment implements OnCourseClickListener {
    private ListFragmentBinding binding;
    private CourseViewModel courseViewModel;
    private CoursesRecyclerViewAdapter coursesRecyclerViewAdapter;
    private List<Course> courses;
    private ScreenUtility screenUtility;

    public static Fragment getInstance() {
        return new ListFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         courses = new ArrayList<>();
         screenUtility = new ScreenUtility(requireActivity());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        courseViewModel = new ViewModelProvider(requireActivity()).get(CourseViewModel.class);
        courses = courseViewModel.getCourses().getValue();

        coursesRecyclerViewAdapter = new CoursesRecyclerViewAdapter(courses, this);
        binding.recyclerViewList.setAdapter(coursesRecyclerViewAdapter);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ListFragmentBinding.inflate(inflater, container, false);

        binding.recyclerViewList.setHasFixedSize(true);
        binding.recyclerViewList.setLayoutManager(new LinearLayoutManager(getActivity()));

        return binding.getRoot();
    }

    @Override
    public void onCourseClicked(Course course) {
        courseViewModel.setCourse(course);

        Log.d("amaromerovic1234", "onCourseClicked: " + screenUtility.getWidth(requireContext()) + " " + screenUtility.getHeight(requireContext()));

        if (screenUtility.getWidth(requireContext()) >= ScreenUtility.MAX_PHONE_PORTRAIT_WIDTH && screenUtility.getHeight(requireContext()) >= ScreenUtility.MAX_PHONE_LANDSCAPE_HEIGHT) {
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.detailContainer, CourseDetailFragment.newInstance()).commit();

        } else if (screenUtility.getWidth(requireContext()) >= ScreenUtility.MAX_PHONE_PORTRAIT_WIDTH && screenUtility.getHeight(requireContext()) <= ScreenUtility.MAX_PHONE_LANDSCAPE_HEIGHT){
            if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.detailContainer, CourseDetailFragment.newInstance()).commit();
            }
        } else if (screenUtility.getWidth(requireContext()) <= ScreenUtility.MAX_PHONE_PORTRAIT_WIDTH && screenUtility.getHeight(requireContext()) >= ScreenUtility.MAX_PHONE_LANDSCAPE_HEIGHT){
            Intent intent = new Intent(getContext(), CourseDetailActivty.class);
            intent.putExtra("CourseName", course.getCourseName());
            intent.putExtra("CourseImage", course.getCourseImage());
            startActivity(intent);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
