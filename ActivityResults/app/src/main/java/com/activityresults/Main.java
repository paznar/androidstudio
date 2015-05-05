package com.activityresults;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main extends Activity implements View.OnClickListener {

    TextView texto;
    Button altura;
    Button ancho;
    Button area;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.texto);
        altura = (Button) findViewById(R.id.height);
        ancho = (Button) findViewById(R.id.width);
        area = (Button) findViewById(R.id.area);

        altura.setOnClickListener(this);
        ancho.setOnClickListener(this);
        area.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Intent i = new Intent(Main.this, Numbers.class);

        switch (v.getId())
        {
            case R.id.height:
                i.putExtra("numbers", "height");
                startActivityForResult(i, 1);
                break;
            case R.id.width:
                i.putExtra("numbers", "width");
                startActivityForResult(i, 1);
                break;
            case R.id.area:
                int a = Integer.valueOf(altura.getText().toString());
                int b = Integer.valueOf(ancho.getText().toString());
                texto.setText(a * b + "area total");
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(data.getExtras().containsKey("alturaInfo"))
        {
            altura.setText(data.getStringExtra("alturaInfo"));
        }
        else if(data.getExtras().containsKey("anchoInfo"))
        {
            ancho.setText(data.getStringExtra("anchoInfo"));
        }
    }
}
