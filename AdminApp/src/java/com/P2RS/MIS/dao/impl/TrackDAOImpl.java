/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.P2RS.MIS.dao.impl;

import com.P2RS.MIS.helper.JSONHelper;
import com.P2RS.MIS.dao.TrackDAO;
import com.P2RS.MIS.entity.Track;
import com.P2RS.MIS.entity.TrackLog;
import com.P2RS.MIS.helper.URLHelper;
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
public class TrackDAOImpl implements TrackDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Transaction trans;

    private Session session;

    @Override
    public List<Track> getAll() {

        session = sessionFactory.openSession();

        trans = session.beginTransaction();

        List<Track> trackList = session.getNamedQuery("Track.findAll").list();

        trans.commit();

        session.close();

        return trackList;
    }

    @Override
    public void deleteTrack(int id) {

        Track trackTodelete = getById(id);

        session = sessionFactory.openSession();

        trans = session.beginTransaction();

        session.delete(trackTodelete);

        trans.commit();

        session.close();
    }

    @Override
    public Track getById(int id) {
        session = sessionFactory.openSession();

        trans = session.beginTransaction();

        Track track = (Track) session.get(Track.class, id);

        trans.commit();

        session.close();

        return track;
    }

    @Override
    public void update(Track track) {

        System.out.println("Update" + track);
        Track detailTrack = JSONHelper.getTrackDetails(URLHelper.get(track));

        track.setArtist(detailTrack.getArtist());

        track.setAlbumArtURL(detailTrack.getAlbumArtURL());

        track.setStreamURL(detailTrack.getStreamURL());

        session = sessionFactory.openSession();

        trans = session.beginTransaction();

        session.saveOrUpdate(track);

        trans.commit();

        session.close();
    }

    

    @Override
    public void insertLog(TrackLog trackLog) {

        session = sessionFactory.openSession();

        trans = session.beginTransaction();

        session.saveOrUpdate(trackLog);

        trans.commit();

        session.close();

    }
    
    @Override
    public TrackLog getTrackLogById(int id) {
        session = sessionFactory.openSession();

        trans = session.beginTransaction();

        TrackLog trackLog = (TrackLog) session.get(TrackLog.class, id);

        trans.commit();

        session.close();

        return trackLog;
    }

    @Override
    public List<TrackLog> getAllTrackLog() {
        session = sessionFactory.openSession();

        trans = session.beginTransaction();

        List<TrackLog> trackLog = session.getNamedQuery("TrackLog.findAll").list();

        trans.commit();

        session.close();

        return trackLog;
    }

}
