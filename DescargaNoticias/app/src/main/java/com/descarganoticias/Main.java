package com.descarganoticias;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

        descargaRSSelpais.execute("http://ep00.epimg.net/rss/elpais/portada.xml");
    }
}
