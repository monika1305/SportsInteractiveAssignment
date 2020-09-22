package com.example.sportsinteractiveassignment.model.entity.matchdetails;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class Series {
        /*   "Series": {
      "Id": 2988,
      "Name": "Pakistan in South Africa, 5 ODI Series, 2019",
      "Status": "5 ODI series level 1-1",
      "Tour": 895,
      "Tour_Name": "Pakistan tour of South Africa, 2018/19"
    },*/

    @SerializedName("Id")
    @ColumnInfo(name = "Series_Id")
    public int Series_Id;

    @SerializedName("Name")
    @ColumnInfo(name = "Series_Name")
    public String Series_Name;

    @SerializedName("Status")
    public String Status;

    @SerializedName("Tour")
    public int Tour;

    @SerializedName("Tour_Name")
    public String Tour_Name;

    @Override
    public String toString() {
        return "Series{" +
                "Series_Id=" + Series_Id +
                ", Name='" + Series_Name + '\'' +
                ", Status='" + Status + '\'' +
                ", Tour=" + Tour +
                ", Tour_Name='" + Tour_Name + '\'' +
                '}';
    }
}
