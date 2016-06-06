package com.example.carlos.memoria_moviles.Control;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by rebe_ on 04/06/2016.
 */
public class Base extends AppCompatActivity {
    //Colocar en la clase Base
    DBAdapter db;

    public Base() {
    }

    public void CrearBD() {
        db = new DBAdapter(this);
        db = new DBAdapter(this);
    }

    public void Mensaje(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    };

    public void AgregarDato(UsuarioBase user) {
        db.open();
        if (db.insertDato(user) >= 0){
            Mensaje("Usuario Agregado Exitosamente");
        }

        db.close();
    }
    public void ObtenerDatos() {
        //--cargamos todos los datos---
        db.open();
        Cursor c = db.CargarTodosLosDatos();
        if (c.moveToFirst())
        {
            do {
                MostarDato(c);
            } while (c.moveToNext());
        }
        db.close();
    }
    public void ObtenerDato() {
        //---cargar un contacto ---
        db.open();
        Cursor c = db.ObtenerDato(2);
        if (c.moveToFirst())
            MostarDato(c);
        else
            Mensaje("No se encontró el dato");
        db.close();
    }

    public void BorrarDato() {
        db.open();
        if (db.BorrarDato(1))
            Mensaje("Borrado exitoso");
        else
            Mensaje("Fallo al intentar borrar");
        db.close();
    }
    public void MostarDato(Cursor c)
    {
        Mensaje("foto: " + c.getString(0) + "\n" +
                "Nombre: " + c.getString(1) + "\n" +
                "Correo: " + c.getString(2) + "\n" +
                "Puntuacion:  " + c.getString(3));
    }
}
