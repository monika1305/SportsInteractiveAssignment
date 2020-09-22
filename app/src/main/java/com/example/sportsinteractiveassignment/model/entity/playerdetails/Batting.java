package com.example.sportsinteractiveassignment.model.entity.playerdetails;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class Batting {

    /* "Batting": {
            "Style": "RHB",
            "Average": 35.17,
            "Strikerate": 81.65,
            "Runs": 7317
          },*/

    @SerializedName("Style")
    @ColumnInfo(name = "Batting_Style")
    public String Batting_Style;

    @SerializedName("Average")
    @ColumnInfo(name = "Batting_Average")
    public double Batting_Average;

    @SerializedName("Strikerate")
    public double Strikerate;

    @SerializedName("Runs")
    public int Runs;
}
