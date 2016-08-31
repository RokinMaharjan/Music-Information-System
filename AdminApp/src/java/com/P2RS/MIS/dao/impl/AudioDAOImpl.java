/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.P2RS.MIS.dao.impl;

import com.P2RS.MIS.dao.AudioDAO;
import com.P2RS.MIS.entity.Audio;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gandoff
 */
@Repository
public class AudioDAOImpl implements AudioDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Transaction trans;

    private Session session;

    @Override
    public List<Audio> getAll() {

        List<Audio> audioList = new ArrayList();
        session = sessionFactory.openSession();

        trans = session.beginTransaction();

        audioList = session.getNamedQuery("Audio.findAll").list();

        trans.commit();

        session.close();

        return audioList;

    }

    @Override
    public void deleteAudio(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Audio getById(int id) {
        session = sessionFactory.openSession();

        trans = session.beginTransaction();

        Audio audio = (Audio) session.get(Audio.class, id);

        trans.commit();

        session.close();

        return audio;
    }

    @Override
    public void update(Audio track) {
        session = sessionFactory.openSession();

        trans = session.beginTransaction();

        session.saveOrUpdate(track);

        trans.commit();

        session.close();
    }

}
