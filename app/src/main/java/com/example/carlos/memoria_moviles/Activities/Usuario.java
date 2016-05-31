package com.example.carlos.memoria_moviles.Activities;


import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;


public class Usuario extends AppCompatActivity {

    ImageView picture;

    private static Usuario instance = null;

    protected Usuario() {

    }
    public static Usuario getInstance() {
        if(instance == null) {instance = new Usuario(); }
        return instance;
    }

    public ImageView getPicture() {
        return picture;
    }

    public void setPicture(ImageView picture) {
        this.picture = picture;
    }
}// fin de la clase de variables globales

