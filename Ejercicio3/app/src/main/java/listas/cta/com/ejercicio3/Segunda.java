package listas.cta.com.ejercicio3;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

/**
 * Created by cta on 20/04/2015.
 */
public class Segunda extends ActionBarActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda);

        String animal =getIntent().getExtras().getString("animal");
        ImageView iv = (ImageView) findViewById(R.id.imageView2);
        if(animal.equals("perrito")){
            iv.setImageResource(R.drawable.perrito);
        }else{
            iv.setImageResource(R.drawable.gatito);
        }
    }
}
