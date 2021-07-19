package com.example.ymca_parking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText username,password;
    Button signin,admin;
    database1 DB;







    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        DB=new database1(this);


        signin = (Button) findViewById(R.id.signin);
        admin=(Button)findViewById(R.id.newuser);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(MainActivity.this, MainActivity3.class);
                //startActivity(i);
                if(username.getText().toString().equals("Admin") && password.getText().toString().equals("Admin123"))
                {
                    Intent i = new Intent(MainActivity.this, MainActivity5.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"invalid user",'2').show();
                }

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass= password.getText().toString();


                if (user.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this,"please enter all fields",'2').show();
                else {
                    Boolean checkuserpass= DB.checkusernamepassword(user,pass);
                    if (checkuserpass == true) {
                        Toast.makeText(MainActivity.this,"sign in successfull",'2').show();
                        Intent i= new Intent(MainActivity.this,MainActivity4.class);
                        i.putExtra("mainuser",user);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(MainActivity.this,"invalid credentials",'2').show();
                    }
                }
            }
        });
    }
}