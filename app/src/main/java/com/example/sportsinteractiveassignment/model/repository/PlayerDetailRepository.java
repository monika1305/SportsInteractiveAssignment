package com.example.sportsinteractiveassignment.model.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.sportsinteractiveassignment.model.dao.PlayerDao;
import com.example.sportsinteractiveassignment.model.dao.TeamDao;
import com.example.sportsinteractiveassignment.model.entity.playerdetails.PlayersEntity;
import com.example.sportsinteractiveassignment.model.entity.teamdetails.TeamsEntity;
import com.example.sportsinteractiveassignment.model.room.RoomDB;

import java.util.List;

public class PlayerDetailRepository {
    private PlayerDao playerDao;
        LiveData<List<PlayersEntity>> mAllPosts;

        public PlayerDetailRepository(Application application){
            RoomDB db = RoomDB.getDatabase(application);
            playerDao = db.playerDao();
//            mAllPosts = playerDao.getAllPlayersEntity();
        }

        public LiveData<List<PlayersEntity>> getAllPlayersEntity(String Team_id) {
            mAllPosts = playerDao.getAllPlayersEntity(Team_id);

            return mAllPosts;
        }
        public void insertAllPlayersData (List<PlayersEntity> resultModel) {
            new insertAsyncTask(playerDao).execute(resultModel);
        }

private static class insertAsyncTask extends AsyncTask<List<PlayersEntity>, Void, Void> {

    private PlayerDao mAsyncTaskDao;

    insertAsyncTask(PlayerDao dao) {
        mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(final List<PlayersEntity>... params) {
        if(params!=null) {
            mAsyncTaskDao.insertAllPlayersEntity(params[0]);
        }       return null;
    }
}
}
