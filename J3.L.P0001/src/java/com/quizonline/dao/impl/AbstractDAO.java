package com.quizonline.dao.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.quizonline.dao.GenericDAO;
import com.quizonline.mapper.RowMapper;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class AbstractDAO<T> implements GenericDAO<T> {

    ResourceBundle rs = ResourceBundle.getBundle("com.quizonline.config.db");

    public Connection getConnection() {
        try {
            Class.forName(rs.getString("driverName"));
            String url = rs.getString("url");
            return DriverManager.getConnection(url, rs.getString("user"), rs.getString("password"));
        } catch (ClassNotFoundException | SQLException ex) { // mutil exception
            return null;
        }
    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            //set parameter
            setParameters(ps, parameters);
            rs = ps.executeQuery();
            while (rs.next()) {
                results.add(rowMapper.mapRow(rs));
            }
            return results;
        } catch (SQLException ex) {
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                return null;
            }
        }
    }

    @Override
    public void update(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            setParameters(ps, parameters);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    ex1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (ps != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Long insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Long id = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            setParameters(ps, parameters);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
            connection.commit();
            return id;
        } catch (SQLException ex) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    ex1.printStackTrace();
                }
            }
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (ps != null) {
                    connection.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private void setParameters(PreparedStatement ps, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Long) {
                    ps.setLong(index, (Long) parameter);
                } else if (parameter instanceof String) {
                    ps.setString(index, (String) parameter);
                } else if (parameter instanceof Integer) {
                    ps.setInt(index, (Integer) parameter);
                } else if (parameter instanceof Timestamp) {
                    ps.setDate(index, new Date(((Timestamp) parameter).getTime()));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int count(String sql, Object... parameters) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            int count = 0;
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            //set parameter
            setParameters(ps, parameters);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException ex) {
            return 0;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                return 0;
            }
        }
    }

}
