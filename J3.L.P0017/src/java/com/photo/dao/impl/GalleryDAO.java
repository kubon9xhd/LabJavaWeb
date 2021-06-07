/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.photo.dao.impl;

import com.photo.dao.IGalleryDAO;
import com.photo.mapper.GalleryMapper;
import com.photo.model.GalleryModel;
import com.photo.paging.PageRequest;
import java.util.List;

/**
 *
 * @author asus
 */
public class GalleryDAO extends AbstractDAO<GalleryModel> implements IGalleryDAO{

    @Override
    public List<GalleryModel> findByOffset(PageRequest page) {
        String sql = "Select * from Gallery order by id offset ? rows fetch next ? rows only";
        List<GalleryModel> list = query(sql, new GalleryMapper(), page.getOffset(), page.getLimit());
        return list.isEmpty() ? null : list;
    }

    @Override
    public int countAll() {
        String sql = "Select COUNT(*) from Gallery";
        return count(sql);
    }

    @Override
    public GalleryModel findById(Integer id) {
        String sql = "Select * from Gallery where id = ?";
        List<GalleryModel> list = query(sql, new GalleryMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<GalleryModel> findTop3Random() {
        String sql = "Select Top 3 * from Gallery order by checksum(newid())";
        List<GalleryModel> list = query(sql, new GalleryMapper());
        return list.isEmpty() ? null : list;
    }
    
}
