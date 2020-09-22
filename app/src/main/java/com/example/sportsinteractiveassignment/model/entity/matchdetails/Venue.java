package com.example.sportsinteractiveassignment.model.entity.matchdetails;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class Venue {
        /*   "Venue": {
      "Id": 84,
      "Name": "Kingsmead, Durban"
    },*/

    @SerializedName("Id")
    @ColumnInfo(name = "Venue_Id")
    public int Venue_Id;

    @SerializedName("Name")
    @ColumnInfo(name = "Venue_Name")
    public String Venue_Name;

    @Override
    public String toString() {
        return "Venue{" +
                "Venue_Id=" + Venue_Id +
                ", Name='" + Venue_Name + '\'' +
                '}';
    }
}
