package com.example.carlos.memoria_moviles.Control;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DBAdapter {

    static final String TABLE_NAME = "Users";
    static final String TABLE_ID = "_id";
    static final String FOTO = "foto";
    static final String NOMBRE = "nombre";
    static final String CORREO = "correo";
    static final String PUNTUACION = "puntuacion";
    static final String CREATE_DB = "create table " + TABLE_NAME +
            "( " + TABLE_ID + " integer primary key autoincrement, " +
            FOTO + " text, " +
            NOMBRE + " text, " +
            CORREO + " text, " +
            PUNTUACION + " text " +
            " )";

    public String[] getCOLUMNAS() {
        return COLUMNAS;
    }
    public String[] COLUMNAS = {
            TABLE_ID+"  "+NOMBRE+"  "+PUNTUACION
    };
    static final String TAG = "DBAdapter";
    static final String DATABASE_NAME = "MemoriaMoviles.db";
    static final int DATABASE_VERSION = 1;
    private static String DB_PATH = "/data/data/memoria_moviles/databases/";
    private String[] columnas = new String[]{TABLE_ID, FOTO, NOMBRE, CORREO, PUNTUACION};
    final Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    public DBAdapter(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_DB);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
    //---Abrimos la base datos---
    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---Cerramos la base de datos ---
    public void close() {
        DBHelper.close();
    }

    //---Insertamos un dato en la BD---
    public long insertDato(UsuarioBase user) {
        ContentValues valores = new ContentValues();
        valores.put(FOTO, user.getFoto());
        valores.put(NOMBRE, user.getNombre());
        valores.put(CORREO, user.getCorreo());
        valores.put(PUNTUACION, user.getPuntuacion());
        return db.insert(TABLE_NAME, null, valores);
    }

    //---Borramos un dato particular---
    public boolean BorrarDato(long rowId) {
        return db.delete(TABLE_NAME, TABLE_ID + "=" + rowId, null) > 0;
    }

    public void BorraarDatos() {
        db.delete(DATABASE_NAME, null, null);
    }
    //---Recuperamos todo los datos---
    public Cursor CargarTodosLosDatos() {
        return db.query(TABLE_NAME, new String[]{TABLE_ID, FOTO, NOMBRE,
                CORREO, PUNTUACION}, null, null, null, null, null);
    }

    //---recuperamos un dato particular---
    public Cursor ObtenerDato(long rowId) throws SQLException {
        Cursor mCursor =
                db.query(true, TABLE_NAME, new String[]{TABLE_ID,
                                FOTO, NOMBRE, CORREO, PUNTUACION}, TABLE_ID + "=" + rowId, null,
                        null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //---Actualizamos un dato---
    public boolean ActualizarDato(long rowId, UsuarioBase user) {
        ContentValues args = new ContentValues();
        args.put(FOTO, user.getFoto());
        args.put(NOMBRE, user.getNombre());
        args.put(CORREO, user.getCorreo());
        args.put(PUNTUACION, user.getPuntuacion());
        return db.update(
                TABLE_NAME, args, TABLE_ID + "=" + rowId, null) > 0;
    }

    public Cursor getCursor() throws SQLException {
        Cursor c = db.query(true, TABLE_NAME, columnas, null, null, null, null, null, null);

        return c;
    }

}


// FIN DE LA CLASE DatabaseHelper