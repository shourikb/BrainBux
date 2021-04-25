package com.example.losaltoshackseducation;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TeacherIndividualAdapter extends RecyclerView.Adapter<TeacherIndividualAdapter.ViewHolder> {

    private ArrayList<String> localDataSet;
    private TeacherIndividualClassView ticView;

    public TeacherIndividualAdapter(TeacherIndividualClassView ticView, ArrayList<String> dataSet) {
        this.ticView = ticView;
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public TeacherIndividualAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.student_teacher_view, viewGroup, false);

        return new TeacherIndividualAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherIndividualAdapter.ViewHolder viewHolder, int position) {
        viewHolder.getTextView().setText(localDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final Button goToProfile;
        private final TextView textView;

        //declare views here
        public ViewHolder(@NonNull View view) {
            super(view);

            goToProfile = (Button) view.findViewById(R.id.toProfile);
            textView = (TextView) view.findViewById(R.id.studentName);

            goToProfile.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    TeacherIndividualClassView.setName(getTextView().getText().toString());
                    ticView.startActivity(new Intent(ticView, TeacherStudentPage.class));
                }
            });
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
