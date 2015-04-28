package serviciolocal.cta.com.serviciolocal;

import android.os.Binder;

/**
 * Created by cta on 28/04/2015.
 */
public class MainBinder extends Binder
{
    private MainService service;

    public MainBinder (MainService service)
    {
        this.service = service;
    }

    public MainService getService()
    {
        return service;
    }
}
