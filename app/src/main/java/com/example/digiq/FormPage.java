package com.example.digiq;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormPage extends AppCompatActivity {
    EditText idName , idApp , idPhone , idEmail;
    Button btnJoin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_page);

        idName=findViewById(R.id.idName);
        idApp=findViewById(R.id.idApp);
        idPhone=findViewById(R.id.idphone);
        idEmail=findViewById(R.id.idEmail);
        btnJoin=findViewById(R.id.btnJoin);

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        btnJoin.setOnClickListener(v -> {
            if(idName.getText().toString().isEmpty() || idPhone.getText().toString().isEmpty() || idApp.getText().toString().isEmpty() || idEmail.getText().toString().isEmpty())
            {
                Toast.makeText(FormPage.this,"Please Enter ALL Fields!",Toast.LENGTH_SHORT).show();
            }

            else if(!idEmail.getText().toString().matches(emailPattern)) {
                Toast.makeText(FormPage.this,"Please Enter a VALID Email Address",Toast.LENGTH_SHORT).show();
            }

            else if(idPhone.getText ().toString ().trim ().length () < 10) {
                Toast.makeText(FormPage.this,"Please Enter a VALID Phone Number",Toast.LENGTH_SHORT).show();
            }

            else{
                Intent intent = new Intent(FormPage.this, QueuePage.class);
                intent.putExtra("Name", idName.getText().toString().trim());
                intent.putExtra("ApplicationNumber", idApp.getText().toString().trim());
                startActivity(intent);
            }
        });



    }

}