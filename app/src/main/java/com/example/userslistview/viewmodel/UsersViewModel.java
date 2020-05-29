package com.example.userslistview.viewmodel;

import com.example.userslistview.model.User;
import com.example.userslistview.server.LoadData;
import com.example.userslistview.server.UsersRepo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;


public class UsersViewModel  extends ViewModel{

    public User usr;
    public ArrayList<User> usrList;
    public MutableLiveData<ArrayList<UsersViewModel>> listMutableLiveData = new MutableLiveData<>();

    public LoadData loadData = new LoadData();

    private  ArrayList<UsersViewModel> arrayList;
    private UsersRepo usersRepo;




    public UsersViewModel(){
        usersRepo = new UsersRepo();
        listMutableLiveData = usersRepo.getArrayListMutableLiveData();

    }


    public UsersViewModel(User  user){
        usr = new User();
        usr.id = user.id;
        usr.name = user.name;
        usr.email = user.email;
        usr.phone = user.phone;
    }

    //get Users List
    public ArrayList<User> getUsrList(){
        if (this.usrList == null){
            this.usrList = loadData.loadUsers();
        }
        return  this.usrList;
    }

    //get user info for specified user
    public User getUser(User user){
        if (user != null){
            this.usr.setId(user.getId());
            this.usr.setName(user.getName());
            this.usr.setEmail(user.getEmail());
            this.usr.setPhone(user.getPhone());

        }
        return this.usr;
    }

    public MutableLiveData<ArrayList<UsersViewModel>> getListMutableLiveData(){


        return listMutableLiveData;
    }




}
