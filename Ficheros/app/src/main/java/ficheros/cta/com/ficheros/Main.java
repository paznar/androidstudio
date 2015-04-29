package ficheros.cta.com.ficheros;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView funcion = (TextView) findViewById(R.id.funcion);
        final TextView texto = (TextView) findViewById(R.id.texto);
        Button escribir = (Button) findViewById(R.id.escribir);
        Button leer = (Button) findViewById(R.id.leer);
        Button leerRaw = (Button) findViewById(R.id.leerRaw);

        escribir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    OutputStreamWriter fout = new OutputStreamWriter(openFileOutput("prueba_int.txt", Context.MODE_PRIVATE));
                    fout.write("Texto de prueba");
                    fout.close();
                    funcion.setText("Fichero creado");
                }
                catch (FileNotFoundException e)
                {
                    funcion.setText("Error. Fichero no hallado.");
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    funcion.setText("Errro. Fichero no escrito.");
                    e.printStackTrace();
                }
            }
        });

        leer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try {
                    BufferedReader fin = new BufferedReader(
                            new InputStreamReader(openFileInput("prueba_int.txt")));
                    String linea = fin.readLine();
                    texto.setText(linea);
                    funcion.setText("Fichero leído");
                }
                catch (FileNotFoundException e)
                {
                    funcion.setText("Error. Fichero no hallado.");
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    funcion.setText("Error. Fichero no leído.");
                    e.printStackTrace();
                }
            }
        });

        leerRaw.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    InputStream fraw = getResources().openRawResource(R.raw.prueba_raw);
                    BufferedReader brin = new BufferedReader( new InputStreamReader(fraw));

                    String linea = brin.readLine();
                    fraw.close();
                    texto.setText(linea);
                    funcion.setText("Fichero leído");
                }
                catch (IOException e)
                {
                    funcion.setText("Error. Fichero no se puede leer");
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
