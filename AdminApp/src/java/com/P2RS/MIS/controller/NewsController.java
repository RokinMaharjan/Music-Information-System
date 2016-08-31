/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.P2RS.MIS.controller;

import com.P2RS.MIS.entity.News;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rokin
 */
@Controller

public class NewsController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) 
    {
        model.addAttribute("news", newsScraper());

        return "homePage";
    }
    
    
    public List<News> newsScraper()
    {
        List<News> newsContent = new ArrayList<>();
        try {
            String url = "http://www.music-news.com/";
            Document doc = Jsoup.connect(url).timeout(0).get();
            
            String baseURL = "http://www.music-news.com";
            
            Elements newsElements = doc.select("section#home section.cf div.co11-narrow.is-left");
            for(int i=0; i<4; i++)
            {
                String link = baseURL + newsElements.select("a").get(i).attr("href");
                String imageURL = baseURL + newsElements.select("a").get(i).attr("style").replace("background-image: url('", "").replace("')", "");
                String heading = newsElements.select("div.headline.text-header-15").get(i).text();
                
                newsContent.add(new News(imageURL, link, heading));
            }
            
            System.out.println(newsContent.toString());
            
            
        } catch (IOException ex) {
            Logger.getLogger(NewsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return newsContent;
    }
}
