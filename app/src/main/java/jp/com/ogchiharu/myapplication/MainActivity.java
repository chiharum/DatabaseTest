package jp.com.ogchiharu.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    MySQLiteOpenHelper mySQLiteOpenHelper;
    SQLiteDatabase database;
    static final String TABLE_NAME = "database_table";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySQLiteOpenHelper = new MySQLiteOpenHelper(getApplicationContext());
        database = mySQLiteOpenHelper.getWritableDatabase();

        insert("a", 10);
        insert("b", 20);

        Log.e("10", search(10));
        Log.e("20", search(20));
    }

    public void insert(String textA, int number){

        ContentValues values = new ContentValues();

        values.put("textA", textA);
        values.put("number", number);

        database.insert(TABLE_NAME, null, values);
    }

    public String search(int numberNumber){

        Cursor cursor = null;
        String result = "";

        try{
            cursor = database.query(TABLE_NAME, new String[]{"textA", "number"}, "number = ?", new String[]{"" + numberNumber}, null, null, null);

            int indexText = cursor.getColumnIndex("textA");
            int indexNumber = cursor.getColumnIndex("number");

            while (cursor.moveToNext()) {
                String textA = cursor.getString(indexText);
                int number = cursor.getInt(indexNumber);

                result += "text:" + textA + " number:" + number + "\n";
            }
        }finally {
            if(cursor != null){
                cursor.close();
            }
        }

        return result;
    }
}
