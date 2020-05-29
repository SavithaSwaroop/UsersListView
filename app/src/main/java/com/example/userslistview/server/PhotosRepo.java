package com.example.userslistview.server;

import androidx.lifecycle.MutableLiveData;

import com.example.userslistview.model.Photos;
import com.example.userslistview.model.User;
import com.example.userslistview.viewmodel.PhotosViewModel;
import com.example.userslistview.viewmodel.UsersViewModel;



import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosRepo {


    public MutableLiveData<ArrayList<PhotosViewModel>>  arrayPhotoListMutableLiveData = new MutableLiveData<>();
    private ArrayList<PhotosViewModel>  arrayList = new ArrayList<>();
    private ArrayList<Photos> items;



    public PhotosRepo(){

    }

    public MutableLiveData<ArrayList<PhotosViewModel>> getArrayListMutableLiveData() {

        ApiInterface apiInterface  = LoadData.getApiInterface();

        Call<ArrayList<Photos>> call = apiInterface.getPhotosJson();

        call.enqueue(new Callback<ArrayList<Photos>>()
        {
            @Override
            public void onResponse (Call<ArrayList<Photos>> call, Response<ArrayList<Photos>> response){

                //copy response data
                items = response.body();

                Photos photos;
                PhotosViewModel photosViewModel;

                for (int i=0;i<items.size();i++){
                    photos =  new  Photos(items.get(i).albumId,items.get(i).id, items.get(i).title,items.get(i).url,items.get(i).thumbnailUrl);

                    photosViewModel =  new PhotosViewModel(photos);
                    arrayList.add(photosViewModel);
                }
                arrayPhotoListMutableLiveData.setValue(arrayList);

            }

            @Override
            public void onFailure (Call  <ArrayList<Photos>> call, Throwable t){

                //show alert box

            }
        });

        return arrayPhotoListMutableLiveData;
    }
}
