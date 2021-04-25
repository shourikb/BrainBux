package com.example.losaltoshackseducation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class StudentRedeemAdapter extends RecyclerView.Adapter<StudentRedeemAdapter.ViewHolder> {

    ArrayList<String[]> localDataSet;
    StudentRedeem sr;

    public StudentRedeemAdapter(StudentRedeem sr, ArrayList<String[]> dataSet) {
        this.sr = sr;
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public StudentRedeemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.student_redeem_row, viewGroup, false);

        return new StudentRedeemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentRedeemAdapter.ViewHolder viewHolder, int position) {
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
        private final Button redeem;

        //declare views here
        public ViewHolder(@NonNull View view) {
            super(view);

            textView = (TextView) view.findViewById(R.id.rewardNameToBuy);
            redeem = (Button) view.findViewById(R.id.redeemButton);
            textView2 = (TextView) view.findViewById(R.id.expense);

            redeem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast toast = Toast.makeText(sr, "Redeem successful. You now have 0 points!", Toast.LENGTH_LONG);
                    toast.show();
                }
            });
        }

        public TextView getTextView() {
            return textView;
        }
        public TextView getTextView2() { return textView2; }

    }
}
