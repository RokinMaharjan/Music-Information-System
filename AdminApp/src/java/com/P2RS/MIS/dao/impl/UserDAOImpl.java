/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.P2RS.MIS.dao.impl;

import com.P2RS.MIS.dao.UserDAO;
import com.P2RS.MIS.entity.Track;
import com.P2RS.MIS.entity.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author rokin
 */


@Service
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction trans;

    @Override
    public List<User> getAll() {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        List<User> userList = session.getNamedQuery("User.findAll").list();
        trans.commit();
        session.close();
        return userList;
    }

    @Override
    public int insert(User user) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        session.save(user);
        trans.commit();
        session.close();
        return 1;
    }

    @Override
    public int update(User user) {
       session = sessionFactory.openSession();
       trans = session.beginTransaction();
       session.saveOrUpdate(user);
       trans.commit();
       session.close();
       return 1;
    }

    @Override
    public int delete(String username) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        User user =(User)session.get(User.class, username);
        session.delete(user);
        trans.commit();
        session.close();
        return 1;
    }

    @Override
    public User getByUsername(String username) {
        
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        Query query = session.getNamedQuery("User.findByUsername");
        query.setString("username", username);
        User user = (User) query.list().get(0);

//        User user = (User) session.get(User.class, username);
        trans.commit();
        session.close();
        return user;
    }

}
