package com.example.michel_house.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.michel_house.R;
import com.example.michel_house.models.SecPictures;
import com.example.michel_house.adapters.SecPicturesAdapter;

import java.util.ArrayList;
import java.util.List;

public class SecPicturesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_pictures_res);

       //list
        List<SecPictures> secPictures = new ArrayList<SecPictures>();
        secPictures.add(new SecPictures("barone.JPG","Enjoy unique enviroment"));
        secPictures.add(new SecPictures("bartwo.JPG","Calm vibes"));
        secPictures.add(new SecPictures("bareleven.jpg","Antique building"));
        secPictures.add(new SecPictures("barten.jpg","Special breakfast"));
        secPictures.add(new SecPictures("bartwelve.jpg","Great view"));
        secPictures.add(new SecPictures("barnine.jpg","Seek comfort"));
        secPictures.add(new SecPictures("bareight.jpg","in Essam's lounge"));



        //recycler view
        RecyclerView recycler = findViewById(R.id.secrecycler);
        recycler.setHasFixedSize(false);

        RecyclerView.LayoutManager manager = new GridLayoutManager(getApplicationContext(), 1);
        recycler.setLayoutManager(manager);

        SecPicturesAdapter adapter = new SecPicturesAdapter(secPictures,SecPicturesActivity.this);
        recycler.setAdapter(adapter);

    }
}