package com.example.michel_house.activities;

import static android.content.ContentValues.TAG;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.michel_house.R;
import com.example.michel_house.adapters.RoomAdapter;
import com.example.michel_house.models.Room;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class CheckRoomsActivity extends AppCompatActivity {
    String str = "";
    RoomAdapter adapter;
    List<Room> rooms;
    RecyclerView recycler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkrooms);

        //list
        rooms = new ArrayList<Room>();

        rooms.add(new Room("samir.png",("samirgc.JPG"),"Samir's room", "This room has two beds", "Price per night is 80$","Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));
        rooms.add(new Room("joseph.png",("josephgc.JPG"), "Joseph's room", "This room has two beds", "Price per night is 80$", "Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));
        rooms.add(new Room("bassam.png",("bassamgc.JPG"), "Bassam's room", "This room has two beds", "Price per night is 80$", "Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));
        rooms.add(new Room("basilios.png",("basilgc.JPG"), "Basil's room", "This room has two beds", "Price per night is 80$", "Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));
        rooms.add(new Room("peter.png",("petergc.JPG"), "Peter's room", "This room has two beds", "Price per night is 80$", "Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));
        rooms.add(new Room("waseem.png",("wasimgc.JPG"), "Wassim's room", "This room has two beds", "Price per night is 80$", "Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));
        rooms.add(new Room("gabi.png",("gabigc.JPG"), "Gabi's room", "This room has two beds", "Price per night is 80$", "Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));
        rooms.add(new Room("locas.png",("lucasgc.JPG"), "Lucas's room", "This room has two beds", "Price per night is 80$", "Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));
        rooms.add(new Room("nabeel.png",("nabilgc.JPG"), "Nabil's room", "This room has two beds", "Price per night is 80$", "Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));
        rooms.add(new Room("ameer.png",("amirgc.JPG"), "Amir's room", "This room has two beds", "Price per night is 80$", "Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));
        rooms.add(new Room("jude.png",("joudgc.JPG"), "Jude's room", "This room has two beds", "Price per night is 80$", "Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));
        rooms.add(new Room("lydia.png",("lydiagc.JPG"), "Lydia's room", "This room has three beds", "Price per night is 80$", "Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));
        rooms.add(new Room("kareen.png",("karingc.JPG"), "Kareen's room", "This room has two beds", "Price per night is 80$", "Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));
        rooms.add(new Room("liana.png",("lianagc.JPG"), "Liana's room", "This room has two beds", "Price per night is 80$", "Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));
        rooms.add(new Room("hanan.png",("hanangc.JPG"), "Hannan's room", "This room has three beds", "Price per night is 80$", "Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));
        rooms.add(new Room("randa.png",("randagc.JPG"), "Randa's room", "This room has three beds", "Price per night is 80$", "Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));
        rooms.add(new Room("attic.png",("atticgc.JPG"), "Attic's room", "This room has two beds", "Price per night is 80$", "Includes free Wi-Fi, Air conditioning, Television ,private bathroom, extra blankets and pillows, fridge, kettle with tea and coffee , and a free limited number of refreshments."));

        //recycler view
        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(false);

        RecyclerView.LayoutManager manager = new GridLayoutManager(getApplicationContext(), 1);
        recycler.setLayoutManager(manager);
        adapter = new RoomAdapter(rooms, CheckRoomsActivity.this);
        recycler.setAdapter(adapter);
    }
    private String loadImages(String image){
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference pathReference = storage.getReference().child(image);

        pathReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Toast.makeText(CheckRoomsActivity.this, uri.toString(), Toast.LENGTH_SHORT).show();
                str = uri.toString();
                adapter.notifyDataSetChanged();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(CheckRoomsActivity.this, "Please connect to the Internet", Toast.LENGTH_SHORT).show();
            }
        });
        return str;
    }
}
