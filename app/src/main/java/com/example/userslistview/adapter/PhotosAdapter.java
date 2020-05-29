package com.example.userslistview.adapter;


import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.*;
import androidx.databinding.DataBindingUtil;

import com.example.userslistview.AlbumActivity;
import com.example.userslistview.ImageActivity;
import com.example.userslistview.R;
import com.example.userslistview.databinding.PhotosBinding;
import com.example.userslistview.databinding.UserBinding;
import com.example.userslistview.model.Photos;
import com.example.userslistview.model.User;
import com.example.userslistview.viewmodel.PhotosViewModel;
import com.example.userslistview.viewmodel.UsersViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.EventListener;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosView> {


    //public static Object onUserListener;
    private ArrayList<PhotosViewModel> arrayList  = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private String  userId;



    public PhotosAdapter(Context context, ArrayList<PhotosViewModel> arraylist,String userId) {
        this.context = context;
        this.userId = userId;

        //create albumList matching to the UserId Clicked
        for  (int i=0;i<arraylist.size();i++){
            Photos photo = arraylist.get(i).photo;
            if (photo.albumId.equalsIgnoreCase(userId))
            {
                PhotosViewModel pModel  = new PhotosViewModel(photo);
                arrayList.add(pModel);
            }
        }
        this.arrayList = arrayList;


    }

    @NonNull
    @Override
    public PhotosView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        PhotosBinding photosBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_photos_layout,parent, false);
        return new PhotosView(photosBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosView holder, int position) {

        PhotosViewModel photosViewModel = arrayList.get(position);
        holder.bind(photosViewModel);


        if(photosViewModel.photo.thumbnailUrl!=null){
            Picasso.get()
                    .load(photosViewModel.photo.thumbnailUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.photoImage);
        } else {
            Picasso.get()
                    .load(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.photoImage);
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    class PhotosView extends RecyclerView.ViewHolder implements View.OnClickListener{

        private PhotosBinding photosBinding;
        private TextView photoTitle;
        private ImageView photoImage;

        public PhotosView(PhotosBinding photosBinding){
            super(photosBinding.getRoot());

            this.photosBinding = photosBinding;

        }

        public void bind(final PhotosViewModel photosViewModel){
            this.photosBinding.setPhotosmodel(photosViewModel);
            photosBinding.executePendingBindings();
            photoImage = photosBinding.imageView;
            photoTitle = photosBinding.textView;
            photosBinding.getRoot().setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){

                    //show  Album screen for the user id selected
                    Intent intent = new Intent(context, ImageActivity.class);
                    intent.putExtra(ImageActivity.EXTRA_ALBUM_ID, photosBinding.getPhotosmodel().photo.albumId);
                    intent.putExtra(ImageActivity.EXTRA_ID, photosBinding.getPhotosmodel().photo.id);
                    intent.putExtra(ImageActivity.EXTRA_ALBUM_URL, photosBinding.getPhotosmodel().photo.url);
                    intent.putExtra(ImageActivity.EXTRA_ALBUM_TITLE, photosBinding.getPhotosmodel().photo.title);

                    context.startActivity(intent);
                }
            });
        }

        public PhotosBinding  getUserBinding()
        {
            return photosBinding;
        }


        @Override
        public void onClick(View view) {

        }
    }


}
