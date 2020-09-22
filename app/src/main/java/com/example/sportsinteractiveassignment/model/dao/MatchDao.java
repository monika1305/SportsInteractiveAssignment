package com.example.sportsinteractiveassignment.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sportsinteractiveassignment.model.entity.matchdetails.MatchDetailsEntity;

import java.util.List;

@Dao
public interface MatchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MatchDetailsEntity matchDetailsEmtities);

    @Update
    void update(MatchDetailsEntity entity);

    @Delete
    void delete(MatchDetailsEntity entity);

    @Query("Delete From matchDetails_table")
    void deleteMatchDetails();

    @Query("Select * from  matchDetails_table")
    LiveData<MatchDetailsEntity> getMatchDetailsEntity();

}
