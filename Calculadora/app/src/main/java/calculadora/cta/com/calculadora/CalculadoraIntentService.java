package calculadora.cta.com.calculadora;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

/**
 * Created by cta on 29/04/2015.
 */
public class CalculadoraIntentService extends IntentService
{

    private static final String ACTION_SUMAR = "com.empresa.intentservice.action.SUMAR";
    private static final String ACTION_RESTAR = "com.empresa.intentservice.action.RESTAR";
    private static final String ACTION_MULTIPLICAR = "com.empresa.intentservice.action.MULTIPLICAR";
    public static final String BROADCAST_ACTION_SUMAR = "com.empresa.intentservice.broadcast.action.SUMAR";
    public static final String BROADCAST_ACTION_RESTAR = "com.empresa.intentservice.broadcast.action.RESTAR";
    public static final String BROADCAST_ACTION_MULTIPLICAR = "com.empresa.intentservice.broadcast.action.MULTIPLICAR";
    public static final String EXTRA_PARAM_VALOR_1 = "valor1";
    public static final String EXTRA_PARAM_VALOR_2 = "valor2";



    public CalculadoraIntentService()
    {
        super("CalculadoraIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        if(intent != null)
        {
            String action = intent.getAction();
            if(ACTION_SUMAR.equals(action))
            {
                int valor1 = intent.getIntExtra(EXTRA_PARAM_VALOR_1, 0);
                int valor2 = intent.getIntExtra(EXTRA_PARAM_VALOR_2, 0);

                sumar(valor1, valor2);
            }
            else if(ACTION_RESTAR.equals(action))
            {
                int valor1 = intent.getIntExtra(EXTRA_PARAM_VALOR_1, 0);
                int valor2 = intent.getIntExtra(EXTRA_PARAM_VALOR_2, 0);

                restar(valor1, valor2);
            }
            else if(ACTION_MULTIPLICAR.equals(action))
            {
                int valor1 = intent.getIntExtra(EXTRA_PARAM_VALOR_1, 0);
                int valor2 = intent.getIntExtra(EXTRA_PARAM_VALOR_2, 0);

                multiplicar(valor1, valor2);
            }
        }
    }

    public static void startActionSumar(Context context, int valor1, int valor2)
    {
        Intent intent = new Intent(context, CalculadoraIntentService.class);

        intent.setAction(ACTION_SUMAR);
        intent.putExtra(EXTRA_PARAM_VALOR_1, valor1);
        intent.putExtra(EXTRA_PARAM_VALOR_2, valor2);
        context.startService(intent);
    }

    public static void startActionRestar(Context context, int valor1, int valor2)
    {
        Intent intent = new Intent(context, CalculadoraIntentService.class);

        intent.setAction(ACTION_RESTAR);
        intent.putExtra(EXTRA_PARAM_VALOR_1, valor1);
        intent.putExtra(EXTRA_PARAM_VALOR_2, valor2);
        context.startService(intent);
    }

    public static void startActionMultiplicar(Context context, int valor1, int valor2)
    {
        Intent intent = new Intent(context, CalculadoraIntentService.class);

        intent.setAction(ACTION_MULTIPLICAR);
        intent.putExtra(EXTRA_PARAM_VALOR_1, valor1);
        intent.putExtra(EXTRA_PARAM_VALOR_2, valor2);
        context.startService(intent);
    }

    private void sumar (int valor1, int valor2)
    {
        Intent intent = new Intent(BROADCAST_ACTION_SUMAR);
        intent.putExtra(EXTRA_PARAM_VALOR_1, valor1);
        intent.putExtra(EXTRA_PARAM_VALOR_2, valor2);
        sendBroadcast(intent);
    }

    private void restar (int valor1, int valor2)
    {
        Intent intent = new Intent(BROADCAST_ACTION_RESTAR);
        intent.putExtra(EXTRA_PARAM_VALOR_1, valor1);
        intent.putExtra(EXTRA_PARAM_VALOR_2, valor2);
        sendBroadcast(intent);
    }

    private void multiplicar (int valor1, int valor2)
    {
        Intent intent = new Intent(BROADCAST_ACTION_MULTIPLICAR);
        intent.putExtra(EXTRA_PARAM_VALOR_1, valor1);
        intent.putExtra(EXTRA_PARAM_VALOR_2, valor2);
        sendBroadcast(intent);
    }
}
