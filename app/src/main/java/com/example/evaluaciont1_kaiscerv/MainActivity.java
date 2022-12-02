package com.example.evaluaciont1_kaiscerv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRegister, btnConsult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        references();


    }

    private void references() {
        btnRegister = findViewById(R.id.btn_RegisterPoints);
        btnRegister.setOnClickListener(this);
        btnConsult = findViewById(R.id.btn_ConsultResult);
        btnConsult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnRegister){
            registerResult();
        }else if (view == btnConsult){
            consultResult();
        }
    }

    private void consultResult() {
        Intent intent = new Intent(this, ConsultResultActivity.class);
        startActivity(intent);
    }

    private void registerResult() {
        Intent intent = new Intent(this, ActivityRegisterResult.class);
        startActivity(intent);
    }
}