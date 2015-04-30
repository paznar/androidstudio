package tienda.cta.com.tiendajuegos;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.modelo.Juego;

import java.util.List;

/**
 * Created by cta on 27/04/2015.
 */
public class JuegosAdapter extends ArrayAdapter<Juego>
{
    Activity context;
    List<Juego> catalogo;

    public JuegosAdapter(Activity context, List<Juego> datos)
    {
        super(context, R.layout.catalogo_item, datos);
        this.context = context;
        this.catalogo = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.catalogo_item, null);

        Log.d("Log", "Creando opciones wey!");

        ImageView iv = (ImageView) item.findViewById(R.id.juegoVista);
        TextView tv = (TextView) item.findViewById(R.id.tituloJuego);

        Juego juegoActual = catalogo.get(position);
        Log.v("Juego", "Titulo: " + juegoActual.getTitulo() + " idImagen: " + juegoActual.getIdCaratula());

        iv.setImageResource(juegoActual.getIdCaratula());
        tv.setText(juegoActual.getTitulo());

        return item;
    }
}
