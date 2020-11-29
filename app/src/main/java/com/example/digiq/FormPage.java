package com.example.digiq;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FormPage extends AppCompatActivity {
    EditText idName , idApp , idPhone , idEmail;
    Button btnJoin;

    FirebaseDatabase rootNode;
    DatabaseReference root_child;

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

            else if(idPhone.getText ().toString ().trim ().length () < 10) {
                Toast.makeText(FormPage.this,"Please Enter a VALID Phone Number",Toast.LENGTH_SHORT).show();
            }

            else{
                //calls the root node
                rootNode = FirebaseDatabase.getInstance();
                //calling the table
                root_child = rootNode.getReference("names").push();

                String name = idName.getText().toString();
                String application_no = idApp.getText().toString();
                String phone_no = idPhone.getText().toString();
                String email = idEmail.getText().toString();
                String form_fill = "0";
                String verified = "0";
                String file_created = "0";
                String payment = "0";
                String email_create = "0";

//                String [] keys = {"name","application_no","phone_no","email","form_fill","verified","file_created","payment"
//                                    ,"email_create"};
//
//                String [] values = {name, application_no, phone_no, email, form_fill, verified, file_created,
//                                    payment,email_create};
//
//                Map<String, JSONObject> userMap= new HashMap<String, JSONObject>();
//                JSONObject obj = new JSONObject();
//                try {
//                    obj.put("name",name);
//                    obj.put("application_no",application_no);
//                    obj.put("phone_no",phone_no);
//                    obj.put("email",email);
//                    obj.put("form_fill","0");
//                    obj.put("verified","0");
//                    obj.put("file_created","0");
//                    obj.put("payment","0");
//                    obj.put("email_create","0");
//                } catch (JSONException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//                userMap.put("myUser", obj);

                UserHelper obj = new UserHelper(name,application_no,phone_no,email,form_fill,verified,file_created,payment,email_create);
                //creating new child
                obj.setName(name);
                obj.setApplication_no(application_no);
                obj.setPhone_no(phone_no);
                obj.setEmail(email);
                obj.setForm_fill(form_fill);
                obj.setVerified(verified);
                obj.setFile_created(file_created);
                obj.setPayment(payment);
                obj.setEmail_create(email_create);
//                Toast.makeText(getApplicationContext(),"Done", Toast.LENGTH_LONG).show();

                root_child.setValue(obj);

                Intent intent = new Intent(FormPage.this, QueuePage.class);
                intent.putExtra("Name", idName.getText().toString().trim());
                intent.putExtra("ApplicationNumber", idApp.getText().toString().trim());
                startActivity(intent);
            }
        });



    }

}