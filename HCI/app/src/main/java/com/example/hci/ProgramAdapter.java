package com.example.hci;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {
    Context context;
    int[] schoolname;
    String[] description;
    int[] tag;
    int[] avatar;

    boolean viewall;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        ImageView image;
        ImageView tags;
        ToggleButton toggleButton;

        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleText);
            description = itemView.findViewById(R.id.descriptionText);
            image = itemView.findViewById(R.id.imageView);
            tags = itemView.findViewById(R.id.tagView);
            layout = itemView.findViewById(R.id.layout);
            toggleButton = itemView.findViewById(R.id.toggleButton);
            toggleButton = itemView.findViewById(R.id.toggleButton);
            toggleButton.setChecked(false);
            toggleButton.setBackgroundResource(R.drawable.favourite);
            toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked)
                        toggleButton.setBackgroundResource(R.drawable.favourited);
                    else
                        toggleButton.setBackgroundResource(R.drawable.favourite);
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    public ProgramAdapter(Context context, int[] schoolname, String[] description, int[] tags, int[] avatar, boolean viewall){
        this.context = context;
        this.schoolname = schoolname;
        this.description = description;
        this.tag = tags;
        this.avatar = avatar;
        this.viewall = viewall;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_display_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramAdapter.ViewHolder holder, int position) {
        holder.title.setText(schoolname[position]);
        holder.description.setText(description[position]);
        holder.image.setImageResource(avatar[position]);
        holder.tags.setImageResource(tag[position]);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent openThree = new Intent(view.getContext(), results_detail.class);
                openThree.putExtra("index", position);
                openThree.putExtra("viewall", viewall);
                view.getContext().startActivity(openThree);
            }
        });
    }

    @Override
    public int getItemCount() {
        return schoolname.length;
    }
}


