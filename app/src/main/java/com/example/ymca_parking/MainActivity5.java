package com.example.ymca_parking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// this is the activity which comes after clicking on ADMIN
public class MainActivity5 extends AppCompatActivity {
    Button viewdb,newmember,editdb;
    vehicle db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        viewdb=findViewById(R.id.viewdb);
        newmember=findViewById(R.id.newmember);
        editdb=findViewById(R.id.edb);

        editdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity5.this,MainActivity7.class);
                startActivity(i);

            }
        });

        newmember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity5.this,MainActivity3.class);
                startActivity(i);

            }
        });

        viewdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity5.this,MainActivity6.class);
                startActivity(i);




            }
        });









    }
}