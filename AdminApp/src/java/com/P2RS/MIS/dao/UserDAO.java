/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.P2RS.MIS.dao;

import com.P2RS.MIS.entity.User;
import java.util.List;

/**
 *
 * @author rokin
 */
public interface UserDAO {
    List<User> getAll();
    User getByUsername(String username);
    int insert(User user);
    int update(User user);
    int delete(String username);
}
