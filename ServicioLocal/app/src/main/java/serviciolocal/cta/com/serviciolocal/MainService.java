package serviciolocal.cta.com.serviciolocal;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by cta on 28/04/2015.
 */
public class MainService extends Service
{

    @Override
    public IBinder onBind(Intent intent)
    {
        MainBinder binder = new MainBinder(this);
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Toast.makeText(this, "Arrancando el servicio", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent)
    {
        Toast.makeText(this, "Desenlazando el servicio", Toast.LENGTH_LONG).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy()
    {
        Toast.makeText(this, "Destruido el servicio", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    public void saludo()
    {
        Toast.makeText(this, "Hola", Toast.LENGTH_LONG).show();
    }
}
