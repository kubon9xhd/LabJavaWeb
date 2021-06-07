/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.photo.dao.impl;

import com.photo.dao.IImageDAO;
import com.photo.mapper.ImagesMapper;
import com.photo.model.ImageModel;
import com.photo.paging.PageRequest;
import java.util.List;

/**
 *
 * @author asus
 */
public class ImageDAO extends AbstractDAO<ImageModel> implements IImageDAO {

    @Override
    public List<ImageModel> finfByIdGallery(Integer id) {
        String sql = "Select * from Images where gallery_id = ?";
        List<ImageModel> list = query(sql, new ImagesMapper(), id);
        return list.isEmpty() ? null : list;
    }

    @Override
    public ImageModel findRandomImageByIdGallery(Integer id) {
        String sql = "Select Top 1 * from Images where gallery_id = ? order by CHECKSUM(NEWID())";
        List<ImageModel> list = query(sql, new ImagesMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<ImageModel> findOffSetByIdGallery(Integer id, PageRequest page) {
        String sql = "Select * from Images where gallery_id = ? order by id offset ? rows fetch next ? rows only";
        List<ImageModel> list = query(sql, new ImagesMapper(), id, page.getOffset(), page.getLimit());
        return list.isEmpty() ? null : list;
    }

    @Override
    public int countByIdGallery(Integer id) {
        String sql = "Select count(*) from Images where gallery_id = ?";
        return count(sql, id);
    }

}
