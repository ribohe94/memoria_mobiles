package com.example.carlos.memoria_moviles.Activities;

import android.widget.ImageButton;

/**
 * Created by Riccardo on 04/06/2016.
 */
public class Carta {


    public Carta(boolean faceUp, String id, ImageButton button) {
        this.faceUp = faceUp;
        this.id = id;
        this.button = button;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImageButton getButton() {
        return button;
    }

    public void setButton(ImageButton button) {
        this.button = button;
    }

    private boolean faceUp;
    private String id;
    private ImageButton button;

}
