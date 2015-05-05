package com.activityresults;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by cta on 04/05/2015.
 */
public class Numbers extends Activity implements View.OnClickListener
{
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numbers);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        String s = editText.getText().toString();

        Intent i = getIntent();
        String msg = i.getStringExtra("numbers");

        if(msg.equals("height"))
        {
            i.putExtra("alturaInfo", s);
            setResult(RESULT_OK, i);
            finish();
        }
        else if (msg.equals("width"))
        {
            i.putExtra("anchoInfo", s);
            setResult(RESULT_OK, i);
            finish();
        }
    }
}
