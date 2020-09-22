package com.example.sportsinteractiveassignment.model.entity.matchdetails;

import com.google.gson.annotations.SerializedName;

public class Officials {
        /*
    "Officials": {
      "Umpires": "Bongani Jele (SA),Paul Reiffel (AUS) and Gregory Brathwaite (WI)",
      "Referee": "Ranjan Madugalle (SL)"
    },*/


    @SerializedName("Umpires")
    public String Umpires;

    @SerializedName("Referee")
    public String Referee;

    @Override
    public String toString() {
        return "Officials{" +
                "Umpires='" + Umpires + '\'' +
                ", Referee='" + Referee + '\'' +
                '}';
    }
}
