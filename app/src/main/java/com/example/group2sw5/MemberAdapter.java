package com.example.group2sw5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {
    int profiles[];
    String names[];

    public MemberAdapter(int[] profiles, String[] names) {
        this.profiles = profiles;
        this.names = names;
    }

    @NonNull
    @Override
    public MemberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.member_holder, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MemberAdapter.ViewHolder holder, int position) {
        holder.memberImageView.setImageResource(profiles[position]);
        holder.nameTextView.setText(names[position]);
        holder.typeTextView.setText((names[position].equals("Exequiel Arroyo"))?"Leader" : "Member");
    }

    @Override
    public int getItemCount() {
        return profiles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView memberImageView;
        TextView nameTextView;
        TextView typeTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            memberImageView = itemView.findViewById(R.id.memberImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            typeTextView = itemView.findViewById(R.id.typeTextView);
        }
    }
}
