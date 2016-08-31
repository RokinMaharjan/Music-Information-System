/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.P2RS.MIS.controller;

import com.P2RS.MIS.dao.AudioDAO;
import com.P2RS.MIS.dao.TrackDAO;
import com.P2RS.MIS.entity.Audio;
import com.P2RS.MIS.entity.Track;
import com.P2RS.MIS.helper.JSONHelper;
import com.P2RS.MIS.helper.URLHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author gandoff
 */
@Controller
@RequestMapping(value = "/track")
public class TrackController {

    @Autowired
    private TrackDAO trackDAO;

    @Autowired
    private AudioDAO audioDAO;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    String getAll() {
        return new JSONArray(trackDAO.getAll()).toString();
    }

    @RequestMapping(value = "/admin/viewAll", method = RequestMethod.GET)
    String getAllTracks(Model model) {
        model.addAttribute("tracks", trackDAO.getAll());
        return "viewTracks";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String deleteTrack(@PathVariable("id") int id) {
        trackDAO.deleteTrack(id);
        return "redirect:/track/admin/viewAll";

    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("track", trackDAO.getById(id));
        return "editModal";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    String update(@ModelAttribute Track track) {
        System.out.println(track.toString());

        System.out.println("Controller" + track.toString());
        trackDAO.update(track);
        return "redirect:/track/viewAll";
    }

    @RequestMapping(value = "/addTrack", method = RequestMethod.GET)
    String addTrack(Model model) {
        model.addAttribute("track", new Track());
        return "editModal";
    }

    @RequestMapping(value = "/updateAudio", method = RequestMethod.GET)
    @ResponseBody
    String update() {
        Audio audio = new Audio();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/home/gandoff/Documents/audiofinal.csv"));
            String line = "";
            while ((line = reader.readLine()) != "") {
                String[] tokens = line.split(",");

                if (tokens.length == 1) {
                    System.out.println(tokens.length);
                    break;
                }
                audio.setAudioLoudness(Double.valueOf(tokens[0]));
                audio.setAudioEnergy(Double.valueOf(tokens[1]));
                audio.setAudioDancebility(Double.valueOf(tokens[2]));
                audio.setAudioBpm(Double.valueOf(tokens[3]));
                audio.setAudioId(Integer.valueOf(tokens[4]));
                audio.setLyricsValence(Double.valueOf(tokens[5]));
                audio.setLyricsArousal(Double.valueOf(tokens[6]));
                audio.setTrackId(trackDAO.getById(Integer.valueOf(tokens[4])));

                audioDAO.update(audio);
                //loudness energy dance bpm
            }
        } catch (IOException ie) {
            System.out.println(ie.getMessage());

        }
        return "DONE";
    }

}
