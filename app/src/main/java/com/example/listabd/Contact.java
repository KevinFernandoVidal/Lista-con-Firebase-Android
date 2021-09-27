package com.example.listabd;

public class Contact {
    private String Nombre;
    private String Apellido;
    private String Numero;

    public Contact() {
    }

    public Contact(String nombre, String apellido, String numero) {
        Nombre = nombre;
        Apellido = apellido;
        Numero = numero;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }
}
