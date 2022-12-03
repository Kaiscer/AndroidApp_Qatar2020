package com.example.evaluaciont1_kaiscerv;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.evaluaciont1_kaiscerv.data.ListResult;
import com.example.evaluaciont1_kaiscerv.fragments.ResultFragment;

public class ConsultResultActivity extends AppCompatActivity {


    String country;
    EditText editText;
    Button btn;
    FrameLayout flResult1;
    FrameLayout flResult2;
    FrameLayout flResult3;
    FrameLayout flResult4;
    FrameLayout flResult5;
    FrameLayout flResult6;
    FrameLayout flResult7;


    ActivityResultLauncher<Intent>  startActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == SelectTeamsActivity.RESULT_OK_TEAM1){
                         editText.setText(result.getData().getStringExtra(SelectTeamsActivity.CLAVE_TEAM1));
                         country = editText.getText().toString();
                         btn.setText(R.string.txtChangeName);
                         FragmentManager fm = getSupportFragmentManager();
                         FragmentTransaction ft = fm.beginTransaction();


                        for (int i = 0; i < ListResult.getListResult(country).size(); i++) {
                            ResultFragment rf = new ResultFragment(country, i);
                            switch (i){
                                case 0:
                                    ft.add(R.id.fl_Result1, rf);
                                    break;
                                case 1:
                                    ft.add(R.id.fl_Result2, rf);
                                    break;
                                case 2:
                                    ft.add(R.id.fl_Result3, rf);
                                    break;
                                case 3:
                                    ft.add(R.id.fl_Result4, rf);
                                    break;
                                case 4:
                                    ft.add(R.id.fl_Result5, rf);
                                    break;
                                case 5:
                                    ft.add(R.id.fl_Result6, rf);
                                    break;
                                case 6:
                                    ft.add(R.id.fl_Result7, rf);
                                    break;
                            }
                        }
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_result);

        editText = findViewById(R.id.edit_SelectTeam3);
        btn = findViewById(R.id.btn_SelectTeam3);
        flResult1 = findViewById(R.id.fl_Result1);
        flResult2 = findViewById(R.id.fl_Result2);
        flResult3 = findViewById(R.id.fl_Result3);
        flResult4 = findViewById(R.id.fl_Result4);
        flResult5 = findViewById(R.id.fl_Result5);
        flResult6 = findViewById(R.id.fl_Result6);
        flResult7 = findViewById(R.id.fl_Result7);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btn_SelectTeam3) {
                    selectTeamsConsult();
                }
            }
        });
    }

    private void selectTeamsConsult() {

        if (!editText.getText().toString().equals(country)){
            Intent intent = new Intent(this, SelectTeamsActivity.class);
            intent.putExtra("team", "team1");
            startActivityForResult.launch(intent);
        }else{
            clearConsult();
        }


    }

    private void clearConsult() {
        editText.setText(R.string.txt);
        btn.setText(R.string.backName);
        flResult1.removeAllViews();
        flResult2.removeAllViews();
        flResult3.removeAllViews();
        flResult4.removeAllViews();
        flResult5.removeAllViews();
        flResult6.removeAllViews();
        flResult7.removeAllViews();
    }
}