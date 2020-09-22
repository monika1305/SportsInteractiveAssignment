package com.example.sportsinteractiveassignment.model.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sportsinteractiveassignment.apiInterface.RestAPIinterface;
import com.example.sportsinteractiveassignment.model.entity.playerdetails.PlayersEntity;
import com.example.sportsinteractiveassignment.model.entity.teamdetails.TeamsEntity;
import com.example.sportsinteractiveassignment.model.entity.matchdetails.MatchDetailsEntity;
import com.example.sportsinteractiveassignment.model.entity.MatchInformationEntity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServiceRepository {

    public Gson gson;
    Retrofit retrofit;
    public  static String BASE_URL="https://cricket.yahoo.net";
    MatchDetailsEntity matchDetailsEntity = new MatchDetailsEntity();
    List<TeamsEntity> teamsEntityList = new ArrayList<>();
    List<PlayersEntity> playersEntities = new ArrayList<>();


    Application application;

    public  WebServiceRepository(Application application){
        this.application = application;
    }

    private static OkHttpClient providesOkHttpClientBuilder(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return httpClient.readTimeout(1200, TimeUnit.SECONDS)
                .connectTimeout(1200, TimeUnit.SECONDS).build();

    }
    MutableLiveData<MatchDetailsEntity> listMatchMutableLiveData;
    MutableLiveData<List<TeamsEntity>> listTeamMutableLiveData;
    MutableLiveData<List<PlayersEntity>> listPlayerMutableLiveData;


    public LiveData<MatchDetailsEntity>  providesWebService() {

        listMatchMutableLiveData = new MutableLiveData<>();
        listTeamMutableLiveData = new MutableLiveData<>();
        listPlayerMutableLiveData = new MutableLiveData<>();

        String response = "";
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            //Defining retrofit api service
            RestAPIinterface apIinterface=retrofit.create(RestAPIinterface.class);
            //  response = service.makeRequest().execute().body();
            apIinterface.getMatchInformation().enqueue(new Callback<MatchInformationEntity>() {
                @Override
                public void onResponse(Call<MatchInformationEntity> call, Response<MatchInformationEntity> response) {
//                    Log.d("Repository","Response::::"+response.body());
//                    Log.d("Repository","getPlayerEntity esponse::::"+response.body().getPlayerEntity());
                    populateDataToDB(response);


                }

                @Override
                public void onFailure(Call<MatchInformationEntity> call, Throwable t) {
                    Log.d("Repository","Failed:::");
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

        //  return retrofit.create(ResultModel.class);
        return  listMatchMutableLiveData;

    }

    private void populateDataToDB(Response<MatchInformationEntity> response) {
        matchDetailsEntity = response.body().matchDetailsEmtity;
        teamsEntityList = response.body().getTeamsEntity();
        playersEntities = response.body().getPlayerEntity();


        MatchDetailsRepository postRoomDBRepository = new MatchDetailsRepository(application);
        postRoomDBRepository.insertPosts(matchDetailsEntity);
        listMatchMutableLiveData.setValue(matchDetailsEntity);

        TeamDetailRepository teamDetailRepository = new TeamDetailRepository(application);
        teamDetailRepository.insertAllTeamsData(teamsEntityList);
        listTeamMutableLiveData.setValue(teamsEntityList);

        PlayerDetailRepository playerDetailRepository = new PlayerDetailRepository(application);
        playerDetailRepository.insertAllPlayersData(playersEntities);
        listPlayerMutableLiveData.setValue(playersEntities);


    }

}
