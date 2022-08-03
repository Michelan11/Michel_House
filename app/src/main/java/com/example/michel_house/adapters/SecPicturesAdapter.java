package com.example.michel_house.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.michel_house.R;
import com.example.michel_house.models.SecPictures;
import com.example.michel_house.viewHolders.Seccheckimages;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class SecPicturesAdapter extends RecyclerView.Adapter<Seccheckimages>{

    private List<SecPictures> Secpicturess;
    private Context context;

    public SecPicturesAdapter(List<SecPictures> secpicturess, Context context) {
        Secpicturess = secpicturess;
        this.context = context;
    }

    @NonNull
    @Override
    public Seccheckimages onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.sec_pictures, parent, false);
        Seccheckimages vh = new Seccheckimages(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Seccheckimages holder, int position) {
        SecPictures SecPictures = Secpicturess.get(position);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference pathReference = storage.getReference().child(SecPictures.getImage2());

        pathReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(context).load(uri).into(holder.image2);
                holder.progressBar.setVisibility(View.GONE);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(context, "Please connect to the Internet", Toast.LENGTH_SHORT).show();
            }
        });
        holder.text2.setText(SecPictures.getText2());

    }

    @Override
    public int getItemCount() {
        return Secpicturess.size();
    }
}
