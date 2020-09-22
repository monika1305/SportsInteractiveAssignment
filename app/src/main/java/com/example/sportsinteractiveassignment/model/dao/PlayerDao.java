package com.example.sportsinteractiveassignment.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sportsinteractiveassignment.model.entity.playerdetails.PlayersEntity;
import com.example.sportsinteractiveassignment.model.entity.teamdetails.TeamsEntity;

import java.util.List;


@Dao
public interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PlayersEntity playersEntity);

    @Update
    void update(PlayersEntity entity);

    @Delete
    void delete(PlayersEntity entity);

    @Query("SELECT * from player_info where Team_id = :Team_id")
    LiveData<List<PlayersEntity>> getAllPlayersEntity(String Team_id);

    @Query("DELETE FROM player_info")
    void deleteAll();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllPlayersEntity(List<PlayersEntity> playersEntities);

}
