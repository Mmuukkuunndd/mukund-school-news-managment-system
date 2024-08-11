package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class threeee extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threeee);
        EditText usename,password;
        Button login;
        usename=findViewById(R.id.editTextText);
        password=findViewById(R.id.editTextText2);
        login=findViewById(R.id.button4);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a,b;
                a=usename.getText().toString();
                b=password.getText().toString();
                if(a.equals("Mukund")&&b.equals("8"))
                {
                    Toast.makeText(threeee.this,"Login Succesfully",Toast.LENGTH_SHORT).show();
                    Intent a1=new Intent(getApplicationContext(),Four.class);
                    startActivity(a1);
                }

                else if(a.equals("Core")&&b.equals("10"))
                {
                    Toast.makeText(threeee.this,"Login Succesfully",Toast.LENGTH_SHORT).show();
                    Intent a1=new Intent(getApplicationContext(),six.class);
                    startActivity(a1);
                }

                else if(a.equals("facultyy")&&b.equals("3"))
                {
                    Toast.makeText(threeee.this,"Login Succesfully",Toast.LENGTH_SHORT).show();
                    Intent a12=new Intent(getApplicationContext(), fiveee.class);
                    startActivity(a12);
                }
            }
        });
    }
}