package tienda.cta.com.tiendajuegos;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.modelo.Juego;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Main extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonVer = (Button) findViewById(R.id.buttonVer);
        Button buttonInsert = (Button) findViewById(R.id.buttonInsert);
        Button buttonBorrar = (Button) findViewById(R.id.buttonDelete);
        Button buttonUpdate = (Button) findViewById(R.id.buttonUpdate);

//        rellenarDatos();

        botonVer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main.this, Catalogo.class));
            }
        });

        buttonInsert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Main.this, ActivityCRUD.class);
                intent.putExtra("action", "insert");

                startActivity(intent);
            }
        });

        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, ActivityCRUD.class);
                intent.putExtra("action", "delete");

                startActivity(intent);
            }
        });

//        buttonUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Main.this, ActivityCRUD.class);
//                intent.putExtra("action", "update");
//
//                startActivity(intent);
//            }
//        });

    }



    public void rellenarDatos()
    {
        SQLiteDatabase db = openOrCreateDatabase("TiendaDB", MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS Juego(id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, genero VARCHAR," +
                " plataforma VARCHAR, descripcion VARCHAR, stock INT, valoracion INT(1), fechaDeLanzamiento VARCHAR," +
                " idCaratula INT, idCaratulaDescripcion);");
        db.execSQL("INSERT INTO Juego (titulo, genero, plataforma, descripcion, idCaratula, idCaratulaDescripcion)" +
                " VALUES ('Larry', 'Aventura Gráfica', 'PC', " +
                "'Aventura gráfica cargada de humor, donde viviermos las aventuras y desventuras de Larry.',"
                + R.drawable.larry + ", " + R.drawable.larry_descripcion + ");");
        db.execSQL("INSERT INTO Juego (titulo, genero, plataforma, descripcion, idCaratula, idCaratulaDescripcion)" +
                " VALUES ('Bible Fight', 'Lucha', 'XBox', " +
                "'Juego de lucha con los protagonistas más sanguinarios de la Biblia!!',"
                + R.drawable.bible + ", " + R.drawable.bible_descripcion + ");");
        db.execSQL("INSERT INTO Juego (titulo, genero, plataforma, descripcion, idCaratula, idCaratulaDescripcion)" +
                " VALUES ('Tekken', 'Lucha', 'PlayStation', " +
                "'Juego de lucha, con multitudo de personajes a elegir y múltiples técnicas a realizaer..',"
                + R.drawable.tekken + ", " + R.drawable.tekken_descripcion + ");");
    }
}
