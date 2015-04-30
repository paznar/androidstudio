package tienda.cta.com.tiendajuegos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dao.IJuegoDao;
import com.dao.JuegoDao;
import com.modelo.Juego;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cta on 27/04/2015.
 */
public class FragmentoCatalogo extends Fragment
{
//    private Juego[] catalogo =
//            new Juego[]
//            {
//                new Juego(1,
//                        "Larry",
//                        "Aventura Gráfica",
//                        "PC",
//                        "Aventura gráfica cargada de humor, donde viviermos las aventuras y desventuras de Larry.",
//                        R.drawable.larry,
//                        R.drawable.larry_descripcion),
//                new Juego(2,
//                        "Bible Fight",
//                        "Lucha",
//                        "XBox",
//                        "Juego de lucha con los protagonistas más sanguinarios de la Biblia!!",
//                        R.drawable.bible,
//                        R.drawable.bible_descripcion),
//                new Juego(3,
//                        "Tekken",
//                        "Lucha",
//                        "PlayStation",
//                        "Juego de lucha, con multitudo de personajes a elegir y múltiples técnicas a realizaer.",
//                        R.drawable.tekken,
//                        R.drawable.tekken_descripcion)
//            };

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
        IJuegoDao juegoDao = new JuegoDao(getActivity());
        List<Juego> listaJuegos = juegoDao.listarTodos();

        listaVista = (ListView) getView().findViewById(R.id.catalogo);

        listaVista.setAdapter(new JuegosAdapter(getActivity(), listaJuegos));

        listaVista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Juego juego = (Juego) listaVista.getAdapter().getItem(position);

                Intent i = new Intent(getActivity(), ActivityJuego.class);
                i.putExtra("juego", juego);
                startActivity(i);
            }
        });
    }
}
