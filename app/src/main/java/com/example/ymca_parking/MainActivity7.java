package com.example.ymca_parking;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {
    EditText updateuser,updatepass,updatephone;
    Button update,delete,view;

    database1 MyDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        updateuser=findViewById(R.id.updateuser);
        updatepass=findViewById(R.id.updatepass);
        updatephone=findViewById(R.id.updatephone);

        update=findViewById(R.id.update);
        delete=findViewById(R.id.del);
        view=findViewById(R.id.view);
        MyDB=new database1(this);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=updateuser.getText().toString();
                String pass=updatepass.getText().toString();
                String phone=updatephone.getText().toString();

                Boolean checkdata=MyDB.updatedata(user,pass,phone);
                if(checkdata==true)
                    Toast.makeText(MainActivity7.this,"entry updated",Integer.parseInt("2")).show();
                else
                    Toast.makeText(MainActivity7.this,"entry not updated",Integer.parseInt("2")).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String user=updateuser.getText().toString();
                Boolean delete=MyDB.deletedata(user);
                if(delete==true)
                    Toast.makeText(MainActivity7.this,"entry deleted",Integer.parseInt("2")).show();
                else
                    Toast.makeText(MainActivity7.this,"entry not deleted",Integer.parseInt("2")).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=updateuser.getText().toString();

                Cursor res=MyDB.getdata(user);

                if(res.getCount()==0)
                {
                    Toast.makeText(MainActivity7.this,"no user found", Integer.parseInt("2")).show();

                }


                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("username  :"+res.getString(0)+"\n");
                    buffer.append("password  :"+res.getString(1)+"\n");
                    buffer.append("phone_no. :"+res.getString(2)+"\n");


                }
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity7.this);
                builder.setCancelable(true);
                builder.setTitle("USER_DETAILS");
                builder.setMessage(buffer.toString());
                builder.show();



            }
        });








    }
}