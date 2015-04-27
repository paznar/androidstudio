package menucontexto.cta.com.menucontexto;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button);
        registerForContextMenu(b);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucontexto, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.item1)
        {
            Log.d("Opcion Contexto", "Has pulsado 1");
        }
        if(id == R.id.item2)
        {
            Log.d("Opcion Contexto", "Has pulsado 2");
        }
        return super.onContextItemSelected(item);
    }
}
