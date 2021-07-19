package com.example.ymca_parking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText registration,entrydate,entrytime,exitdate,exittime;
    TextView user,tv;
    Button book;
    vehicle db;
    database1 MydB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv=findViewById(R.id.tv);

        String username=getIntent().getStringExtra("mainuser");
        tv.setText(username);


        user=findViewById(R.id.username);
        registration=findViewById(R.id.registrationnumber);
        entrydate=findViewById(R.id.indate);
        entrytime=findViewById(R.id.intime);
        exitdate=findViewById(R.id.exdate);
        exittime=findViewById(R.id.extime);

        book=findViewById(R.id.bookslot);
        db=new vehicle(this);

        book.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {

                String reg = registration.getText().toString();
                String indate = entrydate.getText().toString();
                String intime = entrytime.getText().toString();
                String exdate = exitdate.getText().toString();
                String extime = exittime.getText().toString();
                String username=getIntent().getStringExtra("mainuser");



                if (reg.equals("") || indate.equals("") || intime.equals("") || exdate.equals("") || extime.equals(""))
                {
                    Toast.makeText(MainActivity2.this, "please enter all the fields", 2).show();
                }
                else
                    {

                    Boolean insert = db.insertdata(username,reg,indate,intime,exdate,extime);
                        if (insert == true)
                        {
                            Toast.makeText(MainActivity2.this, "parking booked", 2).show();
                            Intent i=new Intent(MainActivity2.this,MainActivity4.class);
                            startActivity(i);

                        }
                        else
                            {
                            Toast.makeText(MainActivity2.this, "booking failed", 2).show();
                        }
                    }


            }
        });
    }
}