package com.example.carlos.memoria_moviles.Control;


import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by Riccardo on 29/05/2016.
 */
public class ControlJuego extends AppCompatActivity {

    public ControlJuego() {

    }




    public void buildNumArray(ArrayList <String> nameArray) {
        arrayNumCartas = new ArrayList();
        for (int i = 0; i < nameArray.size(); i++) {
            arrayNumCartas.add(getResources().getIdentifier(nameArray.get(i),"drawable","com.package"));
        }
    }


    public ArrayList getArrayCardNames() {
        return arrayCardNames;
    }

    private ArrayList arrayCardNames;
    private ArrayList arrayCartas;
    private ArrayList arrayNumCartas;
};
