package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class six extends AppCompatActivity {
    DBhelper3 db;
    dbhelper5 db1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        EditText t1,t2,t3,t4;
        Button b,b2;
       t1=findViewById(R.id.editTextText9);
        t2=findViewById(R.id.editTextText10);
        t3=findViewById(R.id.editTextText11);
        b=findViewById(R.id.button7);
        t4=findViewById(R.id.editTextText13);
        b2=findViewById(R.id.button10);
        db=new DBhelper3(this);
        db1=new dbhelper5(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Roll,Name,contact;
                Roll=t1.getText().toString();
                Name=t2.getText().toString();
                contact=t3.getText().toString();
                Boolean  checkinsertdata=db.insertuserdata(Roll,Name,contact);
                if(checkinsertdata==true)
                {
                    Toast.makeText(six.this,"New entry inserted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(six.this,"New entry not inserted",Toast.LENGTH_SHORT).show();
                }
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o;
                o=t4.getText().toString();
                Boolean  checkinsertdata=db1.insertuserdata(o);
                if(checkinsertdata==true)
                {
                    Toast.makeText(six.this,"News updated",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(six.this,"News not updated",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}