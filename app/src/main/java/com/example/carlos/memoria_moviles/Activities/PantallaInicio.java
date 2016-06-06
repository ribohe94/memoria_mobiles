package com.example.carlos.memoria_moviles.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.carlos.memoria_moviles.R;

public class PantallaInicio extends AppCompatActivity {

    protected TextView customFont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Botón jugar
        Button btnJugar = (Button) findViewById(R.id.juego);
        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intento = new Intent(getApplicationContext(), LevelSelector.class);
                startActivity(intento);
            }

        });

        //Botón Opciones
        Button btnOpciones = (Button) findViewById(R.id.ajustes);
        btnOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent opciones = new Intent(getApplicationContext(), MenuPrincipal.class);
                startActivity(opciones);
            }

        });

        customFont=(TextView)findViewById(R.id.textView);
        Typeface font=Typeface.createFromAsset(getAssets(),"Pacifico.ttf");
        customFont.setGravity(Gravity.CENTER);
        customFont.setTypeface(font);

        customFont=(TextView)findViewById(R.id.juego);
        Typeface fonts=Typeface.createFromAsset(getAssets(),"Pacifico.ttf");
        customFont.setGravity(Gravity.CENTER);
        customFont.setTypeface(fonts);
    }

}
