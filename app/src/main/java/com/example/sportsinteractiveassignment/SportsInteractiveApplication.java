package com.example.sportsinteractiveassignment;

import android.app.Application;

import androidx.room.Room;

import com.example.sportsinteractiveassignment.model.room.RoomDB;

public class SportsInteractiveApplication  extends Application {
    public  static RoomDB roomDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        roomDatabase= Room.databaseBuilder(getApplicationContext(), RoomDB.class,"sports_db").fallbackToDestructiveMigration().build();

    }
}