package com.example.carlos.memoria_moviles.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.carlos.memoria_moviles.Control.Base;
import com.example.carlos.memoria_moviles.Control.DBAdapter;
import com.example.carlos.memoria_moviles.Control.UsuarioBase;
import com.example.carlos.memoria_moviles.R;

public class Puntuaciones extends Base {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //UsuarioBase user1=new UsuarioBase("foto","Rebeca","rcerdasq@gmail.com",4);
        //UsuarioBase user2=new UsuarioBase("foto","Carlos","carlosH@gmail.com",6);
        //UsuarioBase user3=new UsuarioBase("foto","Ricardo","rBove@gmail.com",10);
        //Base base=new Base();
        //base.AgregarDato(user1);
        //base.AgregarDato(user2);
        //base.AgregarDato(user3);

        LlenarListView();
    }

    private void LlenarListView() {

        String[] presidentes = {
                "Dwight D. Eisenhower",
                "John F. Kennedy",
                "Lyndon B. Johnson",
                "Richard Nixon",
                "Gerald Ford",
                "Jimmy Carter",
                "Ronald Reagan",
                "George H. W. Bush",
                "Bill Clinton",
                "George W. Bush",
                "Barack Obama"
        };

        ArrayAdapter<String> adaptador =new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, presidentes);
        ListView milistview = (ListView) findViewById(R.id.listView);
        milistview.setAdapter(adaptador);

    }



}
