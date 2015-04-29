package tienda.cta.com.tiendajuegos;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


/**
 * Created by cta on 21/04/2015.
 */
public class Catalogo extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        FragmentoCatalogo frgCatalogo =
                (FragmentoCatalogo) getSupportFragmentManager().findFragmentById(R.id.fragmentCatalogo);


    }
}
