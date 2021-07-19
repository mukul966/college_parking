package com.example.ymca_parking;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {
    EditText eu,er;
    Button vu,vp;
    database1 Mydb;
    vehicle db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        eu=findViewById(R.id.eu);
        er=findViewById(R.id.er);
        vu=findViewById(R.id.vu);
        vp=findViewById(R.id.vp);

        db=new vehicle(this);
        Mydb=new database1(this);

        vu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=eu.getText().toString();

                Cursor res=Mydb.getdata(user);

                if(res.getCount()==0)
                {
                    Toast.makeText(MainActivity6.this,"no user found", Integer.parseInt("2")).show();

                }


                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("username  :"+res.getString(0)+"\n");
                    buffer.append("password  :"+res.getString(1)+"\n");
                    buffer.append("phone_no. :"+res.getString(2)+"\n");


                }
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity6.this);
                builder.setCancelable(true);
                builder.setTitle("USER_DETAILS");
                builder.setMessage(buffer.toString());
                builder.show();


            }
        });

        vp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String reg=er.getText().toString();
                Cursor res=db.dataparking(reg);

                if(res.getCount()==0)
                {
                    Toast.makeText(MainActivity6.this,"no booking found", Integer.parseInt("2")).show();

                }


                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext())
                {
                   // buffer.append("username     :"+res.getString(0)+"\n");
                    buffer.append("registration :"+res.getString(0)+"\n");
                    buffer.append("entry_date   :"+res.getString(1)+"\n");
                    buffer.append("entry_time   :"+res.getString(2)+"\n");
                    buffer.append("exit_date    :"+res.getString(3)+"\n");
                    buffer.append("exit_time    :"+res.getString(4)+"\n");

                }
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity6.this);
                builder.setCancelable(true);
                builder.setTitle("BOOKING_DETAILS");
                builder.setMessage(buffer.toString());
                builder.show();


            }
        });

    }
}