package provider.com.ejercicioprovider;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;


public class Main extends Activity {

    EditText nombreProducto;
    EditText cantidadProducto;
    EditText precioProducto;
    Button botonInsertar;
    Button botonListar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreProducto = (EditText) findViewById(R.id.nombreProducto);
        cantidadProducto = (EditText) findViewById(R.id.cantidadProducto);
        precioProducto = (EditText) findViewById(R.id.precioProducto);
        botonInsertar = (Button) findViewById(R.id.insertar);
        botonListar = (Button) findViewById(R.id.listar);

        botonInsertar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                insertar();
            }
        });

        botonListar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Main.this, ListadoProductos.class);

                startActivity(intent);
            }
        });

    }

    public void insertar()
    {
        ContentValues values = new ContentValues();

        values.put(ProductoProvider.NOMBRE, nombreProducto.getText().toString());
        values.put(ProductoProvider.CANTIDAD, cantidadProducto.getText().toString());
        values.put(ProductoProvider.PRECIO, precioProducto.getText().toString());

        Uri uri = getContentResolver().insert(ProductoProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(), uri.toString() + " insertado con éxito", Toast.LENGTH_LONG).show();
    }
}
