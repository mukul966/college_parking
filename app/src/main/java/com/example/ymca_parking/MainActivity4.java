package com.example.ymca_parking;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    Button vb,nb;
    TextView tv1;
    vehicle db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv1=findViewById(R.id.tv1);
        String username=getIntent().getStringExtra("mainuser");
        tv1.setText(username);

        vb=findViewById(R.id.vb);
        nb=findViewById(R.id.nb);
        db=new vehicle(this);

        vb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=getIntent().getStringExtra("mainuser");
                Cursor res=db.getdata(username);

                if(res.getCount()==0)
                {
                    Toast.makeText(MainActivity4.this,"no booking found", Integer.parseInt("2")).show();

                }


                        StringBuffer buffer=new StringBuffer();
                        while (res.moveToNext())
                        {
                            buffer.append("username     :"+res.getString(0)+"\n");
                            buffer.append("registration :"+res.getString(1)+"\n");
                            buffer.append("entry_date   :"+res.getString(2)+"\n");
                            buffer.append("entry_time   :"+res.getString(3)+"\n");
                            buffer.append("exit_date    :"+res.getString(4)+"\n");
                            buffer.append("exit_time    :"+res.getString(5)+"\n");

                        }
                        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity4.this);
                        builder.setCancelable(true);
                        builder.setTitle("BOOKING_DETAILS");
                        builder.setMessage(buffer.toString());
                        builder.show();




            }
        });

        nb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity4.this,MainActivity2.class);
                i.putExtra("mainuser",username);
                startActivity(i);


            }
        });


    }
}