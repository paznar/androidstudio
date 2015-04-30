package com.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.modelo.Juego;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cta on 30/04/2015.
 */
public class JuegoDao implements IJuegoDao {
    private SQLiteDatabase db;

    public JuegoDao(Context context) {
        db = context.openOrCreateDatabase("TiendaDB", context.MODE_PRIVATE, null);
    }

    @Override
    public Juego insert(Juego juego) {
        return null;
    }

    @Override
    public Juego update(Juego juego) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<Juego> listarTodos() {
        List<Juego> listaJuegos = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM Juego", null);
        if (c.moveToFirst()) {
            do {
                Juego juego = new Juego(c.getLong(0), c.getString(1), c.getString(2),
                        c.getString(3), c.getString(4), c.getInt(8), c.getInt(9));
                listaJuegos.add(juego);
            } while (c.moveToNext());
        }

        return listaJuegos;
    }

    @Override
    public Juego select(long id) {
        return null;
    }
}
