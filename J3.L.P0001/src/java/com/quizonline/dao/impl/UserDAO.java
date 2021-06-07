/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizonline.dao.impl;

import com.quizonline.dao.IUserDAO;
import com.quizonline.mapper.UserMapper;
import com.quizonline.model.UserModel;
import java.util.List;

/**
 *
 * @author asus
 */
public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

    @Override
    public UserModel findByUsernameAndPassword(String username, String password) {
        String sql = "Select * from [User] where username = ? and password = ?";
        List<UserModel> listUser = query(sql, new UserMapper(), username, password);
        return listUser.isEmpty() ? null : listUser.get(0);
    }

    @Override
    public UserModel findByUsername(String username) {
        String sql = "Select * from [User] where username = ?";
        List<UserModel> listUser = query(sql, new UserMapper(), username);
        return listUser.isEmpty() ? null : listUser.get(0);
    }

    @Override
    public Long save(UserModel userModel) {
        String sql = "Insert into [User](username,password,roleid,email,created_by,created_date) values (?,?,?,?,?,?)";
        Long id = insert(sql, userModel.getUsername(), userModel.getPassword(),
                userModel.getRoleId(), userModel.getEmail(),
                userModel.getCratedBy(), userModel.getCreateDate()
        );
        return (id != null) ? id : null;
    }

}
