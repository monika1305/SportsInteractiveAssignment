package com.example.sportsinteractiveassignment.model.entity.playerdetails;

import androidx.room.Embedded;

import com.google.gson.annotations.SerializedName;

public class Players {
    /* "Players": {
        "2734": {
          "Position": 5,
          "Name_Full": "Shoaib Malik",
          "Batting": {
            "Style": "RHB",
            "Average": 35.17,
            "Strikerate": 81.65,
            "Runs": 7317
          },
          "Bowling": {
            "Style": "OB",
            "Average": 39.11,
            "Economyrate": 4.65,
            "Wickets": 156
          }
        },*/


    @SerializedName("Position")
    public int Position;

    @SerializedName("Name_Full")
    public String Name_Full;

    @SerializedName("Batting")
    @Embedded
    public Batting batting;

    @SerializedName("Bowling")
    @Embedded
    public Bowling bowling;

    @Override
    public String toString() {
        return "Players{" +
                "Position=" + Position +
                ", Name_Full='" + Name_Full + '\'' +
                ", batting=" + batting +
                ", bowling=" + bowling +
                '}';
    }
}
