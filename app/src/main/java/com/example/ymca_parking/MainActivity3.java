package com.example.ymca_parking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    EditText name,email,newpassword,crnewpassword;
    Button confirm;
    database1 DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        name=(EditText) findViewById(R.id.name);
        email=(EditText)findViewById(R.id.phone);
        newpassword=(EditText)findViewById(R.id.newpassword);
        crnewpassword=(EditText)findViewById(R.id.crnewpassword);
        confirm=(Button)findViewById(R.id.confirm);
        DB= new database1(this);

        confirm.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String id=email.getText().toString();
                String npass=newpassword.getText().toString();
                String crnpass=crnewpassword.getText().toString();

                if (username.equals("")||npass.equals("")||crnpass.equals("")||id.equals(""))
                    Toast.makeText(MainActivity3.this,"please enter all the fields",2).show();
                else {
                    if (npass.equals(crnpass)){
                        Boolean checkuser=DB.checkusername(username);
                        if (checkuser==false){
                            Boolean insert=DB.insertData(username,npass,id);
                            if (insert == true) {
                                Toast.makeText(MainActivity3.this,"registerd successfully",2).show();
                                Intent i=new Intent(MainActivity3.this,MainActivity.class);
                                startActivity(i);
                            }
                            else {
                                Toast.makeText(MainActivity3.this,"registeration failed",2).show();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity3.this,"user already exist",2).show();
                        }
                    }
                    else {
                        Toast.makeText(MainActivity3.this,"password does not match",2).show();
                    }
                }
            }
        });
    }
}