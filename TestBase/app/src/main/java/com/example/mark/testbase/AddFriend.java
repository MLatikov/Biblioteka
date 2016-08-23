package com.example.mark.testbase;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddFriend extends AppCompatActivity implements View.OnClickListener {

    Button btnAddFriendОК, btnAddFriendCancel;
    EditText etdFriend;
    AddBook.DBHelper dbHelper;
    final String LOG_TAG = "myLogs";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addfriend);
        btnAddFriendОК = (Button) findViewById(R.id.btnAddFriendОК);
        btnAddFriendCancel = (Button) findViewById(R.id.btnAddFriendCancel);
        btnAddFriendОК.setOnClickListener(this);
        btnAddFriendCancel.setOnClickListener(this);
        etdFriend = (EditText)findViewById(R.id.etdFriend);

    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String friend = etdFriend.getText().toString();
        ContentValues cv = new ContentValues();

        switch (v.getId()){
            case R.id.btnAddFriendОК:
                cv.put("friend", friend);
                long rowID = db.insert("mytable", null, cv);
                Log.d(LOG_TAG, "row inserted, ID = " + rowID);
                Toast.makeText(this, "Ваш друг "+ friend + " успешно куда-то добавлен", Toast.LENGTH_SHORT).show();
                etdFriend.setText("");
                break;
            case R.id.btnAddFriendCancel:
                finish();
                break;
            default:
                break;
        }
        dbHelper.close();
    }
}
