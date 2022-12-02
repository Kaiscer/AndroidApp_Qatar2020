package com.example.evaluaciont1_kaiscerv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SelectTeamsActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int RESULT_OK_TEAM1 = 101;
    public static final String CLAVE_TEAM1 = "TEAM1";
    public static final int RESULT_OK_TEAM2 = 102;
    public static final String CLAVE_TEAM2 = "TEAM2";


    Button btnGermany,btnArabiaSaudi,btn_Argentina;
    Button btnAustralia,btnBelgium,btnBrazil;
    Button btnCameroon, btnCanada, btnSouthKorea;
    Button btnCostRica, btnCroatia, btnDenmark;;
    Button btnEcuador, btnSpain, btnUnitedStates;
    Button btnFrance, btnGales, btnGhana;
    Button btnNederland, btnEngland, btnIran;
    Button btnJapan,btnMorocco, btnMexico, btnPoland;
    Button btnPortugal, btnQatar, btnSenegal;
    Button btnSerbia, btnSwitzerland, btnTunisia, btnUruguay;
    Button btnAccept, btnCancel;
    EditText etCountrySelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_teams);
        references();
    }

    private void references() {
        btnGermany = findViewById(R.id.btn_Germany);
        btnGermany.setOnClickListener(this);
        btnArabiaSaudi = findViewById(R.id.btn_ArabiaSaudi);
        btnArabiaSaudi.setOnClickListener(this);
        btn_Argentina = findViewById(R.id.btn_Argentina);
        btn_Argentina.setOnClickListener(this);
        btnAustralia = findViewById(R.id.btn_Australia);
        btnAustralia.setOnClickListener(this);
        btnBelgium = findViewById(R.id.btn_Belgium);
        btnBelgium.setOnClickListener(this);
        btnBrazil = findViewById(R.id.btn_Brazil);
        btnBrazil.setOnClickListener(this);
        btnCameroon = findViewById(R.id.btn_Cameroon);
        btnCameroon.setOnClickListener(this);
        btnCanada = findViewById(R.id.btn_Canada);
        btnCanada.setOnClickListener(this);
        btnSouthKorea = findViewById(R.id.btn_SouthKorea);
        btnSouthKorea.setOnClickListener(this);
        btnCostRica = findViewById(R.id.btn_CostRica);
        btnCostRica.setOnClickListener(this);
        btnCroatia = findViewById(R.id.btn_Croatia);
        btnCroatia.setOnClickListener(this);
        btnDenmark = findViewById(R.id.btn_Denmark);
        btnDenmark.setOnClickListener(this);
        btnEcuador = findViewById(R.id.btn_Ecuador);
        btnEcuador.setOnClickListener(this);
        btnSpain = findViewById(R.id.btn_Spain);
        btnSpain.setOnClickListener(this);
        btnUnitedStates = findViewById(R.id.btn_UnitedStates);
        btnUnitedStates.setOnClickListener(this);
        btnFrance = findViewById(R.id.btn_France);
        btnFrance.setOnClickListener(this);
        btnGales = findViewById(R.id.btn_Gales);
        btnGales.setOnClickListener(this);
        btnGhana = findViewById(R.id.btn_Ghana);
        btnGhana.setOnClickListener(this);
        btnNederland = findViewById(R.id.btn_Nederland);
        btnNederland.setOnClickListener(this);
        btnEngland = findViewById(R.id.btn_England);
        btnEngland.setOnClickListener(this);
        btnIran = findViewById(R.id.btn_Iran);
        btnIran.setOnClickListener(this);
        btnJapan = findViewById(R.id.btn_Japan);
        btnJapan.setOnClickListener(this);
        btnMorocco = findViewById(R.id.btn_Morocco);
        btnMorocco.setOnClickListener(this);
        btnMexico = findViewById(R.id.btn_Mexico);
        btnMexico.setOnClickListener(this);
        btnPoland = findViewById(R.id.btn_Poland);
        btnPoland.setOnClickListener(this);
        btnPortugal = findViewById(R.id.btn_Portugal);
        btnPortugal.setOnClickListener(this);
        btnQatar = findViewById(R.id.btn_Qatar);
        btnQatar.setOnClickListener(this);
        btnSenegal = findViewById(R.id.btn_Senegal);
        btnSenegal.setOnClickListener(this);
        btnSerbia = findViewById(R.id.btn_Serbia);
        btnSerbia.setOnClickListener(this);
        btnSwitzerland = findViewById(R.id.btn_Switzerland);
        btnSwitzerland.setOnClickListener(this);
        btnTunisia = findViewById(R.id.btn_Tunisia);
        btnTunisia.setOnClickListener(this);
        btnUruguay = findViewById(R.id.btn_Uruguay);
        btnUruguay.setOnClickListener(this);
        btnAccept = findViewById(R.id.btn_Accept);
        btnAccept.setOnClickListener(this);
        btnCancel = findViewById(R.id.btn_Cancel);
        btnCancel.setOnClickListener(this);
        etCountrySelect = findViewById(R.id.edit_CountrySelected);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_Accept){
           if(etCountrySelect.getText().toString().isEmpty()){
               Toast.makeText(this, R.string.select_country, Toast.LENGTH_LONG).show();
           }else{
               String key = getIntent().getStringExtra("team");
               if (key.equals("team1")){
                    Intent intent = new Intent();
                    intent.putExtra(CLAVE_TEAM1, etCountrySelect.getText().toString());
                    setResult(RESULT_OK_TEAM1, intent);
                    finish();
               }else if (key.equals("team2")){
                   Intent intent = new Intent();
                   intent.putExtra(CLAVE_TEAM2, etCountrySelect.getText().toString());
                   setResult(RESULT_OK_TEAM2, intent);
                   finish();
               }

           }
        }else if (view.getId() == R.id.btn_Cancel){
            setResult(RESULT_CANCELED);
            finish();
        }else {
            Button btn = (Button) view;
            etCountrySelect.setText(btn.getText().toString());
        }
    }
}