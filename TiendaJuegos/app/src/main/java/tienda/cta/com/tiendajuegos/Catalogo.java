package tienda.cta.com.tiendajuegos;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.modelo.Juego;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cta on 21/04/2015.
 */
public class Catalogo extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalogo);

        final List<Juego> catalogo = new ArrayList<>();
        catalogo.add(new Juego("1", "Larry", "Aventura Gráfica", "PC", "Aventura gráfica cargada de humor, donde viviermos las aventuras y desventuras de Larry.", R.drawable.larry));
        catalogo.add(new Juego("2", "Bible Fight", "Lucha", "XBox", "Juego de lucha con los protagonistas más sanguinarios de la Biblia!!", R.drawable.bible));
        catalogo.add(new Juego("3", "Tekken", "Lucha", "PlayStation", "Juego de lucha, con multitudo de personajes a elegir y múltiples técnicas a realizaer.", R.drawable.tekken));

        setListAdapter(
                new JuegosAdapter(
                        this,
                        android.R.layout.simple_list_item_1,
                        R.id.tituloJuego,
                        catalogo
                ));
    }

    private class JuegosAdapter extends ArrayAdapter<String> {
        private List<Juego> lista = new ArrayList<>();

        public JuegosAdapter(Context context, int resource, int textViewResourceId, List objects) {
            super(context, resource, textViewResourceId, objects);
            this.lista = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.juegos_item, parent, false);

            ImageView iv = (ImageView) row.findViewById(R.id.juegoVista);
            TextView tv = (TextView) row.findViewById(R.id.tituloJuego);

            final int idImagen;

            Juego juegoActual = lista.get(position);

            iv.setImageResource(juegoActual.getIdCaratula());
            tv.setText(juegoActual.getTitulo());

            return row;
        }
    }
}
