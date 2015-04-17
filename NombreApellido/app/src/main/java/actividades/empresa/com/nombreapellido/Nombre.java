package actividades.empresa.com.nombreapellido;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by cta on 16/04/2015.
 */
public class Nombre extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nombre);

        TextView textoNombre = (TextView) findViewById(R.id.textoNombre);
        textoNombre.setText(getIntent().getExtras().getString("textoNombre"));

        Button botonSaludo = (Button) findViewById(R.id.botonSaludo);

        botonSaludo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Nombre.this, Saludo.class);

                startActivity(i);
            }
        });
    }
}
