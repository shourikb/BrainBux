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

public class TeacherClassAdapter extends RecyclerView.Adapter<TeacherClassAdapter.ViewHolder> {

    private ArrayList<String> localDataSet;
    private TeacherClassView tcView;

    public TeacherClassAdapter(TeacherClassView tcView, ArrayList<String> dataSet) {
        this.tcView = tcView;
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public TeacherClassAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.button_view_row, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherClassAdapter.ViewHolder viewHolder, int position) {
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
                    tcView.startActivity(new Intent(tcView, TeacherIndividualClassView.class));
                }
            });
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
