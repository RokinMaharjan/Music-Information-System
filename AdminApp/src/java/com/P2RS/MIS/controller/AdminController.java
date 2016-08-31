/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.P2RS.MIS.controller;

import com.P2RS.MIS.dao.TrackDAO;
import com.P2RS.MIS.dao.UserDAO;
import com.P2RS.MIS.dao.impl.TrackDAOImpl;
import com.P2RS.MIS.entity.User;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/users/admin")
public class AdminController {

    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private TrackDAO trackDAO;

    @RequestMapping(value = "/viewAll", method = RequestMethod.GET)
    public String viewAll(Model model) {
        model.addAttribute("users", userDAO.getAll());
        return ("viewUsers");
    }

    @RequestMapping(value = "/viewMIS", method = RequestMethod.GET)
    public String viewMIS(Model model)
    {
        model.addAttribute("trackLog", trackDAO.getAllTrackLog());
        return ("viewMIS");
    }
    

}
