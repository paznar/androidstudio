package serviciolocal.cta.com.serviciolocal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Created by cta on 28/04/2015.
 */
public class MainServiceConnection implements ServiceConnection
{
    private  MainBinder mainBinder;

    public MainBinder getMainBinder()
    {
        return mainBinder;
    }
    @Override
    public void onServiceConnected(ComponentName name, IBinder service)
    {
        mainBinder = (MainBinder) service;
    }

    @Override
    public void onServiceDisconnected(ComponentName name)
    {
        mainBinder = null;
    }
}
