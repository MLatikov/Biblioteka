package com.example.mark.testbase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class AddBook extends AppCompatActivity implements View.OnClickListener {
    Button btnAddBookOK, btnAddBookCancel;
    EditText etdAuthor, etdBookName;
    final String LOG_TAG = "myLogs";
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbook);
        btnAddBookOK = (Button) findViewById(R.id.btnAddBookOK);
        btnAddBookCancel = (Button) findViewById(R.id.btnAddBookCancel);
        btnAddBookOK.setOnClickListener(this);
        btnAddBookCancel.setOnClickListener(this);
        etdAuthor = (EditText) findViewById(R.id.etdAuthor);
        etdBookName = (EditText) findViewById(R.id.etdBookName);
        dbHelper = new DBHelper(this);

    }

    @Override
    public void onClick(View view) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String author = etdAuthor.getText().toString();
        String bookname = etdBookName.getText().toString();

        switch (view.getId()){
            case R.id.btnAddBookOK:
                cv.put("author", author);
                cv.put("bookname", bookname);
                long rowID = db.insert("mytable", null, cv);
                Log.d(LOG_TAG, "row inserted, ID = " + rowID);
                Toast.makeText(this, author + " "+ bookname +" успешно добавлена", Toast.LENGTH_SHORT).show();
                etdAuthor.setText("");
                etdBookName.setText("");
                break;
            case R.id.btnAddBookCancel:
                finish();
                break;
        }
        dbHelper.close();
    }
    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, "myBooks", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "Создали базу");
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "author text,"
                    + "bookname text,"
                    + "status text"
                    + "friend text"
                    + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
}
