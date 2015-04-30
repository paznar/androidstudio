package tienda.cta.com.tiendajuegos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FragmentRegistro extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registro, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        final Context context = getActivity();
        final EditText editNombre = (EditText) view.findViewById(R.id.editNombre);
        final EditText editPassword = (EditText) view.findViewById(R.id.editPassword);
        final EditText editPassword2 = (EditText) view.findViewById(R.id.editPassword2);
        final EditText editEmail = (EditText) view.findViewById(R.id.editEmail);
        Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editNombre.getText().toString().trim().isEmpty())
                    Toast.makeText(context, "El campo nombre no puede estar vacío.", Toast.LENGTH_LONG).show();
                else if (editPassword.getText().toString().trim().isEmpty())
                    Toast.makeText(context, "El campo contraseña no puede estar vacío.", Toast.LENGTH_LONG).show();
                else if (!editPassword.getText().toString().equals(editPassword2.getText().toString()))
                    Toast.makeText(context, "Las contraseñas no coinciden.", Toast.LENGTH_LONG).show();
                else {
                    SQLiteDatabase db = context.openOrCreateDatabase("TiendaDB", context.MODE_PRIVATE, null);
                    db.execSQL("INSERT INTO Cliente (nombre, email, password, rol) VALUES ('" +
                            editNombre.getText().toString() + "', '" + editEmail.getText().toString() +
                            "', '" + editPassword.getText().toString() + "', 'Usuario')");
                    db.close();
                    Toast.makeText(context, "Usuario creado.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
