/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digital.mapper;

import com.digital.model.DigitalModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class DigitalMapper implements RowMapper<DigitalModel>{
    @Override
    public DigitalModel mapRow(ResultSet rs){
        try{
            DigitalModel digital = new DigitalModel();
            digital.setId(rs.getInt("id"));
            digital.setTitle(rs.getString("title"));
            digital.setContent(rs.getString("content"));
            digital.setDescription(rs.getString("description"));
            digital.setImage(rs.getString("image"));
            digital.setCreatedDate(rs.getDate("created_date"));
            digital.setCreatedBy(rs.getString("created_by"));
            return digital;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return null;
    }
}
