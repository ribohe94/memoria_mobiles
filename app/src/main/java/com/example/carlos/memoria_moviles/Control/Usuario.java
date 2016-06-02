package com.example.carlos.memoria_moviles.Control;


import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;

public class Usuario extends AppCompatActivity{
    private Bitmap profilePicture;
    private String name;
    private String email;

    private static Usuario instance = null;

    protected Usuario() {
    }
    public static Usuario getInstance() {
        if(instance == null) {instance = new Usuario(); }
        return instance;
    }

    public Bitmap getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Bitmap profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}// fin de la clase de variables globales
