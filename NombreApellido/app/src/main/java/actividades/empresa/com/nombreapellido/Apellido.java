package actividades.empresa.com.nombreapellido;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by cta on 16/04/2015.
 */
public class Apellido extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apellido);

        TextView textoApellido = (TextView) findViewById(R.id.textoApellido);
        textoApellido.setText(getIntent().getExtras().getString("textoApellido"));

        Button botonSaludo = (Button) findViewById(R.id.botonSaludo);

        botonSaludo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Apellido.this, Saludo.class);

                startActivity(i);
            }
        });
    }
}
