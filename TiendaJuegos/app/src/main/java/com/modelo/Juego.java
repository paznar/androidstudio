package com.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cta on 17/04/2015.
 */
public class Juego implements Serializable
{
    private long id;
    private String titulo;
    private String genero;
    private String plataforma;
    private String descripcion;
    private int stock;
    private double valoración;
    private Date fechaLanzamiento;
    private int idCaratula;
    private int idCaratulaDescripcion;

    public Juego(long id,
                 String titulo,
                 String genero,
                 String plataforma,
                 String descripcion,
                 int idCaratula,
                 int idCaratulaDescripcion)
    {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.descripcion = descripcion;
        this.idCaratula = idCaratula;
        this.idCaratulaDescripcion = idCaratulaDescripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getIdCaratula() {
        return idCaratula;
    }

    public void setIdCaratula(int idCaratula) {
        this.idCaratula = idCaratula;
    }

    public int getIdCaratulaDescripcion() {
        return idCaratulaDescripcion;
    }

    public void setIdCaratulaDescripcion(int idCaratulaDescripcion) {
        this.idCaratulaDescripcion = idCaratulaDescripcion;
    }
}
