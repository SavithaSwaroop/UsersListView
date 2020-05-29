package com.example.userslistview.server;


import com.example.userslistview.model.Photos;
import com.example.userslistview.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import  retrofit2.http.GET;

public interface ApiInterface {


    //Server URL
    String BASE_URL = "https://jsonplaceholder.typicode.com";


    //get data for Users from Server URL
    @GET("/users")
    Call<ArrayList<User>>getUsersJson();


    //get data for Photos from Server URL
    @GET("/photos")
    Call<ArrayList<Photos>>getPhotosJson();

}
