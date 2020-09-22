package com.example.sportsinteractiveassignment.apiInterface;

import com.example.sportsinteractiveassignment.model.entity.MatchInformationEntity;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestAPIinterface {
    @GET(value = "/sifeeds/cricket/live/json/sapk01222019186652.json")
    public Call<MatchInformationEntity> getMatchInformation();
}
