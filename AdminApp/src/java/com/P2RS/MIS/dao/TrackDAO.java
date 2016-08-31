/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.P2RS.MIS.dao;

import com.P2RS.MIS.entity.Track;
import com.P2RS.MIS.entity.TrackLog;
import java.util.List;

/**
 *
 * @author gandoff
 */
public interface TrackDAO {
    List<Track> getAll();
    void deleteTrack(int id);
    Track getById(int id);
    void update(Track track);
    void insertLog(TrackLog trackLog);
    TrackLog getTrackLogById(int id);
    List<TrackLog> getAllTrackLog();
}
