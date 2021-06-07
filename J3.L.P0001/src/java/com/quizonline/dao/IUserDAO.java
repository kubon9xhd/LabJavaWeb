/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizonline.dao;

import com.quizonline.model.UserModel;

/**
 *
 * @author asus
 */
public interface IUserDAO extends GenericDAO<UserModel>{
    UserModel findByUsernameAndPassword(String username, String password);

    UserModel findByUsername(String username);

    Long save(UserModel userModel);
}
