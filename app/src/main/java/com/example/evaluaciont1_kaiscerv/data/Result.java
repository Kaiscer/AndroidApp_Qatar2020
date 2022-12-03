package com.example.evaluaciont1_kaiscerv.data;

public class Result {

      private String phase;
      private String dateTime;
      private String team1;
      private int scoreTeam1;
      private String team2;
      private int scoreTeam2;

    public Result(String phase, String dateTime, String team1, int scoreTeam1, String team2, int scoreTeam2) {
        this.phase = phase;
        this.dateTime = dateTime;
        this.team1 = team1;
        this.scoreTeam1 = scoreTeam1;
        this.team2 = team2;
        this.scoreTeam2 = scoreTeam2;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getPhase() {
        return phase;
    }

    public String getDateTime() {
        return dateTime;
    }

    public int getScoreTeam1() {
        return scoreTeam1;
    }

    public int getScoreTeam2() {
        return scoreTeam2;
    }

    @Override
    public String toString() {
        return "Result{" +
                "phase='" + phase + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", team1='" + team1 + '\'' +
                ", scoreTeam1=" + scoreTeam1 +
                ", team2='" + team2 + '\'' +
                ", scoreTeam2=" + scoreTeam2 +
                '}';
    }
}
