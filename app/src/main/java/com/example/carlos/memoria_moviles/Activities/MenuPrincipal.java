package com.example.carlos.memoria_moviles.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.carlos.memoria_moviles.R;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



//Botón jugar
        Button btnJugar = (Button) findViewById(R.id.Jugar);
        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intento = new Intent(getApplicationContext(), LevelSelector.class);
                startActivity(intento);
            }

        });
//Fin del bonton jugar

//Botón MultiJugador
        Button btnMultiJugador = (Button) findViewById(R.id.MultiJugador);
        btnMultiJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent multijugador = new Intent(getApplicationContext(), MultiJugador.class);
                startActivity(multijugador);
            }

        });
//Fin del bonton MultiJugador

//Botón Puntuaciones
        Button btnPuntuaciones = (Button) findViewById(R.id.Puntuaciones);
        btnPuntuaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent puntuaciones = new Intent(getApplicationContext(), Puntuaciones.class);
                startActivity(puntuaciones);
            }

        });
//Fin del bonton Puntuaciones

//Botón Opciones
        Button btnOpciones = (Button) findViewById(R.id.Opciones);
        btnOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent opciones = new Intent(getApplicationContext(), Opciones.class);
                startActivity(opciones);
            }

        });
//Fin del bonton Opciones

//Botón Salir
        Button btnSalir = (Button) findViewById(R.id.Salir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }

        });
//Fin del bonton Salir


    }
//Fin del onCreta de la actividad


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_VerPerfil) {
            Intent intento = new Intent(getApplicationContext(), Perfil.class);
            startActivity(intento);
            return true;
        }

        return super.onOptionsItemSelected(item);
        }

    public void Mensaje(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    };


}
