package tienda.cta.com.tiendajuegos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.modelo.Juego;

/**
 * Created by cta on 27/04/2015.
 */
public class FragmentoCatalogo extends Fragment
{
    private Juego juego;

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    private Juego[] catalogo =
            new Juego[]
            {
                new Juego("1", "Larry", "Aventura Gráfica", "PC", "Aventura gráfica cargada de humor, donde viviermos las aventuras y desventuras de Larry.", R.drawable.larry),
                new Juego("2", "Bible Fight", "Lucha", "XBox", "Juego de lucha con los protagonistas más sanguinarios de la Biblia!!", R.drawable.bible),
                new Juego("3", "Tekken", "Lucha", "PlayStation", "Juego de lucha, con multitudo de personajes a elegir y múltiples técnicas a realizaer.", R.drawable.tekken)
            };

    private ListView listaVista;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstantState)
    {
        return inflater.inflate(R.layout.fragmento_catalogo, container, false);
    }

    @Override
    public void onActivityCreated (Bundle state)
    {
        super.onActivityCreated(state);

        listaVista = (ListView) getView().findViewById(R.id.catalogo);

        listaVista.setAdapter(new JuegosAdapter(getActivity(), catalogo));

        listaVista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Juego j=(Juego)listaVista.getAdapter().getItem(position);
                setJuego(j);
            }
        });
    }
}
