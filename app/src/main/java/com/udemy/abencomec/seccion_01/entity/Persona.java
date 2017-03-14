package com.udemy.abencomec.seccion_01.entity;

import java.io.Serializable;

/**
 * Created by abencomec on 3/10/2017.
 */

public class Persona implements Serializable {

    private String nombre;
    private String email;
    private String telefono;
    private int edad;
    private boolean tipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public String getMenssage(){
        return tipo == true ? "Un coordial saludo,  me llamo " + nombre + " tengo " + edad +" a?os "
                + " mi correo es "+ email + " y mi telefono es "+telefono +" en lo que le podemos ayudar!!!!"
                : "Adios les atentido " +nombre + " tengo " + edad +" a?os "+ " mi correo es "+ email
                + " y mi telefono es "+telefono +"estamos ala orden";




    }
}
