package com.example.mark.testbase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by User on 23.08.2016.
 */
public class Friends extends AppCompatActivity implements View.OnClickListener{

    Button btnAllFriends, btnAddFriend;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biblioteka);

        btnAllFriends = (Button) findViewById(R.id.btnAllFriends);
        btnAddFriend = (Button) findViewById(R.id.btnAddFriend);

        btnAllFriends.setOnClickListener(this);
        btnAddFriend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //переходим на экран со всеми книгами
            case R.id.btnAllFriends:
                Toast.makeText(this, "Не реализовано", Toast.LENGTH_SHORT).show();
                break;
            //переходим на экран добавления новой книги
            case R.id.btnAddFriend:
                Intent intent = new Intent(this, AddFriend.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
