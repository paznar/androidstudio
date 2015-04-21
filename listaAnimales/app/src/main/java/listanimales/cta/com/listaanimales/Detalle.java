package listanimales.cta.com.listaanimales;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

/**
 * Created by cta on 20/04/2015.
 */
public class Detalle extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animales_detalle);

        ImageView iv = (ImageView) findViewById(R.id.animalDetalle);

        iv.setImageResource(getIntent().getExtras().getInt("imagen"));
    }
}
