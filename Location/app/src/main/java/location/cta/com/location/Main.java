package location.cta.com.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main extends ActionBarActivity {

    private LocationManager locationManager;
    private LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button activar = (Button) findViewById(R.id.activar);

        activar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                comenzarLocalizacion();
            }
        });
    }

    private void comenzarLocalizacion()
    {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        mostrarPosicion (location);

        locationListener = new LocationListener()
        {
            @Override
            public void onLocationChanged(Location location)
            {
                mostrarPosicion(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras)
            {

            }

            @Override
            public void onProviderEnabled(String provider)
            {

            }

            @Override
            public void onProviderDisabled(String provider)
            {

            }
        };

        locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 30000, 0, locationListener);
    }

    private void mostrarPosicion(Location location)
    {
        TextView longitud = (TextView) findViewById(R.id.longitud);
        TextView latitud = (TextView) findViewById(R.id.latitud);
        TextView precision = (TextView) findViewById(R.id.precision);

        if(location != null)
        {
            longitud.setText("Longitud: " + String.valueOf(location.getLongitude()));
            latitud.setText("Latitud: " + String.valueOf(location.getLatitude()));
            precision.setText("Precision: " + String.valueOf(location.getAccuracy()));
        }
        else
        {
            longitud.setText("Longitud: DESCONOCIDA");
            latitud.setText("Latitud: DESCONOCIDA");
            precision.setText("Precision: DESCONOCIDA");
        }
    }
}
