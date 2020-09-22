package com.example.sportsinteractiveassignment.model.room;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.sportsinteractiveassignment.model.dao.MatchDao;
import com.example.sportsinteractiveassignment.model.dao.PlayerDao;
import com.example.sportsinteractiveassignment.model.dao.TeamDao;
import com.example.sportsinteractiveassignment.model.entity.playerdetails.PlayersEntity;
import com.example.sportsinteractiveassignment.model.entity.teamdetails.TeamsEntity;
import com.example.sportsinteractiveassignment.model.entity.matchdetails.MatchDetailsEntity;

@Database(version = 1,entities = {MatchDetailsEntity.class,TeamsEntity.class, PlayersEntity.class},exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    public abstract MatchDao matchDao();
    public abstract TeamDao teamDao();
    public abstract PlayerDao playerDao();

    private static RoomDB INSTANCE;


    public static RoomDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDB.class, "sports_db")
                            .addCallback(sRoomDatabaseCallback)
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    private static Callback sRoomDatabaseCallback =
            new Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

 static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final MatchDao mDao;
    private final TeamDao daoTeam;
    private final PlayerDao daoPlayer;

    PopulateDbAsync(RoomDB db) {
        mDao = db.matchDao();
            daoTeam = db.teamDao();
        daoPlayer = db.playerDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        Log.d("DB Operations","Deleting MatchDetails ");
        mDao.deleteMatchDetails();
       daoTeam.deleteAll();
        daoPlayer.deleteAll();
        return null;
    }
}
}
