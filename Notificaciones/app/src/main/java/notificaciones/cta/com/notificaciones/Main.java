package notificaciones.cta.com.notificaciones;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

        Button b = (Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                Notification notificar = new Notification(android.R.drawable.stat_notify_error, "Error", System.currentTimeMillis());
                Context context = Main.this;
                CharSequence titulo = "Esta es nuestra noti";
                CharSequence detalles = "Se ha producido un error";

                Intent i = new Intent(context, Main.class);

                PendingIntent pending = PendingIntent.getActivity(context, 0, i, 0);

                notificar.setLatestEventInfo(context, titulo, detalles, pending);
                notificar.sound = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sonido);

                nm.notify(0, notificar);
            }
        });
    }

}
