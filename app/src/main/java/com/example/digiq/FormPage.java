package com.example.digiq;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FormPage extends AppCompatActivity {
    EditText idName , idApp , idPhone , idEmail;
    Button btnJoin;

    FirebaseDatabase rootNode;
    DatabaseReference root_child;

    long incrementer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_page);

        idName=findViewById(R.id.idName);
        idApp=findViewById(R.id.idApp);
        idPhone=findViewById(R.id.idPhone);
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

            else if(idPhone.getText().toString().trim().length() < 10) {
                Toast.makeText(FormPage.this,"Please Enter a VALID Phone Number",Toast.LENGTH_SHORT).show();
            }

            else{
                //calls the root node
                rootNode = FirebaseDatabase.getInstance();
                //calling the table
                root_child = rootNode.getReference("names").push();

                root_child.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            incrementer = snapshot.getChildrenCount();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                String name = idName.getText().toString();
                String application_no = idApp.getText().toString();
                String phone_no = idPhone.getText().toString();
                String email = idEmail.getText().toString();
                String form_fill = "0";
                String verified = "0";
                String file_created = "0";
                String payment = "0";
                String email_create = "0";
                String ticket_no = String.valueOf(incrementer);
                String time_rem = "";

                UserHelper obj = new UserHelper(name,application_no,phone_no,email,ticket_no,form_fill,verified,file_created,payment,email_create,time_rem);
                //creating new child
                obj.setName(name);
                obj.setApplication_no(application_no);
                obj.setPhone_no(phone_no);
                obj.setEmail(email);
                obj.setTicket_no(ticket_no);
                obj.setForm_fill(form_fill);
                obj.setVerified(verified);
                obj.setFile_created(file_created);
                obj.setPayment(payment);
                obj.setEmail_create(email_create);
                obj.setTime_rem(time_rem);

                //adding a new child
                root_child.setValue(obj);
                String token = String.valueOf(root_child).substring(41);
//                Toast.makeText(FormPage.this,String.valueOf(token), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(FormPage.this, QueuePage.class);
                intent.putExtra("Name", idName.getText().toString().trim());
                intent.putExtra("ApplicationNumber", idApp.getText().toString().trim());
                intent.putExtra("token",token);
                startActivity(intent);
            }
        });



    }

}