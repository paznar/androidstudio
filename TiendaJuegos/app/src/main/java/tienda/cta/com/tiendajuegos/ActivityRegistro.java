package tienda.cta.com.tiendajuegos;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;


public class ActivityRegistro extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("tienda.cta", "llega");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        NotificationIntentService bd = new NotificationIntentService(this);
        bd.crearTablas();
        bd.close();
    }
}