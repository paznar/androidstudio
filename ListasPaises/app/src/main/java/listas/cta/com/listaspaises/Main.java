package listas.cta.com.listaspaises;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Main extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapter(
                new MiAdapter(
                        this,
                        android.R.layout.simple_list_item_1,
                        R.id.textView,
                        getResources().getStringArray(R.array.countries)
                        ));
    }

    private class MiAdapter extends ArrayAdapter<String>
    {
        public MiAdapter(Context context, int resource, int textViewResourceId, String[] objects)
        {
            super(context, resource, textViewResourceId, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.list_items, parent, false);
            String[] items = getResources().getStringArray(R.array.countries);
            ImageView iv = (ImageView) row.findViewById(R.id.imageView);
            TextView tv = (TextView) row.findViewById(R.id.textView);

            System.out.print(items[position]);
            tv.setText(items[position]);
            if(items[position].equals("Usa"))
            {
                iv.setImageResource(R.drawable.usa);
            }
            else if(items[position].equals("Japan"))
            {
                iv.setImageResource(R.drawable.japan);
            }
            else if(items[position].equals("Spain"))
            {
                iv.setImageResource(R.drawable.spain);
            }
            else if(items[position].equals("France"))
            {
                iv.setImageResource(R.drawable.france);
            }
            else if(items[position].equals("Germany"))
            {
                iv.setImageResource(R.drawable.germany);
            }
            else if(items[position].equals("Catalunya"))
            {
                iv.setImageResource(R.drawable.catalunya);
            }
            else
            {
                iv.setImageResource(R.mipmap.ic_launcher);
            }

            return row;
        }
    }

}
