package com.example.mark.testbase;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBib;
    Button btnPeople;


    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnBib = (Button) findViewById(R.id.btnBib);
        btnPeople = (Button) findViewById(R.id.btnPeople);
        btnBib.setOnClickListener(this);
        btnPeople.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //переходим на экран библиотеки
            case R.id.btnBib:
                Intent intent = new Intent(this, Biblioteka.class);
                startActivity(intent);
                break;
            // Открываем список друзей
            case R.id.btnPeople:
                Toast.makeText(this, "Не реализовано", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
