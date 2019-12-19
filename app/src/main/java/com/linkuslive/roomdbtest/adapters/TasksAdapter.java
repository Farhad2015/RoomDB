package com.linkuslive.roomdbtest.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.linkuslive.roomdbtest.R;
import com.linkuslive.roomdbtest.models.Task;
import com.linkuslive.roomdbtest.activities.UpdateTaskActivity;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.taskViewHolder> {

    private Context context;
    private List<Task> taskList;

    public TasksAdapter(Context context, List<Task> taskList) {
        this.context = context;
        this.taskList = taskList;
    }

    public class taskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewStatus, textViewTask, textViewDesc, textViewFinishBy;

        public taskViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewStatus = itemView.findViewById(R.id.textViewStatus);
            textViewTask = itemView.findViewById(R.id.textViewTask);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
            textViewFinishBy = itemView.findViewById(R.id.textViewFinishBy);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Task task = taskList.get(getAdapterPosition());
            Intent intent = new Intent(context, UpdateTaskActivity.class);
            intent.putExtra("task", task);
            context.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public taskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_tasks, parent, false);
        return new taskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull taskViewHolder holder, int position) {
        Task t = taskList.get(position);
        holder.textViewTask.setText(t.getTask());
        holder.textViewDesc.setText(t.getDesc());
        holder.textViewFinishBy.setText(t.getFinishBy());

        if (t.isFinished())
            holder.textViewStatus.setText("Completed");
        else
            holder.textViewStatus.setText("Not Completed");
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
