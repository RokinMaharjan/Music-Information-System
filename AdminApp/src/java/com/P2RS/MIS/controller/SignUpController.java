/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.P2RS.MIS.controller;

import com.P2RS.MIS.dao.UserDAO;
import com.P2RS.MIS.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rokin
 */
@Controller
public class SignUpController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("dob") String dob,
            @RequestParam("address") String address,
            @RequestParam("gender") String gender) {

        userDAO.insert(new User(username, password, firstname, lastname, dob, address, gender));

        return "User Added";

    }
}
