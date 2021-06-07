/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.photo.dao;

import com.photo.model.ImageModel;
import com.photo.paging.PageRequest;
import java.util.List;

/**
 *
 * @author asus
 */
public interface IImageDAO extends GenericDAO<ImageModel> {

    List<ImageModel> finfByIdGallery(Integer id);

    ImageModel findRandomImageByIdGallery(Integer id);

    List<ImageModel> findOffSetByIdGallery(Integer id, PageRequest page);

    int countByIdGallery(Integer id);
}
