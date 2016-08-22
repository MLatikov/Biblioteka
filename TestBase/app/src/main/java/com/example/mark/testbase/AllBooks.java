package com.example.mark.testbase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.LinearLayout.*;


public class AllBooks extends AppCompatActivity {

    LinearLayout linearAllBooks;
    AddBook.DBHelper dbHelper;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allbooks);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        LinearLayout linearAllBooks = (LinearLayout) findViewById(R.id.linearAllBooks);



        Cursor c = db.query("mytable", null, null, null, null, null, null);

        if (c.moveToFirst()){
            int idColIndex = c.getColumnIndex("id");
            int authorColIndex = c.getColumnIndex("author");
            int booknameColIndex = c.getColumnIndex("bookname");
            do {
                //тут должны будут создаваться поля и выводиться имя автора и название книги


            } while (c.moveToNext());

        } else
            Toast.makeText(this, "Библиотека пуста", Toast.LENGTH_LONG).show();
        c.close();

    }
}
