/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizonline.mapper;

import com.quizonline.model.UserModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class UserMapper implements RowMapper<UserModel> {

    @Override
    public UserModel mapRow(ResultSet rs) {
        try {
            UserModel userModel = new UserModel();
            userModel.setId(rs.getInt("id"));
            userModel.setUsername(rs.getString("username"));
            userModel.setPassword(rs.getString("password"));
            userModel.setEmail(rs.getString("email"));
            userModel.setRoleId(rs.getInt("roleid"));
            return userModel;
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
