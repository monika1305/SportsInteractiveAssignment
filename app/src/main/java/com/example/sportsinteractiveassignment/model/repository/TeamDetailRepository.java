package com.example.sportsinteractiveassignment.model.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.sportsinteractiveassignment.model.dao.TeamDao;
import com.example.sportsinteractiveassignment.model.entity.teamdetails.TeamsEntity;
import com.example.sportsinteractiveassignment.model.room.RoomDB;

import java.util.List;

public class TeamDetailRepository{
    private TeamDao teamDao;
        LiveData<List<TeamsEntity>> mAllPosts;

        public TeamDetailRepository(Application application){
            RoomDB db = RoomDB.getDatabase(application);
            teamDao = db.teamDao();
//            mAllPosts = teamDao.getAllTeamsEntity();
        }

        public LiveData<List<TeamsEntity>> getAllTeamsDetails() {
            mAllPosts = teamDao.getAllTeamsEntity();

            return mAllPosts;
        }
        public void insertAllTeamsData (List<TeamsEntity> resultModel) {
            new insertAsyncTask(teamDao).execute(resultModel);
        }

private static class insertAsyncTask extends AsyncTask<List<TeamsEntity>, Void, Void> {

    private TeamDao mAsyncTaskDao;

    insertAsyncTask(TeamDao dao) {
        mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(final List<TeamsEntity>... params) {
        if(params!=null) {
            mAsyncTaskDao.insertAllTeamsEntity(params[0]);
        }       return null;
    }
}
}
