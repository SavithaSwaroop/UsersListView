package com.example.userslistview.server;

import androidx.lifecycle.MutableLiveData;

import com.example.userslistview.model.User;
import com.example.userslistview.viewmodel.UsersViewModel;



import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersRepo {


    public MutableLiveData<ArrayList<UsersViewModel>>  arrayListMutableLiveData = new MutableLiveData<>();
    private ArrayList<UsersViewModel>  arrayList = new ArrayList<>();
    private ArrayList<User> items;



    public UsersRepo(){

    }

    public MutableLiveData<ArrayList<UsersViewModel>> getArrayListMutableLiveData() {

        ApiInterface apiInterface  = LoadData.getApiInterface();

        Call<ArrayList<User>> call = apiInterface.getUsersJson();

        call.enqueue(new Callback<ArrayList<User>>()
        {
            @Override
            public void onResponse (Call<ArrayList<User>> call, Response<ArrayList<User>> response){

                //copy response data
                items = response.body();

                User user;
                UsersViewModel usersViewModel;

                for (int i=0;i<items.size();i++){
                    user =  new  User(items.get(i).id,items.get(i).name, items.get(i).phone,items.get(i).email);

                    usersViewModel =  new UsersViewModel(user);
                    arrayList.add(usersViewModel);
                }
                arrayListMutableLiveData.setValue(arrayList);

            }

            @Override
            public void onFailure (Call  <ArrayList<User>> call, Throwable t){

                //show alert box

            }
        });

        return arrayListMutableLiveData;
    }
}
