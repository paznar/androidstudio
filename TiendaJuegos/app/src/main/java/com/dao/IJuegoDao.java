package com.dao;

import com.modelo.Juego;

import java.util.List;

/**
 * Created by cta on 30/04/2015.
 */
public interface IJuegoDao {
    public Juego insert(Juego juego);
    public Juego update(Juego juego);
    public boolean delete (String id);
    public List<Juego> listarTodos();
    public Juego select(String titulo);
}
