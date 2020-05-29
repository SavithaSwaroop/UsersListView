package com.example.userslistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.userslistview.model.Photos;
import com.example.userslistview.util.imageExtractor;
import com.squareup.picasso.Picasso;

import android.net.Uri;

public class ImageActivity extends AppCompatActivity {

    public static final String EXTRA_ALBUM_ID = "albumId";
    public static final String EXTRA_ID = "id";
    public static final String EXTRA_ALBUM_URL = "url";
    public static final String EXTRA_ALBUM_TITLE = "title";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        String albumID = getIntent().getStringExtra(EXTRA_ALBUM_ID);
        String iD = getIntent().getStringExtra(EXTRA_ID);
        String imageUrl = getIntent().getStringExtra(EXTRA_ALBUM_URL);
        String albumTitle = getIntent().getStringExtra(EXTRA_ALBUM_TITLE);


      //  mAdvert = AdvertDb.getInstance(this).getAdvertisement(ahmsID);
       // assert mAdvert != null: String.format("Advertisement not found (ahmsID = %s)", ahmsID);



        // Views
        TextView albumIdv = (TextView)findViewById(R.id.albumId);
        albumIdv.setText(albumID);

        TextView userIdv = (TextView)findViewById(R.id.albumPhotoId);
        userIdv.setText(iD);

        ImageView pictureView = (ImageView)findViewById(R.id.albumImage);

        //extract image  from url
        if(imageUrl!=null){
            Picasso.get()
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(pictureView);
        } else {
            Picasso.get()
                    .load(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(pictureView);
        }


       // pictureView.setImageURI(uri);
       // imageExtractor.setImageByURL(pictureView, imageUrl);   //extract image from URL

        TextView albumTitlev = (TextView)findViewById(R.id.albumTitle);
        albumTitlev.setText(albumTitle);


    }
}
