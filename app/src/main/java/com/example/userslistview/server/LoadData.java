package com.example.userslistview.server;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import com.example.userslistview.model.Photos;
import com.example.userslistview.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
//import java.util.List;

import android.widget.Toast;


//This module uses Retrofit to retrieve JSON data from URL
public class LoadData {
    //Server URL
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    private static Retrofit getRetroInstance(){
        Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();

    }

    //instantiating ApiInterface to Retrofit
    public static ApiInterface getApiInterface() {

       return  getRetroInstance().create(ApiInterface.class);
    }



    //load User JSON data from URL
    public ArrayList<User> loadUsers(){

        final ArrayList<User> usersList = new ArrayList<User>();
        Call<ArrayList<User>> call =getApiInterface().getUsersJson();

        call.enqueue(new Callback<ArrayList<User>>()
        {
            @Override
            public void onResponse (Call<ArrayList<User>> call, Response<ArrayList<User>> response){

                //copy response data
                for (User usr : response.body()) {
                    usersList.add(usr);
                }

            }

            @Override
            public void onFailure (Call  <ArrayList<User>> call, Throwable t){

                //show alert box

            }
        });

        return usersList;
    }


    //load User JSON data from URL
    public ArrayList<Photos> loadPhotos(){

        final ArrayList<Photos> photosList = new ArrayList<Photos>();
        Call<ArrayList<Photos>> call =getApiInterface().getPhotosJson();

        call.enqueue(new Callback<ArrayList<Photos>>()
        {
            @Override
            public void onResponse (Call<ArrayList<Photos>> call, Response<ArrayList<Photos>> response){

                //copy response data
                for (Photos phto : response.body()) {
                    photosList.add(phto);
                }

            }

            @Override
            public void onFailure (Call  <ArrayList<Photos>> call, Throwable t){

                //show alert box

            }
        });

        return photosList;
    }

}











