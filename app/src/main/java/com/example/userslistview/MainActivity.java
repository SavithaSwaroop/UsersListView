package com.example.userslistview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.userslistview.adapter.UsersAdapter;
import com.example.userslistview.viewmodel.UsersViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private UsersViewModel usersViewModel;
    private RecyclerView recyclerView;
    private UsersAdapter  usersAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.userlist_recycler_view);
        usersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);

        usersViewModel.getListMutableLiveData().observe(this, new Observer<ArrayList<UsersViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<UsersViewModel> usersViewModels) {
                usersAdapter  =    new UsersAdapter(MainActivity.this,usersViewModels);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(usersAdapter);

            }
        });
    }



}
