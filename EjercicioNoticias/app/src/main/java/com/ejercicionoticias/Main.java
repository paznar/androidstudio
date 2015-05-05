package com.ejercicionoticias;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        ProgressDialog dialog = new ProgressDialog(this);

        DescargaRSSelpais descargaRSSelpais = new DescargaRSSelpais(listView, dialog);

        descargaRSSelpais.execute("http://www.abc.net.au/sport/syndicate/sport_all.xml");
    }
}
