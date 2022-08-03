package com.example.michel_house.activities;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.michel_house.R;
import com.example.michel_house.models.Room;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ProgressBar progressBar = findViewById(R.id.progressbar);
        Bundle b = getIntent().getExtras();
        Room room = (Room) b.getSerializable("room");

        ImageView imagegc = findViewById(R.id.imagegc);
        ImageView image = findViewById(R.id.image);
        TextView name = findViewById(R.id.name);
        TextView price = findViewById(R.id.price);
        TextView num_of_beds = findViewById(R.id.num_of_beds);
        TextView descreption = findViewById(R.id.descreption);

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference pathReference = storage.getReference().child(room.getImage());

        pathReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(MainActivity2.this).load(uri).into(image);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(MainActivity2.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
            }
        });

        StorageReference pathReference1 = storage.getReference().child(room.getImagegc());

        pathReference1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(MainActivity2.this).load(uri).into(imagegc);
                progressBar.setVisibility(View.GONE);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(MainActivity2.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
            }
        });
        name.setText(room.getName());
        price.setText(room.getPrice());
        num_of_beds.setText(room.getNum_of_beds());
        descreption.setText(room.getDescreption());
    }
}

