package banderas.cta.com.antoniobanderas;

import android.app.Presentation;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Main extends ActionBarActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                ImageButton ibCat = (ImageButton) findViewById(R.id.botonCat);
        ImageButton ibEsp = (ImageButton) findViewById(R.id.botonEsp);
        ImageButton ibFra = (ImageButton) findViewById(R.id.botonFra);
        ImageButton ibAle = (ImageButton) findViewById(R.id.botonAle);
        ImageButton ibJap = (ImageButton) findViewById(R.id.botonJap);
        ImageButton ibUsa = (ImageButton) findViewById(R.id.botonUsa);

        ibCat.setOnClickListener(this);
        ibEsp.setOnClickListener(this);
        ibFra.setOnClickListener(this);
        ibAle.setOnClickListener(this);
        ibJap.setOnClickListener(this);
        ibUsa.setOnClickListener(this);

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

    @Override
    public void onClick(View v)
    {
        Intent i = new Intent(Main.this, Presentacion.class);
        Pais pais = new Pais();

        if(v.getId() == R.id.botonCat)
        {
            pais.setNombre("Catalunya");
            pais.setPoblacion(7000000);
            pais.setUE(true);

            i.putExtra("pais", pais);

            startActivity(i);
        }
        else if(v.getId() == R.id.botonEsp)
        {
            pais.setNombre("España");
            pais.setPoblacion(47000000);
            pais.setUE(true);

            i.putExtra("pais", pais);

            startActivity(i);
        }
        else if(v.getId() == R.id.botonFra)
        {
            pais.setNombre("Francia");
            pais.setPoblacion(50000000);
            pais.setUE(true);

            i.putExtra("pais", pais);

            startActivity(i);
        }
        else if(v.getId() == R.id.botonAle)
        {
            pais.setNombre("Alemania");
            pais.setPoblacion(35000000);
            pais.setUE(true);

            i.putExtra("pais", pais);

            startActivity(i);
        }
        else if(v.getId() == R.id.botonJap)
        {
            pais.setNombre("Japón");
            pais.setPoblacion(80000000);
            pais.setUE(false);

            i.putExtra("pais", pais);

            startActivity(i);
        }
        else if(v.getId() == R.id.botonJap)
        {
            pais.setNombre("Catalunya");
            pais.setPoblacion(125000000);
            pais.setUE(false);

            i.putExtra("pais", pais);

            startActivity(i);
        }

    }
}
