package com.descarganoticias;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by cta on 05/05/2015.
 */
public class DescargaRSSelpais extends AsyncTask<String, Void, List<Noticia>>
{
    private ListView listaNoticias;
    private ProgressDialog dialog;


    public DescargaRSSelpais(ListView listaNoticias, ProgressDialog dialog)
    {
        this.listaNoticias = listaNoticias;
        this.dialog = dialog;
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        dialog.setMessage("Descargando noticias...");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.show();
    }

    @Override
    protected void onPostExecute(List<Noticia> noticias)
    {
        super.onPostExecute(noticias);
        dialog.hide();
        ArrayAdapter<Noticia> adapter = new ArrayAdapter<Noticia>(
                listaNoticias.getContext(),
                android.R.layout.simple_list_item_1,
                noticias);
        listaNoticias.setAdapter(adapter);
    }

    @Override
    protected List<Noticia> doInBackground(String... strings)
    {
        List<Noticia> noticias = null;
        try
        {
            URL url = new URL(strings[0]);
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();
            noticias = NoticiaPullParser.parse(is);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (XmlPullParserException e)
        {
            e.printStackTrace();
        }
        return noticias;
    }


}
