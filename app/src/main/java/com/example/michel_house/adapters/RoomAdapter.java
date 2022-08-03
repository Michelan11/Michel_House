package com.example.michel_house.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.michel_house.R;
import com.example.michel_house.activities.CheckRoomsActivity;
import com.example.michel_house.models.Room;
import com.example.michel_house.activities.MainActivity2;
import com.example.michel_house.viewHolders.checkrooms;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<checkrooms> {

    private List<Room> Rooms;
    Context context;

    public RoomAdapter(List<Room> rooms, Context context) {
        Rooms = rooms;
        this.context = context;
    }

    @NonNull
    @Override
    public checkrooms onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.room, parent, false);
        checkrooms vh = new checkrooms(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull checkrooms holder, int position) {
        Room room = Rooms.get(position);
        Log.d("TAG", "onBindViewHolder: "+room.getImage());
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference pathReference = storage.getReference().child(room.getImage());

        pathReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(context).load(uri).into(holder.image);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(context, "Please connect to the Internet", Toast.LENGTH_SHORT).show();
            }
        });

        StorageReference pathReference1 = storage.getReference().child(room.getImagegc());

        pathReference1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(context).load(uri).into(holder.imagegc);
                holder.progressBar.setVisibility(View.GONE);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(context, "No Internet Connection!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity2.class);
                i.putExtra("room", room);
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) v.getContext(),
                                holder.image, "imagetransition"
                        );
                v.getContext().startActivity(i, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return Rooms.size();
    }
}



