/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.P2RS.MIS.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rokin
 */
@Entity
@Table(name = "track_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrackLog.findAll", query = "SELECT t FROM TrackLog t"),
    @NamedQuery(name = "TrackLog.findByTrackId", query = "SELECT t FROM TrackLog t WHERE t.trackId = :trackId"),
    @NamedQuery(name = "TrackLog.findByTeen", query = "SELECT t FROM TrackLog t WHERE t.teen = :teen"),
    @NamedQuery(name = "TrackLog.findByYoungAdult", query = "SELECT t FROM TrackLog t WHERE t.youngAdult = :youngAdult"),
    @NamedQuery(name = "TrackLog.findByAdult", query = "SELECT t FROM TrackLog t WHERE t.adult = :adult"),
    @NamedQuery(name = "TrackLog.findByKathmandu", query = "SELECT t FROM TrackLog t WHERE t.kathmandu = :kathmandu"),
    @NamedQuery(name = "TrackLog.findByBhaktapur", query = "SELECT t FROM TrackLog t WHERE t.bhaktapur = :bhaktapur"),
    @NamedQuery(name = "TrackLog.findByLalitpur", query = "SELECT t FROM TrackLog t WHERE t.lalitpur = :lalitpur")})
public class TrackLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Track_Id")
    private Integer trackId;
    @Basic(optional = false)
    @Column(name = "Teen")
    private int teen;
    @Basic(optional = false)
    @Column(name = "Young_Adult")
    private int youngAdult;
    @Basic(optional = false)
    @Column(name = "Adult")
    private int adult;
    @Basic(optional = false)
    @Column(name = "Kathmandu")
    private int kathmandu;
    @Basic(optional = false)
    @Column(name = "Bhaktapur")
    private int bhaktapur;
    @Basic(optional = false)
    @Column(name = "Lalitpur")
    private int lalitpur;

    public TrackLog() {
    }

    public TrackLog(Integer trackId) {
        this.trackId = trackId;
    }

    public TrackLog(Integer trackId, int teen, int youngAdult, int adult, int kathmandu, int bhaktapur, int lalitpur) {
        this.trackId = trackId;
        this.teen = teen;
        this.youngAdult = youngAdult;
        this.adult = adult;
        this.kathmandu = kathmandu;
        this.bhaktapur = bhaktapur;
        this.lalitpur = lalitpur;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public int getTeen() {
        return teen;
    }

    public void setTeen(int teen) {
        this.teen = teen;
    }

    public int getYoungAdult() {
        return youngAdult;
    }

    public void setYoungAdult(int youngAdult) {
        this.youngAdult = youngAdult;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getKathmandu() {
        return kathmandu;
    }

    public void setKathmandu(int kathmandu) {
        this.kathmandu = kathmandu;
    }

    public int getBhaktapur() {
        return bhaktapur;
    }

    public void setBhaktapur(int bhaktapur) {
        this.bhaktapur = bhaktapur;
    }

    public int getLalitpur() {
        return lalitpur;
    }

    public void setLalitpur(int lalitpur) {
        this.lalitpur = lalitpur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trackId != null ? trackId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrackLog)) {
            return false;
        }
        TrackLog other = (TrackLog) object;
        if ((this.trackId == null && other.trackId != null) || (this.trackId != null && !this.trackId.equals(other.trackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.P2RS.MIS.entity.TrackLog[ trackId=" + trackId + " ]";
    }
    
}
