package com.example.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class fiveee extends AppCompatActivity {
    DBhelper2 db;
    DBHELPER db2;
    dbhelper4 db1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiveee);
        EditText t1,t2,t3,t4;
        Button b,b2,b3;
        t1=findViewById(R.id.editTextText6);
        t2=findViewById(R.id.editTextText7);
        t3=findViewById(R.id.editTextText8);
        t4=findViewById(R.id.editTextText12);
        b=findViewById(R.id.button6);
        b2=findViewById(R.id.button8);//student detailse
        b3=findViewById(R.id.button9);
        db=new DBhelper2(this);
        db1=new dbhelper4(this);
        db2=new DBHELPER(this);
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
                    Toast.makeText(fiveee.this,"New entry inserted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(fiveee.this,"New entry not inserted",Toast.LENGTH_SHORT).show();
                }
            }


        });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String Roll;
                    Roll=t4.getText().toString();
                    Boolean  checkinsertdata=db1.insertuserdata(Roll);
                    if(checkinsertdata==true)
                    {
                        Toast.makeText(fiveee.this,"News updated",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(fiveee.this," not updated",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cursor res= db2.getdata();
                    if(res.getCount()==0)
                    {
                        Toast.makeText(fiveee.this,"no entry exist",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    StringBuffer buffer=new StringBuffer();
                    while(res.moveToNext())
                    {
                        buffer.append("Name:"+res.getString(0)+"\n");
                         buffer.append("Adress:"+res.getString(1)+"\n");
                        buffer.append("Contact:"+res.getString(2)+"\n\n");
                    }
                    AlertDialog.Builder builder=new AlertDialog.Builder(fiveee.this);
                    builder.setCancelable(true);
                    builder.setTitle("Student details entries:");
                    builder.setMessage(buffer.toString());
                    builder.show();
                }
            });
    }
}