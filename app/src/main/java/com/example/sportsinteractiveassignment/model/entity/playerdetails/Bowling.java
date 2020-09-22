package com.example.sportsinteractiveassignment.model.entity.playerdetails;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class Bowling {

    /* "Bowling": {
            "Style": "OB",
            "Average": 39.11,
            "Economyrate": 4.65,
            "Wickets": 156
          }
          */


    @SerializedName("Style")
    @ColumnInfo(name = "Bowling_Style")
    public String Bowling_Style;

    @SerializedName("Average")
    @ColumnInfo(name = "Bowling_Average")
    public double Bowling_Average;

    @SerializedName("Economyrate")
    public double Economyrate;

    @SerializedName("Wickets")
    public int Wickets;
}
