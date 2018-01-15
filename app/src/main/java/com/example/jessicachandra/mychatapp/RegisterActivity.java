package com.example.jessicachandra.mychatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

   static FirebaseDatabase database = FirebaseDatabase.getInstance();
   static DatabaseReference myRef = database.getReference("users");

   EditText etNama ,etTlp, etEmail;
   Button btRegister, btLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etNama = (EditText) findViewById(R.id.etNama);
        etTlp = (EditText) findViewById(R.id.etTlp);
        etEmail = (EditText) findViewById(R.id.etEmail);
        btLogin = (Button) findViewById(R.id.btLogin);
        btRegister = (Button) findViewById(R.id.btRegister);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
            btRegister.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick (View view) {
                User user = new User();
                user.setNama(etNama.getText().toString());
                user.setTelpon(etTlp.getText().toString());
                user.setEmail(etEmail.getText().toString());

                user.register();
                Toast.makeText(RegisterActivity.this,"registration successful",Toast.LENGTH_LONG).show();
                etNama.setText("");
                etTlp.setText("");
                etEmail.setText("");
            }
        });


    }}