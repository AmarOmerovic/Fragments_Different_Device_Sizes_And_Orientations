package com.amaromerovic.listfragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amaromerovic.listfragment.databinding.CourseListItemBinding;
import com.amaromerovic.listfragment.model.Course;

import java.util.List;

public class CoursesRecyclerViewAdapter extends RecyclerView.Adapter<CoursesRecyclerViewAdapter.ViewHolder>{
    private final List<Course> courses;
    private final OnCourseClickListener onCourseClickListener;

    public CoursesRecyclerViewAdapter(List<Course> courses, OnCourseClickListener onCourseClickListener) {
        this.courses = courses;
        this.onCourseClickListener = onCourseClickListener;
    }

    @NonNull
    @Override
    public CoursesRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(CourseListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CoursesRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.binding.courseName.setText(courses.get(position).getCourseName());
        holder.binding.imageView.setImageResource(courses.get(position).getCourseImage());

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final CourseListItemBinding binding;

        public ViewHolder(@NonNull CourseListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onCourseClickListener.onCourseClicked(courses.get(getAbsoluteAdapterPosition()));
        }
    }
}
