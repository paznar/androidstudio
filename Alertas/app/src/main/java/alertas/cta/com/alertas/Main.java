package alertas.cta.com.alertas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main.this);
                builder.setMessage("Quieres salir?");
                builder.setCancelable(false);
                builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Main.this.finish();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.cancel();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}
