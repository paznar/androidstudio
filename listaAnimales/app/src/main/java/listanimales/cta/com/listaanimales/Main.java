package listanimales.cta.com.listaanimales;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Main extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapter(
                new MiAdapter(
                        this,
                        android.R.layout.simple_list_item_1,
                        R.id.textAnimal,
                        getResources().getStringArray(R.array.animals)
                ));
    }

    private class MiAdapter extends ArrayAdapter<String>
    {
        public MiAdapter(Context context, int resource, int textViewResourceId, String[] objects)
        {
            super(context, resource, textViewResourceId, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.animales_item, parent, false);
            String[] items = getResources().getStringArray(R.array.animals);

            ImageView iv = (ImageView) row.findViewById(R.id.animalVista);
            TextView tv = (TextView) row.findViewById(R.id.textAnimal);
            Button b = (Button) row.findViewById(R.id.botonAnimal);
            final int idImagen;

            tv.setText(items[position]);

            if(items[position].equals("Gato"))
            {
                idImagen = R.drawable.gatito;
                iv.setImageResource(R.drawable.gatito);
            }
            else if(items[position].equals("Perro"))
            {
                idImagen = R.drawable.perrito;
                iv.setImageResource(R.drawable.perrito);
            }
            else if(items[position].equals("Camello"))
            {
                idImagen = R.drawable.camello;
                iv.setImageResource(R.drawable.camello);
            }
            else
            {
                idImagen = R.mipmap.ic_launcher;
                iv.setImageResource(R.mipmap.ic_launcher);
            }

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    startActivity(new Intent(Main.this, Detalle.class).putExtra("imagen", idImagen ));
                }
            });

            return row;
        }
    }

}
