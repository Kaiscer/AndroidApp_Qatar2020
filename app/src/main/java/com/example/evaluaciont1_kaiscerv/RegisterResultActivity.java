package com.example.evaluaciont1_kaiscerv;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.evaluaciont1_kaiscerv.data.ListResult;
import com.example.evaluaciont1_kaiscerv.data.Result;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterResultActivity extends AppCompatActivity implements View.OnClickListener {


    EditText etDateTime;
    final Calendar calendar = Calendar.getInstance();
    Spinner spPhase;
    EditText etSteam1;
    EditText etSteam2;
    EditText etGolTeam1;
    EditText etGolTeam2;
    Button btnSelectTeam1,btnSelectTeam2, btnSaveData, btnClearData;
    ListResult listResult;


    public RegisterResultActivity() {
        listResult = new ListResult();
    }

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

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                upgradeDateTime();
            }
        };
        etDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(RegisterResultActivity.this, date, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
    private void references() {
        etDateTime = findViewById(R.id.edit_DateTime);
        spPhase = findViewById(R.id.sp_Phase);
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
    private void upgradeDateTime() {
        String format = "dd/MM/yy";
        SimpleDateFormat FormatDate = new SimpleDateFormat(format, Locale.forLanguageTag("es"));
        etDateTime.setText(FormatDate.format(calendar.getTime()));
    }



    @Override
    public void onClick(View view) {
        if (view == btnSelectTeam1 || view == btnSelectTeam2){
            selectTeams();
        }else if(view == btnSaveData){
            saveData();
        }else if (view == btnClearData){
            clearData();
        }
    }

    private void saveData() {
        String dataTime = etDateTime.getText().toString();
        String phase = spPhase.getSelectedItem().toString();
        String team1 = etSteam1.getText().toString();
        String team2 = etSteam2.getText().toString();
        String golTeam1 = etGolTeam1.getText().toString();
        String golTeam2 = etGolTeam2.getText().toString();

        if (dataTime.isEmpty() || phase.isEmpty() || team1.isEmpty()
                || team2.isEmpty() || golTeam1.isEmpty() || golTeam2.isEmpty()){
            Toast.makeText(this,R.string.requestData, Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, R.string.save_messege, Toast.LENGTH_LONG).show();
            listResult.addResult(new Result(phase, dataTime, team1, Integer.parseInt(String.valueOf(golTeam1)),
                    team2, Integer.parseInt(String.valueOf(golTeam2))));

            /*for (Result result : listResult.getListResult()) {
                System.out.println(result.toString());
            }*/
            clearData();
        }
    }

    private void clearData() {
        etDateTime.setText("");
        spPhase.setSelection(0);
        etSteam1.setText("");
        etSteam2.setText("");
        etGolTeam1.setText("");
        etGolTeam2.setText("");
    }

    public void selectTeams() {
        if (btnSelectTeam1.isPressed()){
            Intent intent = new Intent(this, SelectTeamsActivity.class);
            intent.putExtra("team", "team1");
            startActivityForResult.launch(intent);
    }else if (btnSelectTeam2.isPressed()){
            Intent intent = new Intent(this, SelectTeamsActivity.class);
            intent.putExtra("team", "team2");
            startActivityForResult.launch(intent);
        }
    }
}