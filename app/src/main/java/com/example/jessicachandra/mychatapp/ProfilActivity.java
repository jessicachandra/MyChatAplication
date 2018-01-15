package com.example.jessicachandra.mychatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class ProfilActivity extends AppCompatActivity {
    TextView tvNama, tvEmail, tvNomor;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        tvNama = (TextView) findViewById(R.id.tvNama);
        tvNomor = (TextView) findViewById(R.id.tvNomor);
        tvEmail = (TextView) findViewById(R.id.tvEmail);

        user : getIntent().getParcelableExtra("user");

        tvNama.setText(user.getNama());
        tvEmail.setText(user.getEmail());
        tvNomor.setText(user.getTelpon());
    }
}
