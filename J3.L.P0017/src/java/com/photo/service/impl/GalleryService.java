/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.photo.service.impl;

import com.photo.dao.IGalleryDAO;
import com.photo.dao.impl.GalleryDAO;
import com.photo.model.GalleryModel;
import com.photo.paging.PageRequest;
import com.photo.service.IGalleryService;
import java.util.List;

/**
 *
 * @author asus
 */
public class GalleryService implements IGalleryService{

    private IGalleryDAO galleryDAO;

    public GalleryService() {
        galleryDAO = new GalleryDAO();
    }
    
    @Override
    public List<GalleryModel> findByOffset(PageRequest page) {
        return  galleryDAO.findByOffset(page);
    }

    @Override
    public int countAll() {
        return galleryDAO.countAll();
    }

    @Override
    public GalleryModel findById(Integer id) {
        return galleryDAO.findById(id);
    }

    @Override
    public List<GalleryModel> findTop3Random() {
        return  galleryDAO.findTop3Random();
    }
    
}
