/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.P2RS.MIS.entity;

/**
 *
 * @author rokin
 */
public class News {
    private String imageURL, link, heading;

    public News() {
    }

    public News(String imageURL, String link, String heading) {
        this.imageURL = imageURL;
        this.link = link;
        this.heading = heading;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
    
}
