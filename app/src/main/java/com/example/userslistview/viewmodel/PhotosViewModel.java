package com.example.userslistview.viewmodel;

import com.example.userslistview.model.Photos;
import com.example.userslistview.model.User;
import com.example.userslistview.server.LoadData;
import com.example.userslistview.server.PhotosRepo;
import com.example.userslistview.server.UsersRepo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class PhotosViewModel extends ViewModel {

    public Photos photo = new Photos();
    public MutableLiveData<ArrayList<PhotosViewModel>> plistMutableLiveData = new MutableLiveData<>();


    private PhotosRepo photosRepo;




    public PhotosViewModel(){
        photosRepo = new PhotosRepo();
        plistMutableLiveData = photosRepo.getArrayListMutableLiveData();

    }


    public PhotosViewModel(Photos photo) {

        this.photo.albumId = photo.albumId;
        this.photo.id = photo.id;
        this.photo.title = photo.title;
        this.photo.url = photo.url;
        this.photo.thumbnailUrl = photo.thumbnailUrl;
    }


    public MutableLiveData<ArrayList<PhotosViewModel>> getPhotoListMutableLiveData(){
        return plistMutableLiveData;
    }



}
