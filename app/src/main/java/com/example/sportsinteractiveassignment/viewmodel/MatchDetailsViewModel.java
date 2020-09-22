package com.example.sportsinteractiveassignment.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.example.sportsinteractiveassignment.model.entity.matchdetails.MatchDetailsEntity;
import com.example.sportsinteractiveassignment.model.repository.MatchDetailsRepository;
import com.example.sportsinteractiveassignment.model.repository.WebServiceRepository;

public class MatchDetailsViewModel extends AndroidViewModel {

   private MatchDetailsRepository postRoomDBRepository;
    private LiveData<MatchDetailsEntity> liveDataMatchDetailsEntity;
    WebServiceRepository webServiceRepository ;
    private LiveData<MatchDetailsEntity>  retroObservable;

    public MatchDetailsViewModel(Application application){
        super(application);
        postRoomDBRepository = new MatchDetailsRepository(application);
        webServiceRepository = new WebServiceRepository(application);
        retroObservable = webServiceRepository.providesWebService();

    }

    public LiveData<MatchDetailsEntity> getMatchDetailsLiveData() {
        liveDataMatchDetailsEntity = postRoomDBRepository.getMatchDetailsRepositoryLiveData();
        return liveDataMatchDetailsEntity;
    }


    public LiveData<MatchDetailsEntity> getWebApiCall() {
        retroObservable = webServiceRepository.providesWebService();
    return retroObservable;
    }


}
