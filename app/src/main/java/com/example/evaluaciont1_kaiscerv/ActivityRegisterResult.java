package com.example.evaluaciont1_kaiscerv;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegisterResult extends AppCompatActivity implements View.OnClickListener {

    EditText etDateTime;
    EditText etPhase;
    static EditText etSteam1;
    EditText etSteam2;
    EditText etGolTeam1;
    EditText etGolTeam2;
    Button btnSelectTeam1,btnSelectTeam2, btnSaveData, btnClearData;


    ActivityResultLauncher<Intent> startActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == SelectTeamsActivity.RESULT_OK_TEAM1) {
                        etSteam1.setText(result.getData().getStringExtra(SelectTeamsActivity.CLAVE_TEAM1));
                    }else if (result.getResultCode() == SelectTeamsActivity.RESULT_OK_TEAM2) {
                        etSteam2.setText(result.getData().getStringExtra(SelectTeamsActivity.CLAVE_TEAM2));
                    }

                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_result);
        references();
    }

    private void references() {
        etDateTime = findViewById(R.id.edit_DateTime);
        etPhase = findViewById(R.id.edit_Phase);
        etSteam1 = findViewById(R.id.edit_SelectTeam1);
        etSteam2 = findViewById(R.id.edit_SelectTeam2);
        etGolTeam1 = findViewById(R.id.edit_GolTeam1);
        etGolTeam2 = findViewById(R.id.edit_GolTeam2);
        btnSelectTeam1 = findViewById(R.id.btn_SelectTeam1);
        btnSelectTeam1.setOnClickListener(this);
        btnSelectTeam2 = findViewById(R.id.btn_SelectTeam2);
        btnSelectTeam2.setOnClickListener(this);
        btnSaveData = findViewById(R.id.btn_SaveResult);
        btnSaveData.setOnClickListener(this);
        btnClearData = findViewById(R.id.btn_ClearData);
        btnClearData.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        if (view == btnSelectTeam1 || view == btnSelectTeam2 ){
            selectTeams();
        }else if(view == btnSaveData){
            saveData();
        }else if (view == btnClearData){
            clearData();
        }
    }

    private void saveData() {
        String dataTime = etDateTime.getText().toString();
        String phase = etPhase.getText().toString();
        String team1 = etSteam1.getText().toString();
        String team2 = etSteam2.getText().toString();
        String golTeam1 = etGolTeam1.getText().toString();
        String golTeam2 = etGolTeam2.getText().toString();

        if (dataTime.isEmpty() || phase.isEmpty() || team1.isEmpty()
                || team2.isEmpty() || golTeam1.isEmpty() || golTeam2.isEmpty()){
            Toast.makeText(this,R.string.requestData, Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, R.string.save_messege, Toast.LENGTH_LONG).show();
            clearData();
        }
    }

    private void clearData() {
        etDateTime.setText("");
        etPhase.setText("");
        etSteam1.setText("");
        etSteam2.setText("");
        etGolTeam1.setText("");
        etGolTeam2.setText("");
    }

    private void selectTeams() {
        Intent intent = new Intent(this, SelectTeamsActivity.class);
        startActivityForResult.launch(intent);

    }
}