package com.example.sportsinteractiveassignment.model.entity;

import android.util.Log;

import com.example.sportsinteractiveassignment.model.entity.matchdetails.MatchDetailsEntity;
import com.example.sportsinteractiveassignment.model.entity.playerdetails.Players;
import com.example.sportsinteractiveassignment.model.entity.playerdetails.PlayersEntity;
import com.example.sportsinteractiveassignment.model.entity.teamdetails.TeamsEntity;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MatchInformationEntity  implements Serializable {

 private class MatchInformationInstanceCreator implements InstanceCreator<MatchInformationEntity> {
  public MatchInformationEntity createInstance(Type type) {
   return new MatchInformationEntity();
  }
 }
/*
{"Matchdetail":{},
  "Nuggets":[],
    "Innings":[],
      "Teams":[],
        "Notes":{}
}*/


 @SerializedName("Matchdetail")
 public MatchDetailsEntity matchDetailsEmtity;

 @SerializedName("Nuggets")
 public String[] nuggets;

 @SerializedName("Innings")
 public List<InningsEntity> inningsEntityList;


 @SerializedName("Teams")
 public JsonObject jsonObjectteamsEntity;

 @SerializedName("Notes")
 public NotesEntity notesEntities;

 public  List<TeamsEntity> getTeamsEntity(){
  List<TeamsEntity> teamsEntities =new ArrayList<>();
  try
  {
//   Log.e("EMP_REPO","getTeamsEntity jsonObjectteamsEntity "+jsonObjectteamsEntity.toString());
   JSONObject jObject= new JSONObject(String.valueOf(jsonObjectteamsEntity));
//   Log.e("EMP_REPO","getTeamsEntity jObject.length() "+jObject.length());

   Iterator<String> keys = jObject.keys();
//   Log.e("EMP_REPO","getTeamsEntity keys next  "+keys.next());
//   Log.e("EMP_REPO","getTeamsEntity keys hasNext "+keys.hasNext());

   while( keys.hasNext() )
   {
    TeamsEntity teamsEntity=new TeamsEntity();
    String key = keys.next();
//   Log.e("EMP_REPO","getTeamsEntity key "+key);
    String value = jObject.getString(key);
//     Log.e("EMP_REPO","getTeamsEntity key = "+key+ " value = "+value);
    teamsEntity.id=key;
     JSONObject object=new JSONObject(value);
//    Log.e("EMP_REPO","key = "+key+ " object = "+object);
//    Log.e("EMP_REPO","getTeamsEntity Name_Full = "+object.getString("Name_Full"));
//    Log.e("EMP_REPO","getTeamsEntity Name_Short = "+object.getString("Name_Short"));
    teamsEntity.Name_Full=object.getString("Name_Full");
    teamsEntity.Name_Short=object.getString("Name_Short");
   teamsEntities.add(teamsEntity);
    JSONObject objectPlayers=new JSONObject(object.getString("Players"));
//    Log.e("EMP_REPO","getTeamsEntity objectPlayers.length() "+objectPlayers.length());

    Iterator<String> keysPlayers = objectPlayers.keys();

    while( keysPlayers.hasNext() ) {
     String keyPly = keysPlayers.next();
//   Log.e("EMP_REPO","getTeamsEntity keyPly "+keyPly);
     String valuePly = objectPlayers.getString(keyPly);
//     Log.e("EMP_REPO","key = "+keyPly+ " value = "+valuePly);
    }
    }
  }
  catch (JSONException e)
  {   e.printStackTrace();    }
  return teamsEntities;
 }

 public  List<PlayersEntity> getPlayerEntity(){
  List<PlayersEntity> playersArrayList =new ArrayList<>();
  try {
   JSONObject jObject = new JSONObject(String.valueOf(jsonObjectteamsEntity));

   Iterator<String> keys = jObject.keys();
//   Log.e("EMP_REPO","getTeamsEntity keys next  "+keys.next());
//   Log.e("EMP_REPO","getTeamsEntity keys hasNext "+keys.hasNext());

   while (keys.hasNext()) {
    String key = keys.next();
//   Log.e("EMP_REPO","getTeamsEntity key "+key);
    String value = jObject.getString(key);
//     Log.e("EMP_REPO","getPlayerEntity key = "+key+ " value = "+value);
    JSONObject object = new JSONObject(value);
//    Log.e("EMP_REPO","key = "+key+ " object = "+object);
//    Log.e("EMP_REPO","getTeamsEntity Name_Full = "+object.getString("Name_Full"));
//    Log.e("EMP_REPO","getTeamsEntity Name_Short = "+object.getString("Name_Short"));

    JSONObject objectPlayers = new JSONObject(object.getString("Players"));
//    Log.e("EMP_REPO","getPlayerEntity objectPlayers.length() "+objectPlayers.length());

    Iterator<String> keysPlayers = objectPlayers.keys();

    while (keysPlayers.hasNext()) {
     String keyPly = keysPlayers.next();
     PlayersEntity playersEntity = new PlayersEntity();
     playersEntity.Team_id = key;
     playersEntity.id = keyPly;
//     Log.e("EMP_REPO","getPlayerEntity keyPly "+keyPly);

     String valuePly = objectPlayers.getString(keyPly);
//     Log.e("EMP_REPO","getPlayerEntity inside key = "+keyPly+ " value = "+valuePly);


     JSONObject playerObectJson = new JSONObject(valuePly);
     Players players=new Players();
     Log.e("EMP_REPO", "getPlayerEntity inside part key = " + key + " playerObectJson = " + playerObectJson);
     Log.e("EMP_REPO", "getPlayerEntity Position = " + playerObectJson.getString("Position"));
     players.Position= Integer.parseInt(playerObectJson.getString("Position"));

     Log.e("EMP_REPO", "getPlayerEntity Name_Full = " + playerObectJson.getString("Name_Full"));
     players.Name_Full=playerObectJson.getString("Name_Full");

     playersEntity.players=players;
     Log.e("EMP_REPO", "getPlayerEntity Batting = " + playerObectJson.getJSONObject("Batting"));

     Log.e("EMP_REPO", "getPlayerEntity Bowling = " + playerObectJson.getString("Bowling"));
    playersArrayList.add(playersEntity);
    }
   }
  }
  catch (JSONException e)
  {   e.printStackTrace();    }
  return playersArrayList;
 }

}
