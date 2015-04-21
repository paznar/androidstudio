package listas.cta.com.ejercicio3;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView l = (ListView) findViewById(R.id.lista);
        l.setAdapter(new MascotasAdapter(
                this,
                android.R.layout.simple_list_item_1,
                R.id.textView,
                getResources().getStringArray(R.array.animales)
        ));
        /*l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Main.this, Segunda.class);
                i.putExtra("animal","perrito");
                startActivity(i);
            }
        });*/


    }

   /* @Override
    public void onClick(View v) {
        Intent i = new Intent(Main.this, Segunda.class);
        i.putExtra("animal","perrito");
        startActivity(i);
    }*/


    private class MascotasAdapter extends ArrayAdapter<String> {

        private Context context;
        public MascotasAdapter(Context context, int resource, int textViewResourceId, String[] objects) {
            super(context, resource, textViewResourceId, objects);
            this.context=context;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.list_items, parent, false);
            String[] animales = getResources().getStringArray(R.array.animales);

            ImageView iv = (ImageView) row.findViewById(R.id.imageView);
            TextView tv = (TextView) row.findViewById(R.id.textView);
            Button b = (Button) row.findViewById(R.id.button);

            tv.setText(animales[position]);

            if(animales[position].equals("Perrito")){
                iv.setImageResource(R.drawable.perrito);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context, Segunda.class);
                        i.putExtra("animal","perrito");
                        startActivity(i);
                    }
                });
            }else{
                iv.setImageResource(R.drawable.gatito);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context, Segunda.class);
                        i.putExtra("animal","gatito");
                        startActivity(i);
                    }
                });
            }
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);

            //b.setOnClickListener(Main.this);
            return row;
        }
    }
}
