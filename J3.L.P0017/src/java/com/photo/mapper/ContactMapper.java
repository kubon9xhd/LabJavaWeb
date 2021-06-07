/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.photo.mapper;

import com.photo.model.ContactModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class ContactMapper implements RowMapper<ContactModel>{

    @Override
    public ContactModel mapRow(ResultSet rs) {
        try {
            ContactModel model = new ContactModel();
            model.setAddress(rs.getString("address"));
            model.setCity(rs.getString("city"));
            model.setCountry(rs.getString("country"));
            model.setTelephone(rs.getString("telephone"));
            model.setEmail(rs.getString("email"));
            model.setFaceUrl(rs.getString("face_url"));
            model.setTwitterUrl(rs.getString("twitter_url"));
            model.setGoogleUrl(rs.getString("google_url"));
            model.setAbout(rs.getString("about"));
            model.setImageMain(rs.getString("image_main"));
            model.setMap(rs.getString("map"));
            model.setContentMain(rs.getString("content_main"));
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(ContactMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
