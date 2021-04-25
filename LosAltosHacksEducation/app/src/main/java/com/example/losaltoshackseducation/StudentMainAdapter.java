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

public class StudentMainAdapter extends RecyclerView.Adapter<StudentMainAdapter.ViewHolder>{

    private ArrayList<String> localDataSet;
    private StudentMain smView;

    public StudentMainAdapter(StudentMain smView, ArrayList<String> dataSet) {
        this.smView = smView;
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public StudentMainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.button_view_row, viewGroup, false);

        return new StudentMainAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentMainAdapter.ViewHolder viewHolder, int position) {
        viewHolder.getTextView().setText(localDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final Button classes;
        private final TextView textView;

        //declare views here
        public ViewHolder(@NonNull View view) {
            super(view);

            classes = (Button) view.findViewById(R.id.className);
            textView = (TextView) view.findViewById(R.id.textView);

            classes.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    TeacherIndividualClassView.setName(getTextView().getText().toString());
                    smView.startActivity(new Intent(smView, StudentClass.class));
                }
            });
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
