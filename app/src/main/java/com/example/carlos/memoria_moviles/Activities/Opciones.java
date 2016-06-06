package com.example.carlos.memoria_moviles.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.carlos.memoria_moviles.Control.Base;
import com.example.carlos.memoria_moviles.Control.DBAdapter;
import com.example.carlos.memoria_moviles.Control.UsuarioBase;
import com.example.carlos.memoria_moviles.R;

public class Opciones extends Base {

    public Opciones() {
        //this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CrearBD();
        UsuarioBase user1=new UsuarioBase("foto","Rebeca","rcerdasq@gmail.com",4);
        UsuarioBase user2=new UsuarioBase("foto","Carlos","carlosH@gmail.com",6);
        UsuarioBase user3=new UsuarioBase("foto","Ricardo","rBove@gmail.com",10);
        AgregarDato(user1);
        AgregarDato(user2);
        AgregarDato(user3);

        //LlenarListView();

    }
    //final Context context;
    private void LlenarListView() {
        ArrayAdapter<String> adaptador =new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, COLUMNAs);
        ListView milistview = (ListView) findViewById(R.id.listView2);
        milistview.setAdapter(adaptador);

    }
}
