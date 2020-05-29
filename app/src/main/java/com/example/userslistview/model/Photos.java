package com.example.userslistview.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;


//Photos Data Model
public class Photos {

    @SerializedName("albumId")
    @Expose
    public String albumId;

    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("url")
    @Expose
    public String url;

    @SerializedName("thumbnailUrl")
    @Expose
    public String thumbnailUrl;

    public Photos() {
    }

    public Photos(String albumId, String id, String title, String url, String thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
