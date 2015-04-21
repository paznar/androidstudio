package com.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cta on 17/04/2015.
 */
public class Juego implements Serializable
{
    private String id;
    private String titulo;
    private String genero;
    private String plataforma;
    private String descripcion;
    private int stock;
    private double valoración;
    private Date fechaLanzamiento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getValoración() {
        return valoración;
    }

    public void setValoración(double valoración) {
        this.valoración = valoración;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
}
