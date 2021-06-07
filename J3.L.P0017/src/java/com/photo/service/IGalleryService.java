/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.photo.service;

import com.photo.model.GalleryModel;
import com.photo.paging.PageRequest;
import java.util.List;

/**
 *
 * @author asus
 */
public interface IGalleryService {

    GalleryModel findById(Integer id);

    List<GalleryModel> findByOffset(PageRequest page);

    List<GalleryModel> findTop3Random();

    int countAll();
}
