package progreso.cta.com.progreso;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressDialog pd = new ProgressDialog(this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setMessage("Espera");
        pd.setCancelable(true);
        pd.setIndeterminate(true);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.show();
            }
        });
    }
}
