package provider.com.ejercicioprovider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import provider.com.ejercicioprovider.com.modelo.Producto;

/**
 * Created by cta on 04/05/2015.
 */
public class ListadoProductos extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        ListView listadoProductos = (ListView) findViewById(R.id.listadoProductos);



        listadoProductos.setAdapter(new ProductosAdapter (
                this,
                android.R.layout.simple_list_item_2,
                R.id.nombre,
                listar()
                ));


    }

    public List<Producto> listar()
    {
        List<Producto> listado = new ArrayList<>();
        // Mostrar los productos ordenados por nombre
        String URL = ProductoProvider.URL;
        Uri friends = Uri.parse(URL);

        Cursor c = getContentResolver().query(friends, null, null, null, "nombre");
        String result = "Application Results:";

        if (c.moveToFirst())
        {
            do
            {
                Producto producto = new Producto(
                        c.getString(c.getColumnIndex(ProductoProvider.NOMBRE)),
                        c.getInt(c.getColumnIndex(ProductoProvider.CANTIDAD)),
                        c.getInt(c.getColumnIndex(ProductoProvider.PRECIO)));
                listado.add(producto);
            }
            while (c.moveToNext());
        }

        return listado;
    }

    private class ProductosAdapter extends ArrayAdapter<Producto>
    {
        private Context context;
        private List<Producto> listado;

        public ProductosAdapter(Context context, int resource, int textViewResourceId, List<Producto> datos)
        {
            super(context, resource, textViewResourceId, datos);
            this.context = context;
            this.listado = datos;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View item = inflater.inflate(R.layout.listado_item, parent, false);

            TextView nombre = (TextView) item.findViewById(R.id.nombre);
            TextView cantidad = (TextView) item.findViewById(R.id.cantidad);
            TextView precio = (TextView) item.findViewById(R.id.precio);

            Producto producto = listado.get(position);

            nombre.setText(producto.getNombre());
            cantidad.setText(String.valueOf(producto.getCantidad()));
            precio.setText(String.valueOf(producto.getPrecio()));


            return item;
        }
    }
}
