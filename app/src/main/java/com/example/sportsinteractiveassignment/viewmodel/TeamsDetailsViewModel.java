package com.example.sportsinteractiveassignment.viewmodel;

import android.app.Application;

import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.sportsinteractiveassignment.model.entity.playerdetails.PlayersEntity;
import com.example.sportsinteractiveassignment.model.entity.teamdetails.TeamsEntity;
import com.example.sportsinteractiveassignment.model.entity.matchdetails.MatchDetailsEntity;
import com.example.sportsinteractiveassignment.model.repository.PlayerDetailRepository;
import com.example.sportsinteractiveassignment.model.repository.TeamDetailRepository;
import com.example.sportsinteractiveassignment.model.repository.WebServiceRepository;

import java.util.List;

public class TeamsDetailsViewModel extends AndroidViewModel {

    private TeamDetailRepository teamDetailRepository;
    private PlayerDetailRepository playerDetailRepository;
    WebServiceRepository webServiceRepository ;

    private LiveData<List<TeamsEntity>> listLiveDataTeamsDetailEntity;
    private LiveData<List<PlayersEntity>> listLiveDataPlayersEntity;
    private LiveData<MatchDetailsEntity>  retroObservable;

    public TeamsDetailsViewModel(Application application){
        super(application);
        teamDetailRepository = new TeamDetailRepository(application);
        webServiceRepository = new WebServiceRepository(application);
        playerDetailRepository = new PlayerDetailRepository(application);

        listLiveDataTeamsDetailEntity = teamDetailRepository.getAllTeamsDetails();

        if(listLiveDataTeamsDetailEntity==null && listLiveDataTeamsDetailEntity.getValue()==null)
        retroObservable = webServiceRepository.providesWebService();

    }

    public LiveData<List<TeamsEntity>> getListOfTeamsLiveData() {
        listLiveDataTeamsDetailEntity = teamDetailRepository.getAllTeamsDetails();
        return listLiveDataTeamsDetailEntity;
    }


    public LiveData<List<PlayersEntity>> getPlayersLiveData(String Team_id) {
        listLiveDataPlayersEntity = playerDetailRepository.getAllPlayersEntity(Team_id);
        return listLiveDataPlayersEntity;
    }


    public LiveData<MatchDetailsEntity> getWebApiCall() {
        retroObservable = webServiceRepository.providesWebService();
        return retroObservable;
    }

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Hello world from section: " + input;
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }
}
