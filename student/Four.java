package com.example.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Four extends AppCompatActivity {

    DBHELPER db;
    dbhelper5 db1;
    DBhelper2 db2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        EditText roll,name,adress;
        Button save,b2,b3;
        roll=findViewById(R.id.editTextText3);
        name=findViewById(R.id.editTextText4);
        adress=findViewById(R.id.editTextText5);
        save=findViewById(R.id.button5);
        b2=findViewById(R.id.button11);
        b3=findViewById(R.id.button12);
        db=new DBHELPER(this);
        db1=new dbhelper5(this);
        db2=new DBhelper2(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Roll,Name,contact;
                Roll=roll.getText().toString();
                Name=name.getText().toString();
                contact=adress.getText().toString();
                Boolean  checkinsertdata=db.insertuserdata(Roll,Name,contact);
                if(checkinsertdata==true)
                {
                    Toast.makeText(Four.this,"New entry inserted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Four.this,"New entry not inserted",Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res= db1.getdata();
                if(res.getCount()==0)
                {
                    Toast.makeText(Four.this,"no entry exist",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("Name:"+res.getString(0)+"\n");
                  //  buffer.append("Adress:"+res.getString(1)+"\n");
                    //buffer.append("Contact:"+res.getString(2)+"\n\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(Four.this);
                builder.setCancelable(true);
                builder.setTitle("Core News:");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res= db2.getdata();
                if(res.getCount()==0)
                {
                    Toast.makeText(Four.this,"no entry exist",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("Name:"+res.getString(0)+"\n");
                  buffer.append("Adress:"+res.getString(1)+"\n");
                   buffer.append("Contact:"+res.getString(2)+"\n\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(Four.this);
                builder.setCancelable(true);
                builder.setTitle("Faculty news:");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}