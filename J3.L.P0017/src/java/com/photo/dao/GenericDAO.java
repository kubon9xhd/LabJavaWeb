/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.photo.dao;

import com.photo.mapper.RowMapper;
import java.util.List;

/**
 *
 * @author asus
 */
public interface GenericDAO<T> {

    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);

    void update(String sql, Object... parameters);

    Long insert(String sql, Object... parameters);

    int count(String sql, Object... parameters);
}
