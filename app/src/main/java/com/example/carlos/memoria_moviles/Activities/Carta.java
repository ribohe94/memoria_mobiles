package com.example.carlos.memoria_moviles.Activities;

import android.widget.ImageButton;

/**
 * Created by Riccardo on 04/06/2016.
 */
public class Carta {


    public Carta(boolean faceUp, int row, int col, ImageButton button, ImageButton buttonReverse) {
        this.faceUp = faceUp;
        this.row = row;
        this.col = col;
        this.button = button;
        this.buttonReverse = buttonReverse;
        matched = false;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public ImageButton getButton() {
        return button;
    }

    public void setButton(ImageButton button) {
        this.button = button;
    }

    public ImageButton getButtonReverse() {
        return buttonReverse;
    }

    public void setButtonReverse(ImageButton buttonReverse) {
        this.buttonReverse = buttonReverse;
    }

    private boolean faceUp;
    private boolean matched;
    private int id;
    private int row;
    private int col;
    private ImageButton button;
    private ImageButton buttonReverse;


}
