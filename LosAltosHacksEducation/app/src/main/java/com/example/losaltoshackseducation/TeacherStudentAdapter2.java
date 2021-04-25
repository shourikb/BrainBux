package com.example.losaltoshackseducation;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TeacherStudentAdapter2 extends RecyclerView.Adapter<TeacherStudentAdapter2.ViewHolder>{

    private ArrayList<String[]> localDataSet;
    private TeacherStudentPage tsp;

    public TeacherStudentAdapter2(TeacherStudentPage tsp, ArrayList<String[]> dataSet) {
        this.tsp = tsp;
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public TeacherStudentAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.teacher_goals_to_go, viewGroup, false);

        return new TeacherStudentAdapter2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherStudentAdapter2.ViewHolder viewHolder, int position) {
        viewHolder.getTextView().setText(localDataSet.get(position)[0]);
        viewHolder.getTextView2().setText(localDataSet.get(position)[1]);
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;
        private final TextView textView2;
        private final Switch switcher;

        //declare views here
        public ViewHolder(@NonNull View view) {
            super(view);

            textView = (TextView) view.findViewById(R.id.name);
            textView2 = (TextView) view.findViewById(R.id.value);
            switcher = (Switch) view.findViewById(R.id.switch1);

            switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    tsp.getNameAndValue().remove(0);
                    tsp.adapter2.notifyDataSetChanged();
                    tsp.getOnlyName().add("Complete the extra credit worksheet");
                    tsp.adapter1.notifyDataSetChanged();
                }
            });

        }

        public TextView getTextView() {
            return textView;
        }

        public TextView getTextView2() {
            return textView2;
        }
    }
}
