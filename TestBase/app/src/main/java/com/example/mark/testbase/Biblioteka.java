package com.example.mark.testbase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by User on 18.08.2016.
 */
public class Biblioteka extends AppCompatActivity implements View.OnClickListener {

    Button btnAllBooks;
    Button btnAddBook;
    AddBook.DBHelper dbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biblioteka);

        btnAllBooks = (Button) findViewById(R.id.btnAllBooks);
        btnAddBook = (Button) findViewById(R.id.btnAddBook);

        btnAllBooks.setOnClickListener(this);
        btnAddBook.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAllBooks:
                Toast.makeText(this, "Не реализовано", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAddBook:
                Intent intent = new Intent(this, AddBook.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
