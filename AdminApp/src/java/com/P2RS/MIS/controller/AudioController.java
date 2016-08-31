/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.P2RS.MIS.controller;

import com.P2RS.MIS.dao.AudioDAO;
import com.P2RS.MIS.dao.TrackDAO;
import com.P2RS.MIS.dao.UserDAO;
import com.P2RS.MIS.entity.Track;
import com.P2RS.MIS.entity.TrackLog;
import com.P2RS.MIS.entity.User;
import com.P2RS.MIS.recommender.ClusterAlgorithm;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author gandoff
 */
@Controller
@RequestMapping(value = "track/audio")
public class AudioController {

    @Autowired
    private AudioDAO audioDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TrackDAO trackDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getById(@PathVariable("id") int id) {
        return audioDAO.getById(id).toString();
    }

    @RequestMapping(value = "/getRecomd/{id}/{userName}", method = RequestMethod.GET)
    @ResponseBody
    public String getRecomd(@PathVariable("id") int id,
            @PathVariable("userName") String userName) {

        //System.out.println("ETAAAAA" + userName + "    =====   " +  id);
        addLog(id, userName);

        List<Integer> cluster = ClusterAlgorithm.getCluster(id, audioDAO.getAll());
        List<Track> recomTrackList = new ArrayList();

        for (Integer trackId : cluster) {

            Track track = trackDAO.getById(trackId);

            recomTrackList.add(track);

        }

        return new JSONArray(recomTrackList).toString();
    }

    
    private void addLog(int trackId, String userName) 
    {
        TrackLog trackLog = trackDAO.getTrackLogById(trackId);

        if (trackLog == null) {
            trackLog = new TrackLog();
            trackLog.setTrackId(trackId);
        }

        User user = userDAO.getByUsername(userName);

        String userDOB = user.getDob();
        String[] tokens = userDOB.split("/");
        int ageYear = Integer.parseInt(tokens[2]);
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date();
//        int currentYear = Integer.parseInt(dateFormat.format(date)); //2014/08/06 15:59:48

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        int userAge = currentYear - ageYear;

        String ageGroup = "";
        if (userAge < 20) {
            ageGroup = "Teen";
        } else if (userAge >= 20 && userAge < 31) {
            ageGroup = "Young Adult";
        } else {
            ageGroup = "Adult";
        }

        switch (ageGroup) {

            case "Teen":
                int value = trackLog.getTeen();
                trackLog.setTeen(value +1);
                break;

            case "Young Adult":
                trackLog.setYoungAdult(trackLog.getYoungAdult() + 1);
                break;

            case "Adult":
                trackLog.setAdult(trackLog.getAdult() + 1);
                break;

            default:
                break;

        }

        String location = user.getAddress();

        if (location.equalsIgnoreCase("kathmandu"))
        {
            trackLog.setKathmandu(trackLog.getKathmandu() + 1);
        } 
        else if (location.equalsIgnoreCase("bhaktapur")) 
        {
            trackLog.setBhaktapur(trackLog.getBhaktapur() + 1);
        }
        else if (location.equalsIgnoreCase("lalitpur")) 
        {
            trackLog.setLalitpur(trackLog.getLalitpur() + 1);
        } else 
        {
        }

        trackDAO.insertLog(trackLog);

    }

}
