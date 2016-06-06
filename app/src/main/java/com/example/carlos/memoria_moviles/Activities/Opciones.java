package com.example.carlos.memoria_moviles.Activities;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.carlos.memoria_moviles.Control.Base;
import com.example.carlos.memoria_moviles.Control.DBAdapter;
import com.example.carlos.memoria_moviles.Control.UsuarioBase;
import com.example.carlos.memoria_moviles.R;

import java.util.ArrayList;

public class Opciones extends Base {
    protected TextView customFont;
    public Opciones() {
        //this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        customFont=(TextView)findViewById(R.id.textView3);
        Typeface font=Typeface.createFromAsset(getAssets(),"Pacifico.ttf");
        customFont.setGravity(Gravity.CENTER);
        customFont.setTypeface(font);

        CrearBD();
        UsuarioBase user1=new UsuarioBase("foto","Rebeca","rcerdasq@gmail.com",4);
        //UsuarioBase user2=new UsuarioBase("foto","Carlos","carlosH@gmail.com",6);
        //UsuarioBase user3=new UsuarioBase("foto","Ricardo","rBove@gmail.com",10);
        AgregarDato(user1);
        //AgregarDato(user2);
        //AgregarDato(user3);
        ObtenerDatos();
//        BorrarDatos();

        ListView lv = (ListView) findViewById(R.id.listView2);

            lv.setAdapter(new ArrayAdapter<String>(Opciones.this,
                   android.R.layout.simple_list_item_1, COLUMNAs));



    }


}
