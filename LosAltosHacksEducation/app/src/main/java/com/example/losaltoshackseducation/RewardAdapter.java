package com.example.losaltoshackseducation;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RewardAdapter extends RecyclerView.Adapter<RewardAdapter.ViewHolder> {

    private ArrayList<String> localDataSet;
    private ManageRewards mr;

    public RewardAdapter(ManageRewards mr, ArrayList<String> dataSet) {
        this.mr = mr;
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.reward_view_row, viewGroup, false);

        return new RewardAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.getRewardName().setText(localDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView rewardName;
        private Button edit;
        private Button delete;

        private AlertDialog.Builder alert;

        //declare views here
        public ViewHolder(@NonNull View view) {
            super(view);

            rewardName = (TextView) view.findViewById(R.id.rewardName);
            edit = (Button) view.findViewById(R.id.rewardEdit);
            delete = (Button) view.findViewById(R.id.deleteReward);

            alert = new AlertDialog.Builder(mr);

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final TextView rCategory = new TextView(mr);
                    rCategory.setText("Reward Category");
                    final EditText rewardCategory = new EditText(mr);
                    final TextView rName = new TextView(mr);
                    rName.setText("Reward Name");
                    final EditText rewardeName = new EditText(mr);
                    final TextView rDescription = new TextView(mr);
                    rDescription.setText("Reward Description");
                    final EditText rewardDesription = new EditText(mr);
                    final TextView rPV = new TextView(mr);
                    rPV.setText("Reward Point Value");
                    final EditText rewardPV = new EditText(mr);

                    final LinearLayout ll = new LinearLayout(mr);
                    ll.setOrientation(LinearLayout.VERTICAL);
                    ll.addView(rCategory);
                    ll.addView(rewardCategory);
                    ll.addView(rName);
                    ll.addView(rewardeName);
                    ll.addView(rDescription);
                    ll.addView(rewardDesription);
                    ll.addView(rPV);
                    ll.addView(rewardPV);
                    //((ViewGroup)ll.getParent()).removeView(ll);
                    alert.setView(ll);

                    alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mr.getReward().remove(rewardName.getText().toString());
                            mr.rAdapter.notifyDataSetChanged();
                            mr.getReward().add(rewardeName.getText().toString());
                        }
                    });

                    alert.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            ((ViewGroup)ll.getParent()).removeView(ll);
                        }
                    });

                    alert.show();
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mr.getReward().remove(rewardName.getText().toString());
                    mr.rAdapter.notifyDataSetChanged();
                }
            });
        }

        public TextView getRewardName() {
            return rewardName;
        }


    }
}