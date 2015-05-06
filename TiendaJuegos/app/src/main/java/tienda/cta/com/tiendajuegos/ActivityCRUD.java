package tienda.cta.com.tiendajuegos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dao.IJuegoDao;
import com.dao.JuegoDao;
import com.modelo.Juego;

/**
 * Created by cta on 05/05/2015.
 */
public class ActivityCRUD extends Activity
{
    EditText inputTitulo;
    EditText inputGenero;
    EditText inputPlataforma;
    EditText inputDescripcion;
    String action;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        action = getIntent().getExtras().getString("action");
        Button botonAccion = (Button) findViewById(R.id.botonAccion);

        inputTitulo = (EditText) findViewById(R.id.inputTitulo);
        inputGenero = (EditText) findViewById(R.id.inputGenero);
        inputPlataforma = (EditText) findViewById(R.id.inputPlataforma);
        inputDescripcion = (EditText) findViewById(R.id.inputDescripcion);


        if (action.equals("insert"))
        {
            botonAccion.setText("Insert");

            inputGenero.setVisibility(View.VISIBLE);
            inputPlataforma.setVisibility(View.VISIBLE);
            inputDescripcion.setVisibility(View.VISIBLE);

            botonAccion.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    IJuegoDao juegoDao = new JuegoDao(getBaseContext());

                    Juego juego = new Juego(
                            0,
                            inputTitulo.getText().toString(),
                            inputGenero.getText().toString(),
                            inputPlataforma.getText().toString(),
                            inputDescripcion.getText().toString(),
                            0,
                            0
                    );

                    juegoDao.insert(juego);

                    Toast.makeText(getBaseContext(), "Insertado", Toast.LENGTH_LONG).show();

                    ActivityCRUD.this.finish();
                }
            });
        }
        else if(action.equals("delete"))
        {
            botonAccion.setText("Erradicar");

            botonAccion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IJuegoDao juegoDao = new JuegoDao(getBaseContext());

                    juegoDao.delete(inputTitulo.getText().toString());

                    Toast.makeText(getBaseContext(), "Erradicado", Toast.LENGTH_LONG).show();

                    ActivityCRUD.this.finish();
                }
            });
        }
        else if(action.equals("update"))
        {
            botonAccion.setText("Modificar");

            inputGenero.setVisibility(View.VISIBLE);
            inputPlataforma.setVisibility(View.VISIBLE);
            inputDescripcion.setVisibility(View.VISIBLE);

            botonAccion.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    IJuegoDao juegoDao = new JuegoDao(getBaseContext());

                    Juego juego = new Juego(
                            0,
                            inputTitulo.getText().toString(),
                            inputGenero.getText().toString(),
                            inputPlataforma.getText().toString(),
                            inputDescripcion.getText().toString(),
                            0,
                            0
                    );

                    juegoDao.update(juego);

                    Toast.makeText(getBaseContext(), "Modificado", Toast.LENGTH_LONG).show();

                    ActivityCRUD.this.finish();
                }
            });
        }
    }
}
