/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.photo.model;

/**
 *
 * @author asus
 */
public class ImageModel {
    private int id;
    private int gallery_id;
    private String url;

    public ImageModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGallery_id() {
        return gallery_id;
    }

    public void setGallery_id(int gallery_id) {
        this.gallery_id = gallery_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
