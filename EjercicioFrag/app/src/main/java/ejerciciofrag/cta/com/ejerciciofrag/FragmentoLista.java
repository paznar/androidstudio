package ejerciciofrag.cta.com.ejerciciofrag;

import android.app.Fragment;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cta on 22/04/2015.
 */
public class FragmentoLista extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        List<String> lista = new ArrayList<>();

        lista.add("Uno");
        lista.add("Dos");
        lista.add("Tres");

        View view = inflater.inflate(R.layout.fragmento_lista, container, false);

        ListView lv = (ListView) view.findViewById(R.id.listaCorreo);

        lv.setAdapter( new ListaAdapter(
                                        getActivity(),
                                        android.R.layout.simple_list_item_2,
                                        R.id.textoCorreo,
                                        lista ));

        return view;
    }

    private class ListaAdapter extends ArrayAdapter
    {
        private Context context;
        private List<String> lista;
        public ListaAdapter (Context context, int resource, int textResource, List objects )
        {
            super(context, resource, textResource,objects);
            this.context = context;
            this.lista = objects;
        }

        @Override
        public View getView (int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.item_correo, parent, false);

            TextView text = (TextView) row.findViewById(R.id.textoCorreo);

            text.setText(lista.get(position));

            return row;
        }
    }
}

