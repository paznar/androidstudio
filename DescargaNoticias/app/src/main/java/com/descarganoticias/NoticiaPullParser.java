package com.descarganoticias;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cta on 05/05/2015.
 */
public class NoticiaPullParser
{
    public static List<Noticia> parse(InputStream is) throws XmlPullParserException, IOException
    {
        List<Noticia> resultado = new LinkedList<Noticia>();
        Noticia noticia = null;
        XmlPullParser parser = Xml.newPullParser();

        parser.setInput(is, "UTF-8");
        int tagType = parser.getEventType();

        while (tagType != XmlPullParser.END_DOCUMENT)
        {
            String tag = null;
            switch (tagType)
            {
                case XmlPullParser.END_TAG:
                    tag = parser.getName();
                    if(tag.equals("item"))
                    {
                        resultado.add(noticia);
                        noticia = null;
                    }
                    break;
                case XmlPullParser.START_TAG:
                    tag = parser.getName();
                    if(tag.equals("item"))
                    {
                        noticia = new Noticia();
                    }
                    else if(noticia != null)
                    {
                        if(tag.equals("title"))
                        {
                            noticia.setTitulo(parser.nextText());
                        }
                        else if(tag.equals("link"))
                        {
                            noticia.setEnlace(parser.nextText());
                        }
                        else if(tag.equals("creator"))
                        {
                            noticia.setAutor(parser.nextText());
                        }
                    }
                    break;
            }
            tagType = parser.next();
        }

        return resultado;
    }
}
