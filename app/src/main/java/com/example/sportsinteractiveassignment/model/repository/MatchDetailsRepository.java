package com.example.sportsinteractiveassignment.model.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.sportsinteractiveassignment.model.dao.MatchDao;
import com.example.sportsinteractiveassignment.model.entity.matchdetails.MatchDetailsEntity;
import com.example.sportsinteractiveassignment.model.room.RoomDB;

public class MatchDetailsRepository {

    private MatchDao matchDao;
    LiveData<MatchDetailsEntity> liveDataMatchDetailsEntity;

    public MatchDetailsRepository(Application application){
        RoomDB db = RoomDB.getDatabase(application);
        matchDao = db.matchDao();
        liveDataMatchDetailsEntity = matchDao.getMatchDetailsEntity();
    }

    public LiveData<MatchDetailsEntity> getMatchDetailsRepositoryLiveData() {
        liveDataMatchDetailsEntity = matchDao.getMatchDetailsEntity();
        return liveDataMatchDetailsEntity;
    }
    public void insertPosts (MatchDetailsEntity resultModel) {
        new insertAsyncTask(matchDao).execute(resultModel);
    }

    private static class insertAsyncTask extends AsyncTask<MatchDetailsEntity, Void, Void> {

        private MatchDao mAsyncTaskDao;

        insertAsyncTask(MatchDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final MatchDetailsEntity... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
