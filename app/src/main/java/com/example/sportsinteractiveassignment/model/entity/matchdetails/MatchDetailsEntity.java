package com.example.sportsinteractiveassignment.model.entity.matchdetails;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "matchDetails_table")
public class MatchDetailsEntity implements Serializable {

    /* "Matchdetail": {
    "Team_Home": 7,
    "Team_Away": 6,
    "Match": {
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
    },
    "Series": {
      "Id": 2988,
      "Name": "Pakistan in South Africa, 5 ODI Series, 2019",
      "Status": "5 ODI series level 1-1",
      "Tour": 895,
      "Tour_Name": "Pakistan tour of South Africa, 2018/19"
    },
    "Venue": {
      "Id": 84,
      "Name": "Kingsmead, Durban"
    },
    "Officials": {
      "Umpires": "Bongani Jele (SA),Paul Reiffel (AUS) and Gregory Brathwaite (WI)",
      "Referee": "Ranjan Madugalle (SL)"
    },
    "Weather": "Clear",
    "Tosswonby": 7,
    "Status": "Match Ended",
    "Status_Id": 114,
    "Player_Match": "Andile Phehlukwayo",
    "Result": "South Africa beat Pakistan by 5 wickets",
    "Winningteam": 7,
    "Winmargin": "5 wickets",
    "Equation": "South Africa beat Pakistan by 5 wickets"
  },*/

    public MatchDetailsEntity() {
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    public int _id;

    @SerializedName("Team_Home")
    public int Team_Home;

    @SerializedName("Team_Away")
    public int Team_Away;

    @SerializedName("Match")
    @Embedded
    public Match match;

    @SerializedName("Series")
    @Embedded
    public Series series;

    @SerializedName("Venue")
    @Embedded
    public Venue venue;

    @SerializedName("Officials")
    @Embedded
    public Officials officials;

    @SerializedName("Weather")
    public String Weather;

    @SerializedName("Tosswonby")
    public int Tosswonby;

    @SerializedName("Status")
    @ColumnInfo(name = "Match_Status")
    public String Status;

    @SerializedName("Status_Id")
    @ColumnInfo(name = "Match_Status_Id")
    public int Status_Id;

    @SerializedName("Player_Match")
    public String Player_Match;

    @SerializedName("Result")
    public String Result;

    @SerializedName("Winningteam")
    public int Winningteam;

    @SerializedName("Winmargin")
    public String Winmargin;

    @SerializedName("Equation")
    public String Equation;

    public <X> MatchDetailsEntity(MatchDetailsEntity data) {
    }

    @Override
    public String toString() {
        return "MatchDetailsEntity{" +
                "_id=" + _id +
                ", Team_Home=" + Team_Home +
                ", Team_Away=" + Team_Away +
                ", match=" + match +
                ", series=" + series +
                ", venue=" + venue +
                ", officials=" + officials +
                ", Weather='" + Weather + '\'' +
                ", Tosswonby=" + Tosswonby +
                ", Status='" + Status + '\'' +
                ", Status_Id=" + Status_Id +
                ", Player_Match='" + Player_Match + '\'' +
                ", Result='" + Result + '\'' +
                ", Winningteam=" + Winningteam +
                ", Winmargin='" + Winmargin + '\'' +
                ", Equation='" + Equation + '\'' +
                '}';
    }
}
