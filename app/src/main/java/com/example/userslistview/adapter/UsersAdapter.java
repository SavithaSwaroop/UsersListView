package com.example.userslistview.adapter;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.*;
import androidx.databinding.DataBindingUtil;

import com.example.userslistview.AlbumActivity;
import com.example.userslistview.R;
import com.example.userslistview.databinding.UserBinding;
import com.example.userslistview.model.User;
import com.example.userslistview.viewmodel.UsersViewModel;

import java.util.ArrayList;
import java.util.EventListener;

import android.content.Context;
import android.content.Intent;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersView> {


    //public static Object onUserListener;
    private ArrayList<UsersViewModel> arrayList ;
    private Context context;
    private LayoutInflater layoutInflater;



    public UsersAdapter(Context context, ArrayList<UsersViewModel> arraylist) {
        this.context = context;
        this.arrayList = arraylist;

    }

    @NonNull
    @Override
    public UsersView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        UserBinding userBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_users_layout,parent, false);
        return new UsersView(userBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersView holder, int position) {

        UsersViewModel usersViewModel = arrayList.get(position);
        holder.bind(usersViewModel);

    }

    @Override
    public int getItemCount() {
            return arrayList.size();
    }


    class UsersView extends RecyclerView.ViewHolder implements View.OnClickListener{

        private UserBinding userBinding;

        public UsersView(UserBinding userBinding){
            super(userBinding.getRoot());

            this.userBinding = userBinding;

        }

        public void bind(final UsersViewModel usersViewModel){
            this.userBinding.setUsersmodel(usersViewModel);
            userBinding.executePendingBindings();
            userBinding.getRoot().setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){

                    //show  Album screen for the user id selected
                    Intent intent = new Intent(context, AlbumActivity.class);
                    intent.putExtra(AlbumActivity.EXTRA_USER_ID, userBinding.userId.getText().toString());
                    context.startActivity(intent);
                }
            });
        }

        public UserBinding  getUserBinding()
        {
            return userBinding;
        }


        @Override
        public void onClick(View view) {

        }
    }


}
