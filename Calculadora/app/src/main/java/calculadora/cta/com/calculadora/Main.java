package calculadora.cta.com.calculadora;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textoValor1 = (EditText) findViewById(R.id.valor1);
        final EditText textoValor2 = (EditText) findViewById(R.id.valor2);
        final TextView textoResultado = (TextView) findViewById(R.id.resultado);

        Button sumar = (Button) findViewById(R.id.sumar);
        Button restar = (Button) findViewById(R.id.restar);
        Button multiplicar = (Button) findViewById(R.id.multiplicar);

        sumar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CalculadoraIntentService.startActionSumar(
                        Main.this ,
                        Integer.parseInt(textoValor1.getText().toString()),
                        Integer.parseInt(textoValor2.getText().toString()));
            }
        });

        restar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CalculadoraIntentService.startActionRestar(
                        Main.this ,
                        Integer.parseInt(textoValor1.getText().toString()),
                        Integer.parseInt(textoValor2.getText().toString()));
            }
        });

        multiplicar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CalculadoraIntentService.startActionMultiplicar(
                        Main.this ,
                        Integer.parseInt(textoValor1.getText().toString()),
                        Integer.parseInt(textoValor2.getText().toString()));
            }
        });


        BroadcastReceiver receiver = new BroadcastReceiver()
        {
            @Override
            public void onReceive(Context context, Intent intent)
            {
                int valor1 = intent.getIntExtra(CalculadoraIntentService.EXTRA_PARAM_VALOR_1, 0);
                int valor2 = intent.getIntExtra(CalculadoraIntentService.EXTRA_PARAM_VALOR_2, 0);
                int resultado;


                switch (intent.getAction())
                {
                    case CalculadoraIntentService.BROADCAST_ACTION_SUMAR:
                        resultado = valor1 + valor2;
                        textoResultado.setText(String.valueOf(resultado));
                        break;
                    case CalculadoraIntentService.BROADCAST_ACTION_RESTAR:
                        resultado = valor1 - valor2;
                        textoResultado.setText(String.valueOf(resultado));
                        break;
                    case CalculadoraIntentService.BROADCAST_ACTION_MULTIPLICAR:
                        resultado = valor1 * valor2;
                        textoResultado.setText(String.valueOf(resultado));
                        break;
                }
            }
        };

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CalculadoraIntentService.BROADCAST_ACTION_SUMAR);
        intentFilter.addAction(CalculadoraIntentService.BROADCAST_ACTION_RESTAR);
        intentFilter.addAction(CalculadoraIntentService.BROADCAST_ACTION_MULTIPLICAR);

        registerReceiver(receiver, intentFilter);
    }
}
