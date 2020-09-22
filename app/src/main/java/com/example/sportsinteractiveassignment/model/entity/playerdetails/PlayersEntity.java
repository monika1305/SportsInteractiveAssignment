package com.example.sportsinteractiveassignment.model.entity.playerdetails;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "player_info")
public class PlayersEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public String id;

    @ColumnInfo(name = "Team_id")
    public String Team_id;

    @SerializedName("Players")
    @Embedded
    public Players players;

    @Override
    public String toString() {
        return "PlayersEntity{" +
                "id='" + id + '\'' +
                ", Team_id='" + Team_id + '\'' +
                ", players=" + players +
                '}';
    }
}
