package com.ejercicionoticias;

import java.io.Serializable;

/**
 * Created by cta on 05/05/2015.
 */
public class Noticia implements Serializable
{
    private String titulo;
    private String fecha;
    private String enlace;

    public Noticia() {
    }

    public Noticia(String titulo, String fecha, String enlace) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.enlace = enlace;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString()
    {
        return "Noticia{" +
                "titulo='" + titulo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", enlace='" + enlace + '\'' +
                '}';
    }
}
