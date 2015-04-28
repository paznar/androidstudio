package tienda.cta.com.tiendajuegos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.modelo.Juego;


/**
 * Created by cta on 21/04/2015.
 */
public class Catalogo extends ActionBarActivity {

    private Juego juego;

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalogo_vista);

        FragmentoCatalogo frgCatalogo =
                (FragmentoCatalogo) getSupportFragmentManager().findFragmentById(R.id.fragmentCatalogo);

        if(frgCatalogo.getJuego() != null)
        {
            setJuego(frgCatalogo.getJuego());
        }

        Intent i = new Intent(this, ActivityJuego.class);
        i.putExtra("Juego", juego);
        startActivity(i);
    }
}
