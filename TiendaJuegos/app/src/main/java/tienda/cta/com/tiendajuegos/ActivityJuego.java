package tienda.cta.com.tiendajuegos;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.modelo.Juego;


public class ActivityJuego extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        TextView titulo = (TextView) findViewById(R.id.textTitulo);
        ImageView imagen = (ImageView) findViewById(R.id.imageDescripcion);
        TextView descripcion = (TextView) findViewById(R.id.textDescripcion);

        Juego juego = (Juego) getIntent().getExtras().getSerializable("juego");

        titulo.setText(juego.getTitulo());
        imagen.setImageResource(juego.getIdCaratulaDescripcion());
        descripcion.setText(juego.getDescripcion());

//        titulo.setText("Bible Fight");
//        imagen.setImageResource(R.drawable.bible_descripcion);
//        descripcion.setText("Juego en flash muy bien elaborado, los escenarios y los movimientos de los personasjes son geniales y pasate un buen rato peleando contra ...");

//        imagen.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(ActivityJuego.this, Trailer.class));
//            }
//        });
    }
}
