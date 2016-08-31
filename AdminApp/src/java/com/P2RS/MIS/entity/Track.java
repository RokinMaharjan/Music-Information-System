/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.P2RS.MIS.entity;

import com.sun.istack.internal.Nullable;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gandoff
 */
@Entity
@Table(name = "tbl_Track")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Track.findAll", query = "SELECT t FROM Track t"),
    @NamedQuery(name = "Track.findByTrackId", query = "SELECT t FROM Track t WHERE t.trackId = :trackId"),
    @NamedQuery(name = "Track.findByTrackTitle", query = "SELECT t FROM Track t WHERE t.trackTitle = :trackTitle"),
    @NamedQuery(name = "Track.findByTrackSource", query = "SELECT t FROM Track t WHERE t.trackSource = :trackSource")})
public class Track implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trackId")
    private Collection<TrackLog> trackLogCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trackId")
    private Collection<Audio> tblAudioCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "track_id")
    private Integer trackId;
    @Basic(optional = false)
    @Column(name = "track_title")
    private String trackTitle;
    @Basic(optional = false)
    @Column(name = "track_source")
    private String trackSource;

    @Column(name = "track_stream_url")
    private String streamURL="http://192.168.1.101:8081/listen/";

    @Column(name = "track_album_art_url")
    private String albumArtURL;

    @Column(name = "track_artist")
    private String artist;

    public Track() {
    }

    public Track(Integer trackId) {
        this.trackId = trackId;
    }

    public Track(Integer trackId, String trackTitle, String trackSource) {
        this.trackId = trackId;
        this.trackTitle = trackTitle;
        this.trackSource = trackSource;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public String getTrackSource() {
        return trackSource;
    }

    public void setTrackSource(String trackSource) {
        this.trackSource = trackSource;
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
        if (!(object instanceof Track)) {
            return false;
        }
        Track other = (Track) object;
        if ((this.trackId == null && other.trackId != null) || (this.trackId != null && !this.trackId.equals(other.trackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{title=" + trackTitle + " , artist=" + artist 
                + " , albumArt=" + albumArtURL
                + " , streamURL=" + streamURL + trackSource + "}";
    }

    public String getStreamURL() {
        return streamURL;
    }

    public void setStreamURL(String streamURL) {
        this.streamURL = streamURL;
    }

    public String getAlbumArtURL() {
        return albumArtURL;
    }

    public void setAlbumArtURL(String albumArtURL) {
        this.albumArtURL = albumArtURL;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @XmlTransient
    public Collection<Audio> getTblAudioCollection() {
        return tblAudioCollection;
    }

    public void setTblAudioCollection(Collection<Audio> tblAudioCollection) {
        this.tblAudioCollection = tblAudioCollection;
    }

    @XmlTransient
    public Collection<TrackLog> getTrackLogCollection() {
        return trackLogCollection;
    }

    public void setTrackLogCollection(Collection<TrackLog> trackLogCollection) {
        this.trackLogCollection = trackLogCollection;
    }

}
