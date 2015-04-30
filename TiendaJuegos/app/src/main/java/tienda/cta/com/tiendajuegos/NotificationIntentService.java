package tienda.cta.com.tiendajuegos;

import android.app.Activity;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by cta on 28/04/2015.
 */
public class NotificationIntentService extends IntentService {
    private static final String ACTION_NOTIFICACION = "accion_notificacion";
    public static final String BROADCAST_ACTION_NOTIFICACION = "notificar";
    public static final String EXTRA_NOTIFIACION = "notificacion";
    private SQLiteDatabase db;
    private Context context;

    public NotificationIntentService() {
        super("Notificacion");
    }

    public NotificationIntentService(Activity context) {
        super("Notificacion");
        db = context.openOrCreateDatabase("TiendaDB", context.MODE_PRIVATE, null);
    }

    public void crearTablas() {
        db.execSQL("CREATE TABLE IF NOT EXISTS Cliente(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR, email VARCHAR, password VARCHAR, rol VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Juego(id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, genero VARCHAR," +
                " plataforma VARCHAR, descripcion VARCHAR, stock INT, valoracion INT(1), fechaDeLanzamiento VARCHAR, idCaratula INT, idCaratulaDescripcion);");
    }

    public void startLanzarNotificacion(Context context, String[] notificacion) {
        this.context = context;
        Intent intent = new Intent(context, NotificationIntentService.class);
        intent.setAction(ACTION_NOTIFICACION);
        intent.putExtra(EXTRA_NOTIFIACION, notificacion);
        context.startService(intent);
    }

    private void lanzarNotificacion(String[] notificacion) {
        Intent intent = new Intent(BROADCAST_ACTION_NOTIFICACION);
        intent.putExtra(EXTRA_NOTIFIACION, notificacion);
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notificar = new Notification(android.R.drawable.star_big_on,
                notificacion[0], System.currentTimeMillis());
        CharSequence titulo = "Esta es nuestra noti";
        CharSequence detalles = "Se ha producido";
//        Intent intent = new Intent(context, Main.class);
//        PendingIntent pi = PendingIntent.getActivity(context, 0, intent, 0);
//        notificar.setLatestEventInfo(context, notificacion[1],  notificacion[2], pi);
        notificar.setLatestEventInfo(context, notificacion[1], notificacion[2], null);
        nm.notify(0, notificar);
        sendBroadcast(intent);
    }


    public void close() {
        db.close();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (ACTION_NOTIFICACION.equals(action)) {
                String notificacion[] = intent.getExtras().getStringArray(EXTRA_NOTIFIACION);
                lanzarNotificacion(notificacion);
            }
        }
    }
}
