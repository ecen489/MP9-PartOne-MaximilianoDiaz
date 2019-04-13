package com.example.mp9_partone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> courses = new ArrayList<>();
    private ArrayList<String> grades = new ArrayList<>();
    private ArrayList<String> students = new ArrayList<>();
    private Context mContext;
    private boolean printUserName;

    public RecyclerViewAdapter(boolean type, Context context, ArrayList<String> Students, ArrayList<String> Courses, ArrayList<String> Grades) {
        students = Students;
        courses = Courses;
        grades = Grades;
        mContext = context;
        printUserName = type;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called " + i);

        if (printUserName) {
            viewHolder.StudentName.setText(students.get(i) + ", ");
        }
        else {
            viewHolder.StudentName.setText("");
        }

        viewHolder.CourseName.setText(courses.get(i) + ", ");
        viewHolder.CourseGrade.setText(grades.get(i));
        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "clicked on: " + courses.get(i));
                Toast.makeText(mContext, courses.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.v("GetItemCount: ", "" + courses.size());
        return courses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView StudentName, CourseName, CourseGrade;
        View parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            StudentName = itemView.findViewById(R.id.studentView);
            CourseName = itemView.findViewById(R.id.courseView);
            CourseGrade = itemView.findViewById(R.id.gradeView);
            parentLayout = itemView;

        }
    }

}
