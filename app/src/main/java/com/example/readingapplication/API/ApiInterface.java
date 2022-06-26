package com.example.readingapplication.API;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("stories?offset=0&limit=30&fields=stories(id,title,cover,user)")
    Call<Wattpad> getStory();
}
