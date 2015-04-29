package broadcast.cta.com.broadcastreceivers;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

/**
 * Created by cta on 29/04/2015.
 */
public class SaludadorIntentService extends IntentService
{
    private static final String ACTION_SALUDAR = "com.example.intentservice.action.SALUDAR";
    private static final String ACTION_DESPEDIR = "com.example.intentservice.action.DESPEDIR";
    public static final String BROADCAST_ACTION_SALUDAR = "com.example.intentservice.broadcast.action.SALUDAR";
    public static final String BROADCAST_ACTION_DESPEDIR = "com.example.intentservice.broadcast.action.DESPEDIR";
    public static final String EXTRA_PARAM_NOMBRE = "nombre";

    public SaludadorIntentService()
    {
        super("SaludadorIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        if(intent != null)
        {
            String action = intent.getAction();
            if(ACTION_SALUDAR.equals(action))
            {
                String nombre = intent.getStringExtra(EXTRA_PARAM_NOMBRE);
                saludar(nombre);
            }
            else if (ACTION_DESPEDIR.equals(action))
            {
                String nombre = intent.getStringExtra(EXTRA_PARAM_NOMBRE);
                despedir(nombre);
            }
        }
    }

    public static void startActionSaludar(Context context, String nombre)
    {
        Intent intent = new Intent(context, SaludadorIntentService.class);

        intent.setAction(ACTION_SALUDAR);
        intent.putExtra(EXTRA_PARAM_NOMBRE, nombre);
        context.startService(intent);
    }

    public static void startActionDespedir(Context context, String nombre)
    {
        Intent intent = new Intent(context, SaludadorIntentService.class);

        intent.setAction(ACTION_DESPEDIR);
        intent.putExtra(EXTRA_PARAM_NOMBRE, nombre);
        context.startService(intent);
    }

    private void saludar(String nombre)
    {
        Intent intent = new Intent(BROADCAST_ACTION_SALUDAR);
        intent.putExtra(EXTRA_PARAM_NOMBRE, nombre);
        sendBroadcast(intent);
    }

    private void despedir(String nombre)
    {
        Intent intent = new Intent(BROADCAST_ACTION_DESPEDIR);
        intent.putExtra(EXTRA_PARAM_NOMBRE, nombre);
        sendBroadcast(intent);
    }

}
