package com.example.carlos.memoria_moviles.Activities;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.example.carlos.memoria_moviles.Control.CustomADHandler;
import com.example.carlos.memoria_moviles.R;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ActividadJugar extends AppCompatActivity {
    private int cardId = 0;
    private AnimationDrawable animation;
    private ArrayList<Carta> arrayCartas;
    private ArrayList<String> arrayCardNames;
    private ArrayList<Integer> arrayNumCartas;
    private ArrayList<Integer> arrayNumCartasShuffled;
    private int counter = 0;
    private int rows;
    private int cols;
    int nivel = 0;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        nivel = bundle.getInt("nivel");
        switch (nivel) {
            case 1: {
                rows = 2;
                cols = 2;
                crearNivel(2, 2);
                startChronometer();
                //animacion
                break;
            }
            case 2: {
                rows = 3;
                cols = 4;
                crearNivel(3, 4);
                startChronometer();
                break;
            }
            case 3: {
                rows = 4;
                cols = 4;
                crearNivel(4, 4);
                startChronometer();
                break;
            }
            case 4: {
                rows = 5;
                cols = 6;
                crearNivel(5, 6);
                startChronometer();
                break;
            }
            case 5: {
                rows = 6;
                cols = 6;
                crearNivel(6, 6);
                startChronometer();
                break;
            }
            case 6: {
                rows = 7;
                cols = 8;
                crearNivel(7, 8);
                startChronometer();
                break;
            }
            default: {
                Mensaje("Error al seleccionar nivel");
                break;
            }
        }

        //configurarClickListeners();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        buildNameArray();
        buildNumArray(arrayCardNames);

    }

    /*Cronometros*/
    public void startChronometer() {
        ((Chronometer) findViewById(R.id.cronometro)).start();
    }

    public void stopChronometer() {
        ((Chronometer) findViewById(R.id.cronometro)).stop();
    }

    private void crearNivel(int TableRows, int TableCols) {
        arrayCartas = new ArrayList<>(); //Array de cartas
        TableLayout table = (TableLayout) findViewById(R.id.ButtonTable); // Se crea el layout
        for (int row = 0; row < TableRows; row++) {
            TableRow newRow = new TableRow(this);
            table.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            table.addView(newRow);
            for (int col = 0; col < TableCols; col++) {
                ImageButton newImgBtn = new ImageButton(this); // Nuevo imagebutton
                Carta newCarta = new Carta(false, String.valueOf(row) + String.valueOf(col), newImgBtn); // Se crea la carta
                arrayCartas.add(newCarta); // Agregamos la carta al array
                newCarta.getButton().setLayoutParams(new TableRow.LayoutParams(
                        300,
                        450,
                        1.0f));
                configurarCarta(newCarta.getButton());
                newRow.addView(newCarta.getButton());
            }
        }
    }

    private void configurarCarta(final ImageButton newButton) {
        newButton.setBackgroundResource(R.drawable.animation);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Nota: Necesita API 21 como minimo*/
                CustomADHandler cadh = new CustomADHandler((AnimationDrawable) getResources().getDrawable(R.drawable.animation, null)) {
                    @Override
                    public void onAnimationFinish() {
                        if (counter < (rows * cols) / 2) {
                            newButton.setBackgroundResource(arrayNumCartasShuffled.get(counter++));
                        } else {
                            Collections.shuffle(arrayNumCartasShuffled);
                            counter = 0;
                            newButton.setBackgroundResource(arrayNumCartasShuffled.get(counter++));
                        }
                    }
                };
                /*Nota: Necesita API 16 como minimo*/
                newButton.setBackground(cadh);
                cadh.start();
            }
        });
    }

    private void configurarFondos() {

    }

    public Carta encontrarCarta(String row, String col) {
        for (int i = 0; i < arrayCartas.size(); i++) {
            if (arrayCartas.get(i).getId() == row + col) {
                return arrayCartas.get(i);
            }
        }
        return null;
    }

    public void Mensaje(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void buildNumArray(ArrayList<String> nameArray) {
        arrayNumCartas = new ArrayList();
        for (int i = 0; i < nameArray.size(); i++) {
            arrayNumCartas.add(getResources().getIdentifier(nameArray.get(i), "drawable", getPackageName()));
        }
        arrayNumCartasShuffled = new ArrayList<>();

        for (int i = 0; i < (rows * cols) / 2; i++) {
            arrayNumCartasShuffled.add(arrayNumCartas.get(i));
        }

        Collections.shuffle(arrayNumCartasShuffled);
    }

    public void buildNameArray() {
        arrayCardNames = new ArrayList<>();
        InputStream miarchivo = getResources().openRawResource(R.raw.img_names);
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(miarchivo));
            while ((line = br.readLine()) != null) {
                arrayCardNames.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//   @Override
//   public void onStart() {
//       super.onStart();

//       // ATTENTION: This was auto-generated to implement the App Indexing API.
//       // See https://g.co/AppIndexing/AndroidStudio for more information.
//       client.connect();
//       Action viewAction = Action.newAction(
//               Action.TYPE_VIEW, // TODO: choose an action type.
//               "ActividadJugar Page", // TODO: Define a title for the content shown.
//               // TODO: If you have web page content that matches this app activity's content,
//               // make sure this auto-generated web page URL is correct.
//               // Otherwise, set the URL to null.
//               Uri.parse("http://host/path"),
//               // TODO: Make sure this auto-generated app deep link URI is correct.
//               Uri.parse("android-app://com.example.carlos.memoria_moviles.Activities/http/host/path")
//       );
//       AppIndex.AppIndexApi.start(client, viewAction);
//   }

    //@Override
    //public void onStop() {
    //    super.onStop();
//
    //    // ATTENTION: This was auto-generated to implement the App Indexing API.
    //    // See https://g.co/AppIndexing/AndroidStudio for more information.
    //    Action viewAction = Action.newAction(
    //            Action.TYPE_VIEW, // TODO: choose an action type.
    //            "ActividadJugar Page", // TODO: Define a title for the content shown.
    //            // TODO: If you have web page content that matches this app activity's content,
    //            // make sure this auto-generated web page URL is correct.
    //            // Otherwise, set the URL to null.
    //            Uri.parse("http://host/path"),
    //            // TODO: Make sure this auto-generated app deep link URI is correct.
    //            Uri.parse("android-app://com.example.carlos.memoria_moviles.Activities/http/host/path")
    //    );
    //    AppIndex.AppIndexApi.end(client, viewAction);
    //    client.disconnect();
    //}
}


