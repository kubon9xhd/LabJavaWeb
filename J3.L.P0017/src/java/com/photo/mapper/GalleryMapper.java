/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.photo.mapper;

import com.photo.model.GalleryModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class GalleryMapper implements RowMapper<GalleryModel>{

    @Override
    public GalleryModel mapRow(ResultSet rs) {
        try {
            GalleryModel galleryModel = new GalleryModel();
            galleryModel.setId(rs.getInt("id"));
            galleryModel.setTitle(rs.getString("title"));
            galleryModel.setDescription(rs.getString("description"));
            galleryModel.setName(rs.getString("name"));
            return galleryModel;
        } catch (SQLException ex) {
            Logger.getLogger(GalleryMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
