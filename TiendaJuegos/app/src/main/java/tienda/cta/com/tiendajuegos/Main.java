package tienda.cta.com.tiendajuegos;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.modelo.Juego;

import java.util.ArrayList;
import java.util.List;


public class Main extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonVer = (Button) findViewById(R.id.buttonVer);



        botonVer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main.this, Catalogo.class));
            }
        });
    }
}
