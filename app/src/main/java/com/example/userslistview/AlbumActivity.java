package com.example.userslistview;

import android.os.Bundle;

import com.example.userslistview.adapter.PhotosAdapter;
import com.example.userslistview.adapter.UsersAdapter;
import com.example.userslistview.model.User;
import com.example.userslistview.viewmodel.PhotosViewModel;
import com.example.userslistview.viewmodel.UsersViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    public static final String EXTRA_USER_ID = "ID";


    private PhotosViewModel photosViewModel;
    private RecyclerView recyclerView;
    private PhotosAdapter photosAdapter;

    private TextView albumIdValue;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);


        albumIdValue = (TextView) findViewById(R.id.albumId);
        recyclerView = (RecyclerView) findViewById(R.id.album_recycler_view);

        //set value for albumId
        final String Id = getIntent().getStringExtra(EXTRA_USER_ID);
        albumIdValue.setText(Id);


        photosViewModel = ViewModelProviders.of(this).get(PhotosViewModel.class);

        photosViewModel.getPhotoListMutableLiveData().observe(this, new Observer<ArrayList<PhotosViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<PhotosViewModel> photosViewModels) {
                photosAdapter  =    new PhotosAdapter(AlbumActivity.this,photosViewModels,Id);
                recyclerView.setLayoutManager(new LinearLayoutManager(AlbumActivity.this));
                recyclerView.setAdapter(photosAdapter);

            }
        });
    }


}
