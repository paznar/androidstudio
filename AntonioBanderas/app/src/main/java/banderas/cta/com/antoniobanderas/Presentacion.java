package banderas.cta.com.antoniobanderas;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by cta on 17/04/2015.
 */
public class Presentacion extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentacion);

        TextView textoNombre = (TextView) findViewById(R.id.textoNombre);
        TextView textoPoblacion = (TextView) findViewById(R.id.textoPoblacion);
        CheckBox checkUE = (CheckBox) findViewById(R.id.checkUE);

        Pais pais = (Pais) getIntent().getExtras().getSerializable("pais");
        textoNombre.setText("Nombre: " + pais.getNombre());
        textoPoblacion.setText("Población: " + Integer.toString(pais.getPoblacion()));
        checkUE.setChecked(pais.isUE());

    }
}
