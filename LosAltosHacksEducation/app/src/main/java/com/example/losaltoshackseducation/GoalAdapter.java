package com.example.losaltoshackseducation;

import android.content.DialogInterface;
import android.content.Intent;
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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.ViewHolder> {

    private ArrayList<String> localDataSet;
    private ManageGoals mg;

    public GoalAdapter(ManageGoals mg, ArrayList<String> dataSet) {
        this.mg = mg;
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.goal_view_row, viewGroup, false);

        return new GoalAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.getGoalName().setText(localDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView goalName;
        private Button edit;
        private Button delete;

        private AlertDialog.Builder alert;

        //declare views here
        public ViewHolder(@NonNull View view) {
            super(view);

            goalName = (TextView) view.findViewById(R.id.goalName);
            edit = (Button) view.findViewById(R.id.edit);
            delete = (Button) view.findViewById(R.id.delete);

            alert = new AlertDialog.Builder(mg);

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final TextView gCategory = new TextView(mg);
                    gCategory.setText("Goal Category");
                    final EditText goalCategory = new EditText(mg);
                    final TextView gName = new TextView(mg);
                    gName.setText("Goal Name");
                    final EditText goaleName = new EditText(mg);
                    final TextView gDescription = new TextView(mg);
                    gDescription.setText("Goal Description");
                    final EditText goalDesription = new EditText(mg);
                    final TextView gPV = new TextView(mg);
                    gPV.setText("Goal Point Value");
                    final EditText goalPV = new EditText(mg);

                    final LinearLayout ll = new LinearLayout(mg);
                    ll.setOrientation(LinearLayout.VERTICAL);
                    ll.addView(gCategory);
                    ll.addView(goalCategory);
                    ll.addView(gName);
                    ll.addView(goaleName);
                    ll.addView(gDescription);
                    ll.addView(goalDesription);
                    ll.addView(gPV);
                    ll.addView(goalPV);
                    alert.setView(ll);

                    alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mg.getGoals().remove(getGoalName().getText().toString());
                            mg.getGoals().add(goaleName.getText().toString());
                            mg.gAdapter.notifyDataSetChanged();
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
                    mg.getGoals().remove(goalName.getText().toString());
                    mg.gAdapter.notifyDataSetChanged();
                }
            });
        }

        public TextView getGoalName() {
            return goalName;
        }


    }
}
