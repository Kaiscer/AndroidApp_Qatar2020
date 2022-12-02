package com.example.evaluaciont1_kaiscerv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConsultResultActivity extends AppCompatActivity {

    static final String TXT_CLEAR = "Limpiar datos";
    EditText editText;
    Button btn;
    ActivityRegisterResult activityRegisterResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_result);

        editText = findViewById(R.id.edit_SelectTeam1);
        btn = findViewById(R.id.btn_SelectTeam1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btn_SelectTeam1) {
                    btn.setText(TXT_CLEAR);
                    activityRegisterResult.selectTeams();
                }
            }
        });
    }
}