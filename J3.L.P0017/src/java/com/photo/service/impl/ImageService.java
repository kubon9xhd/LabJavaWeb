/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.photo.service.impl;

import com.photo.dao.IImageDAO;
import com.photo.dao.impl.ImageDAO;
import com.photo.model.ImageModel;
import com.photo.paging.PageRequest;
import com.photo.service.IImageService;
import java.util.List;

/**
 *
 * @author asus
 */
public class ImageService implements IImageService{

    private IImageDAO imageDAO;
    
    public ImageService() {
        imageDAO = new ImageDAO();
    }

    
    @Override
    public List<ImageModel> finfByIdGallery(Integer id) {
       return imageDAO.finfByIdGallery(id);
    }

    @Override
    public ImageModel findRandomImageByIdGallery(Integer id) {
        return imageDAO.findRandomImageByIdGallery(id);
    }

    @Override
    public List<ImageModel> findOffSetByIdGallery(Integer id, PageRequest page) {
        return  imageDAO.findOffSetByIdGallery(id, page);
    }

    @Override
    public int countByIdGallery(Integer id) {
        return imageDAO.countByIdGallery(id);
    }
    
}
