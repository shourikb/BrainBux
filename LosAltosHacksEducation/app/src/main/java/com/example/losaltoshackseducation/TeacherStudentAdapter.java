package com.example.losaltoshackseducation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TeacherStudentAdapter extends RecyclerView.Adapter<TeacherStudentAdapter.ViewHolder>{

    private ArrayList<String> localDataSet;

    public TeacherStudentAdapter(ArrayList<String> dataSet) {
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public TeacherStudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.teacher_goals_to_go2, viewGroup, false);

        return new TeacherStudentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherStudentAdapter.ViewHolder viewHolder, int position) {
        viewHolder.getTextView().setText(localDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;

        //declare views here
        public ViewHolder(@NonNull View view) {
            super(view);

            textView = (TextView) view.findViewById(R.id.onlyName);
        }

        public TextView getTextView() {
            return textView;
        }

    }
}
