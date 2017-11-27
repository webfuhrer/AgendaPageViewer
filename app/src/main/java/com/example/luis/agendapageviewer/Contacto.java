package com.example.luis.agendapageviewer;

/**
 * Created by luis on 23/11/2017.
 */

public class Contacto {
    private String nombre, telefono;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
}
