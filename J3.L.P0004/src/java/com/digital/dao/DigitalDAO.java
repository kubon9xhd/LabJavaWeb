/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digital.dao;

import com.digital.mapper.DigitalMapper;
import com.digital.model.DigitalModel;
import com.digital.paging.PageRequest;
import java.util.List;

/**
 *
 * @author asus
 */
public class DigitalDAO extends AbstractDAO<DigitalModel> {

    public DigitalModel findOne() {
        return null;
    }

    public DigitalModel findTopOne() {
        String sql = "Select top 1 * from Digital order by created_date desc";
        List<DigitalModel> listModel = query(sql, new DigitalMapper());
        return listModel.isEmpty() ? null : listModel.get(0);
    }

    public List<DigitalModel> findTopFive() {
        StringBuilder sql = new StringBuilder("Select top 5 * from Digital where created_date ");
        sql.append("not in (Select max(created_date) from Digital) order by created_date desc");
        List<DigitalModel> listModel = query(sql.toString(), new DigitalMapper());
        return listModel.isEmpty() ? null : listModel;
    }

    public DigitalModel findById(Integer id) {
        String sql = "Select * from Digital where id = ?";
        List<DigitalModel> listModel = query(sql, new DigitalMapper(), id);
        return listModel.isEmpty() ? null : listModel.get(0);
    }
    public int countByTitle(String title){
        String sql ="select count(*) from Digital where title like ?";
        return count(sql, "%"+title+"%");
    }
    public List<DigitalModel> findByTitle(String title,PageRequest page) {
        String sql = "Select * from Digital where title like ? order by id offset ? rows fetch next ? rows only";
        List<DigitalModel> listModel = query(sql, new DigitalMapper(), "%"+title+"%",page.getOffset(), page.getLimit());
        return listModel.isEmpty() ? null : listModel;
    }
}
