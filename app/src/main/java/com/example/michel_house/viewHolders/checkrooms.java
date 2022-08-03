package com.example.michel_house.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.michel_house.R;

public class checkrooms extends RecyclerView.ViewHolder {

    public CardView card;
    public ImageView image;
    public ImageView imagegc;
    public ProgressBar progressBar;

    public checkrooms(@NonNull View itemView) {
        super(itemView);

        card = itemView.findViewById(R.id.cardview);
        image = itemView.findViewById(R.id.image);
        imagegc = itemView.findViewById(R.id.imagegc);
        progressBar = itemView.findViewById(R.id.progressbar);

    }
}

