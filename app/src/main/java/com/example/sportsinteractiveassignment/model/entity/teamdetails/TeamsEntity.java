package com.example.sportsinteractiveassignment.model.entity.teamdetails;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.io.Serializable;

@Entity(tableName = "team_info")
public class TeamsEntity implements Serializable {
/* "Teams": {
    "6": {
      "Name_Full": "Pakistan",
      "Name_Short": "PAK",
      "Players": {
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
        },
        "3472": {
          "Position": 4,
          "Name_Full": "Mohammad Hafeez",
          "Batting": {
            "Style": "RHB",
            "Average": 32.97,
            "Strikerate": 75.85,
            "Runs": 6233
          },
          "Bowling": {
            "Style": "OB",
            "Average": 37.45,
            "Economyrate": 4.12,
            "Wickets": 137
          }
        },
        "4038": {
          "Position": 6,
          "Name_Full": "Sarfraz Ahmed",
          "Iscaptain": true,
          "Iskeeper": true,
          "Batting": {
            "Style": "RHB",
            "Average": 32.81,
            "Strikerate": 86.04,
            "Runs": 1936
          },
          "Bowling": {
            "Style": "",
            "Average": 0,
            "Economyrate": 7.5,
            "Wickets": 0
          }
        },
        "57492": {
          "Position": 2,
          "Name_Full": "Fakhar Zaman",
          "Batting": {
            "Style": "LHB",
            "Average": 55.25,
            "Strikerate": 96.64,
            "Runs": 1326
          },
          "Bowling": {
            "Style": "SLO",
            "Average": 88,
            "Economyrate": 4.75,
            "Wickets": 1
          }
        },
        "59429": {
          "Position": 3,
          "Name_Full": "Babar Azam",
          "Batting": {
            "Style": "RHB",
            "Average": 50.6,
            "Strikerate": 84.4,
            "Runs": 2328
          },
          "Bowling": {
            "Style": "OB",
            "Average": 0,
            "Economyrate": 0,
            "Wickets": 0
          }
        },
        "63084": {
          "Position": 1,
          "Name_Full": "Imam-ul-Haq",
          "Batting": {
            "Style": "LHB",
            "Average": 60.66,
            "Strikerate": 81.54,
            "Runs": 910
          },
          "Bowling": {
            "Style": "LB",
            "Average": 0,
            "Economyrate": 0,
            "Wickets": 0
          }
        },
        "64073": {
          "Position": 8,
          "Name_Full": "Hussain Talat",
          "Batting": {
            "Style": "LHB",
            "Average": 2,
            "Strikerate": 14.28,
            "Runs": 2
          },
          "Bowling": {
            "Style": "/RMF",
            "Average": 0,
            "Economyrate": 8,
            "Wickets": 0
          }
        },
        "64306": {
          "Position": 10,
          "Name_Full": "Hasan Ali",
          "Batting": {
            "Style": "RHB",
            "Average": 13.46,
            "Strikerate": 104.12,
            "Runs": 202
          },
          "Bowling": {
            "Style": "RMF",
            "Average": 24.06,
            "Economyrate": 5.25,
            "Wickets": 76
          }
        },
        "64321": {
          "Position": 9,
          "Name_Full": "Faheem Ashraf",
          "Batting": {
            "Style": "LHB",
            "Average": 11.55,
            "Strikerate": 74.28,
            "Runs": 104
          },
          "Bowling": {
            "Style": "RMF",
            "Average": 28.05,
            "Economyrate": 4.48,
            "Wickets": 18
          }
        },
        "65739": {
          "Position": 7,
          "Name_Full": "Shadab Khan",
          "Batting": {
            "Style": "RHB",
            "Average": 30.55,
            "Strikerate": 67.07,
            "Runs": 275
          },
          "Bowling": {
            "Style": "LB",
            "Average": 25.28,
            "Economyrate": 4.62,
            "Wickets": 45
          }
        },
        "66833": {
          "Position": 11,
          "Name_Full": "Shaheen Afridi",
          "Batting": {
            "Style": "LHB",
            "Average": 15,
            "Strikerate": 65.21,
            "Runs": 15
          },
          "Bowling": {
            "Style": "LM",
            "Average": 17.06,
            "Economyrate": 4.88,
            "Wickets": 16
          }
        }
      }
    },*/
    public TeamsEntity() {
    }

    @SerializedName("Name_Full")
    public String Name_Full;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public String id;

    @SerializedName("Name_Short")
    public String Name_Short;

}
