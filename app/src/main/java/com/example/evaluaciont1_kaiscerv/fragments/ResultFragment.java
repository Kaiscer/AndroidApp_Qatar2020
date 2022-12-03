package com.example.evaluaciont1_kaiscerv.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.evaluaciont1_kaiscerv.R;
import com.example.evaluaciont1_kaiscerv.data.ListResult;
import com.example.evaluaciont1_kaiscerv.data.Result;

import java.util.ArrayList;


public class ResultFragment extends Fragment {

    TextView tvPhase;
    TextView tvDateTime;
    TextView tvTeam1;
    TextView tvScoreT1;
    TextView tvTeam2;
    TextView tvScoreT2;
    String teams;
    int matches;

    public ResultFragment(String country, int match ) {

        teams = country;
        matches = match;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        tvPhase = view.findViewById(R.id.tv_Phase);
        tvDateTime = view.findViewById(R.id.tv_DateTime);
        tvTeam1 = view.findViewById(R.id.tv_Team1);
        tvScoreT1 = view.findViewById(R.id.tv_ScoreT1);
        tvTeam2 = view.findViewById(R.id.tv_Team2);
        tvScoreT2 = view.findViewById(R.id.tv_Score2);

        ArrayList<Result> listMatches = ListResult.getListResult(teams);

        tvPhase.setText(listMatches.get(matches).getPhase());
        tvDateTime.setText(listMatches.get(matches).getDateTime());
        tvTeam1.setText(listMatches.get(matches).getTeam1());
        tvScoreT1.setText(String.valueOf(listMatches.get(matches).getScoreTeam1()));
        tvTeam2.setText(listMatches.get(matches).getTeam2());
        tvScoreT2.setText(String.valueOf(listMatches.get(matches).getScoreTeam2()));

        return view;
    }
}