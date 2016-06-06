package com.example.carlos.memoria_moviles.Control;

/**
 * Created by rebe_ on 04/06/2016.
 */
public class UsuarioBase {

    static final String TABLE_NAME = "Users";
    static final String TABLE_ID = "_id";
    static final String FOTO = "foto";
    static final String NOMBRE = "nombre";
    static final String CORREO = "correo";
    static final String PUNTUACION = "puntuacion";

    static final String CREATE_DB = "create table " + TABLE_NAME +
            "( " + TABLE_ID + " integer primary key autoincrement, "+
            FOTO + " text, "+
            NOMBRE + " text, "+
            CORREO + " text, "+
            PUNTUACION + " text "+
            " )";
    private int id;
    private String foto;
    private String nombre;
    private String correo;
    private int puntuacion;

    public UsuarioBase(String foto, String nombre, String correo, int puntuacion) {
        this.foto = foto;
        this.nombre = nombre;
        this.correo = correo;
        this.puntuacion = puntuacion;
    }

    public UsuarioBase() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
