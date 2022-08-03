package com.example.michel_house.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.michel_house.R;

public class Seccheckimages extends RecyclerView.ViewHolder {

    public CardView card2;
    public ImageView image2;
    public TextView text2;
    public ProgressBar progressBar;

    public Seccheckimages(@NonNull View itemView) {
        super(itemView);

        card2 = itemView.findViewById(R.id.cardimages);
        image2 = itemView.findViewById(R.id.barimages);
        text2 = itemView.findViewById(R.id.textimages2);
        progressBar = itemView.findViewById(R.id.progressbar);
    }
}
