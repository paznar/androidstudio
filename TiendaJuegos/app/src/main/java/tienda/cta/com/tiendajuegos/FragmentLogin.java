package tienda.cta.com.tiendajuegos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FragmentLogin extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        final Context context = getActivity();
        final EditText editNombre = (EditText) view.findViewById(R.id.editNombre);
        final EditText editPassword = (EditText) view.findViewById(R.id.editPassword);
        Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editNombre.getText().toString().trim().isEmpty())
                    Toast.makeText(context, "El campo nombre no puede estar vacío.", Toast.LENGTH_LONG).show();
                else if (editPassword.getText().toString().trim().isEmpty())
                    Toast.makeText(context, "El campo contraseña no puede estar vacío.", Toast.LENGTH_LONG).show();
                else {
                    SQLiteDatabase db = context.openOrCreateDatabase("TiendaDB", context.MODE_PRIVATE, null);
                    Cursor c = db.rawQuery("SELECT nombre FROM Cliente WHERE nombre = '" + editNombre.getText().toString().trim()
                            + "' AND password = '" + editPassword.getText().toString().trim() + "'", null);
                    if (c.moveToFirst())
                        Toast.makeText(context, "Usuario correcto.", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(context, "Usuario incorrecto.", Toast.LENGTH_LONG).show();
                    c.close();
                    db.close();
                }
            }
        });
    }
}
