package com.example.sportsinteractiveassignment.model.entity.matchdetails;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class Match {
        /* "Match": {
      "Livecoverage": "yes",
      "Id": 186652,
      "Code": "sapk01222019186652",
      "League": "icc",
      "Number": "2nd ODI",
      "Type": "ODI",
      "Date": "1/22/2019",
      "Time": "13:00",
      "Offset": "+02:00",
      "Daynight": "yes"
    },*/

    @SerializedName("Livecoverage")
    public String Livecoverage;

    @SerializedName("Id")
    @ColumnInfo(name = "Match_Id")
    public int Match_Id;

    @SerializedName("Code")
    public String Code;

    @SerializedName("League")
    public String League;

    @SerializedName("Number")
    public String Number;

    @SerializedName("Type")
    public String Type;

    @SerializedName("Date")
    public String Date;

    @SerializedName("Time")
    public String Time;

    @SerializedName("Offset")
    public String Offset;

    @SerializedName("Daynight")
    public String Daynight;

    @Override
    public String toString() {
        return "Match{" +
                "Livecoverage='" + Livecoverage + '\'' +
                ", Match_Id=" + Match_Id +
                ", Code='" + Code + '\'' +
                ", League='" + League + '\'' +
                ", Number='" + Number + '\'' +
                ", Type='" + Type + '\'' +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                ", Offset='" + Offset + '\'' +
                ", Daynight='" + Daynight + '\'' +
                '}';
    }
}
