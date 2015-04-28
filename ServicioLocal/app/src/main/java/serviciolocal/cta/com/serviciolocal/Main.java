package serviciolocal.cta.com.serviciolocal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Main extends ActionBarActivity
{
    private MainBinder mainBinder;
    private MainServiceConnection connection  = new MainServiceConnection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        Intent intent = new Intent(this, MainService.class);

        switch (id)
        {
            case R.id.arrancar:
                startService(intent);
                break;
            case R.id.enlazar:
                bindService(intent, connection, Context.BIND_AUTO_CREATE);
                break;
            case R.id.saludar:

                mainBinder = connection.getMainBinder();

                if(mainBinder != null)
                {
                    mainBinder.getService().saludo();
                }
                break;
            case R.id.desenlazar:
                unbindService(connection);
                break;
            case R.id.parar:
                stopService(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
