package com.example.sportsinteractiveassignment.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sportsinteractiveassignment.model.entity.teamdetails.TeamsEntity;

import java.util.List;


@Dao
public interface  TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TeamsEntity teamsEntitys);

    @Update
    void update(TeamsEntity entity);

    @Delete
    void delete(TeamsEntity entity);

    @Query("SELECT * from team_info ")
    LiveData<List<TeamsEntity>> getAllTeamsEntity();

    @Query("DELETE FROM team_info")
    void deleteAll();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllTeamsEntity(List<TeamsEntity> teamsEntities);

}
