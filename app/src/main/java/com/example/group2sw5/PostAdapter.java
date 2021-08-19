package com.example.group2sw5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    int post[];
    int profiles[];
    String names[];

    public PostAdapter(int[] profiles, int[] post, String[] names) {
        this.profiles = profiles;
        this.post = post;
        this.names = names;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.post_holder, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.findViewById(R.id.reactButton).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                view.findViewById(R.id.reactions).setVisibility(View.VISIBLE);
                return true;
            }
        });
        view.findViewById(R.id.reactButton2).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                view.findViewById(R.id.reactions).setVisibility(View.VISIBLE);
                return true;
            }
        });
        view.findViewById(R.id.closeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.findViewById(R.id.postHolder).setVisibility(View.GONE);
            }
        });

        CardView reactions = view.findViewById(R.id.reactions);
        ImageView reactButton = view.findViewById(R.id.reactButton);
        LottieAnimationView lottieAnimationView = view.findViewById(R.id.reactButton2);
        LottieAnimationView explosionLottieView = view.findViewById(R.id.explosionLottieView);
        view.findViewById(R.id.like).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieAnimationView.setAnimation(R.raw.like);
                lottieAnimationView.playAnimation();
                reactions.setVisibility(View.INVISIBLE);
                reactButton.setVisibility(View.INVISIBLE);
                explosionLottieView.setAnimation(R.raw.like_explosion);
                explosionLottieView.setElevation(11);
                explosionLottieView.playAnimation();
            }
        });
        view.findViewById(R.id.love).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieAnimationView.setAnimation(R.raw.love);
                lottieAnimationView.playAnimation();
                reactions.setVisibility(View.INVISIBLE);
                reactButton.setVisibility(View.INVISIBLE);
                explosionLottieView.setAnimation(R.raw.love_explosion);
                explosionLottieView.setElevation(11);
                explosionLottieView.playAnimation();
            }
        });
        view.findViewById(R.id.care).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieAnimationView.setAnimation(R.raw.care);
                lottieAnimationView.playAnimation();
                reactions.setVisibility(View.INVISIBLE);
                reactButton.setVisibility(View.INVISIBLE);
                explosionLottieView.setAnimation(R.raw.care_explosion);
                explosionLottieView.setElevation(11);
                explosionLottieView.playAnimation();
            }
        });
        view.findViewById(R.id.haha).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieAnimationView.setAnimation(R.raw.haha);
                lottieAnimationView.playAnimation();
                reactions.setVisibility(View.INVISIBLE);
                reactButton.setVisibility(View.INVISIBLE);
                explosionLottieView.setAnimation(R.raw.haha_explosion);
                explosionLottieView.setElevation(11);
                explosionLottieView.playAnimation();
            }
        });
        view.findViewById(R.id.wow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieAnimationView.setAnimation(R.raw.wow);
                lottieAnimationView.playAnimation();
                reactions.setVisibility(View.INVISIBLE);
                reactButton.setVisibility(View.INVISIBLE);
                explosionLottieView.setAnimation(R.raw.wow_explosion);
                explosionLottieView.setElevation(11);
                explosionLottieView.playAnimation();
            }
        });
        view.findViewById(R.id.sad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieAnimationView.setAnimation(R.raw.sad);
                lottieAnimationView.playAnimation();
                reactions.setVisibility(View.INVISIBLE);
                reactButton.setVisibility(View.INVISIBLE);
                explosionLottieView.setAnimation(R.raw.sad_explosion);
                explosionLottieView.setElevation(11);
                explosionLottieView.playAnimation();
            }
        });
        view.findViewById(R.id.angry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieAnimationView.setAnimation(R.raw.angry);
                lottieAnimationView.playAnimation();
                reactions.setVisibility(View.INVISIBLE);
                reactButton.setVisibility(View.INVISIBLE);
                explosionLottieView.setAnimation(R.raw.angry_explosion);
                explosionLottieView.setElevation(11);
                explosionLottieView.playAnimation();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        holder.profileImageView.setImageResource(profiles[position]);
        holder.nameTextView.setText(names[position]);
        holder.postImageView.setImageResource(post[position]);
        holder.typeTextView.setText((names[position].equals("Exequiel Arroyo")) ? "Leader" : "Member");
    }

    @Override
    public int getItemCount() {
        return post.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profileImageView;
        ImageView postImageView;
        TextView nameTextView;
        TextView typeTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImageView = itemView.findViewById(R.id.profileImageView);
            postImageView = itemView.findViewById(R.id.postImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            typeTextView = itemView.findViewById(R.id.typeTextView);
        }
    }
}
