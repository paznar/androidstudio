package provider.com.ejercicioprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

/**
 * Created by cta on 04/05/2015.
 */
public class ProductoProvider extends ContentProvider
{

    //Campos para mi provider.
    static final String PROVIDER_NAME = "com.provider.ProductoProvider";
    static final String URL = "content://" + PROVIDER_NAME;
    static final Uri CONTENT_URI = Uri.parse(URL);

    //Declaraciones para mi Base de Datos
    private SQLiteDatabase database;
    static final String DATABASE_NAME = "ProductosDB";
    static final String TABLE_NAME = "Productos";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_TABLE =
            " CREATE TABLE " + TABLE_NAME +
            " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " nombre VARCHAR," +
            " cantidad INT," +
            " precio INT);";

    //Columnas de la tabla PRODUCTOS de mi Base de Datos
    static final String ID = "id";
    static final String NOMBRE = "nombre";
    static final String CANTIDAD = "cantidad";
    static final String PRECIO = "precio";

    //Clase para manejar la Base de Datos
    DBHelper dbHelper;

    @Override
    public boolean onCreate()
    {
        Context context = getContext();
        dbHelper = new DBHelper(context);
        //Añadimos permisos de escritura
        database = dbHelper.getWritableDatabase();

        if(database == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
    {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        //Seteamos la tabla
        queryBuilder.setTables(TABLE_NAME);

        if (sortOrder == null || sortOrder == "")
        {
            // No sorting-> sort on names by default
            sortOrder = NOMBRE;
        }

        Cursor cursor = queryBuilder.query(database, projection, selection,
                selectionArgs, null, null, sortOrder);

        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long row = database.insert(TABLE_NAME, "", values);

        // Si añade correctamente
        if(row > 0)
        {
            Uri newUri = ContentUris.withAppendedId(CONTENT_URI, row);
            getContext().getContentResolver().notifyChange(newUri, null);
            return newUri;
        }
        throw new SQLException("Error al añadir registro " + uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    private class DBHelper extends SQLiteOpenHelper
    {
        public DBHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(DBHelper.class.getName(),
                    "Upgrading database from version " + oldVersion + " to "
                            + newVersion + ". Old data will be destroyed");
            db.execSQL("DROP TABLE IF EXISTS " +  TABLE_NAME);
            onCreate(db);
        }
    }
}
