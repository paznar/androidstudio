package sharedpreferences.cta.com.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class Main extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button);
        Button b2 = (Button) findViewById(R.id.button2);

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferences preferences = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("email", "email@google.com");
                editor.putBoolean("activo", true);
                editor.putInt("edad", 33);
                editor.putString("nombre", "Pablo");
                editor.commit();
            }
        });

        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView nombre = (TextView) findViewById(R.id.nombre);
                TextView email = (TextView) findViewById(R.id.email);
                TextView edad = (TextView) findViewById(R.id.edad);
                CheckBox activo = (CheckBox) findViewById(R.id.activo);

                SharedPreferences preferences = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
                String nombreCadena = preferences.getString("nombre", "texto por defecto");
                String emailCadena = preferences.getString("email", "texto por defecto");
                int edadCadena = preferences.getInt("edad", 99);
                boolean activoCadena = preferences.getBoolean("activo", false);

                nombre.setText(nombreCadena);
                email.setText(emailCadena);
                edad.setText(String.valueOf(edadCadena));
                activo.setChecked(activoCadena);
            }
        });
    }



}
