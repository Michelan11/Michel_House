package com.example.michel_house.models;

import java.io.Serializable;

public class Room implements Serializable {

        private String Image;
        private String Imagegc;
        private String Name;
        private String Num_of_beds;
        private String Price;
        private String Descreption;

        public String getImage() {
            return Image;
        }
        public String getImagegc(){ return Imagegc;}
        public String getName() {
            return Name;
        }
        public String getNum_of_beds() {
            return Num_of_beds;
        }
        public String getPrice(){ return Price;}
        public String getDescreption(){ return Descreption;}

        public Room(String image,String imagegc, String name,String num_of_beds, String price, String descreption)
        {
            this.Image = image;
            this.Imagegc = imagegc;
            this.Name = name;
            this.Num_of_beds = num_of_beds;
            this.Price = price;
            this.Descreption = descreption;

        }

    }


