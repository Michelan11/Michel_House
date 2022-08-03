package com.example.michel_house.models;

import java.io.Serializable;

public class SecPictures implements Serializable {

    private String Image2;
    private String Text2;

    public String getImage2() {
        return Image2;
    }
    public String getText2() {
        return Text2;
    }

    public SecPictures(String image2,String text2)
    {
        this.Image2 = image2;
        this.Text2 = text2;

    }

}
