/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.photo.mapper;

import com.photo.model.ImageModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class ImagesMapper implements RowMapper<ImageModel>{

    @Override
    public ImageModel mapRow(ResultSet rs) {
        try {
            ImageModel imageModel = new ImageModel();
            imageModel.setId(rs.getInt("id"));
            imageModel.setGallery_id(rs.getInt("gallery_id"));
            imageModel.setUrl(rs.getString("image_url"));
            return imageModel;
        } catch (SQLException ex) {
            Logger.getLogger(ImagesMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
