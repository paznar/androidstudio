package com.descarganoticias;

import java.io.Serializable;

/**
 * Created by cta on 05/05/2015.
 */
public class Noticia implements Serializable
{
    private String titulo;
    private String autor;
    private String enlace;

    public Noticia() {
    }

    public Noticia(String titulo, String autor, String enlace) {
        this.titulo = titulo;
        this.autor = autor;
        this.enlace = enlace;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
                ", autor='" + autor + '\'' +
                ", enlace='" + enlace + '\'' +
                '}';
    }
}
