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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gandoff
 */
@Entity
@Table(name = "tbl_Audio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Audio.findAll", query = "SELECT a FROM Audio a"),
    @NamedQuery(name = "Audio.findByAudioId", query = "SELECT a FROM Audio a WHERE a.audioId = :audioId"),
    @NamedQuery(name = "Audio.findByAudioBpm", query = "SELECT a FROM Audio a WHERE a.audioBpm = :audioBpm"),
    @NamedQuery(name = "Audio.findByAudioDancebility", query = "SELECT a FROM Audio a WHERE a.audioDancebility = :audioDancebility"),
    @NamedQuery(name = "Audio.findByAudioEnergy", query = "SELECT a FROM Audio a WHERE a.audioEnergy = :audioEnergy"),
    @NamedQuery(name = "Audio.findByAudioLoudness", query = "SELECT a FROM Audio a WHERE a.audioLoudness = :audioLoudness"),
    @NamedQuery(name = "Audio.findByLyricsValence", query = "SELECT a FROM Audio a WHERE a.lyricsValence = :lyricsValence"),
    @NamedQuery(name = "Audio.findByLyricsArousal", query = "SELECT a FROM Audio a WHERE a.lyricsArousal = :lyricsArousal")})
public class Audio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "audio_id")
    private Integer audioId;
    @Basic(optional = false)
    @Column(name = "audio_bpm")
    private double audioBpm;
    @Basic(optional = false)
    @Column(name = "audio_dancebility")
    private double audioDancebility;
    @Basic(optional = false)
    @Column(name = "audio_energy")
    private double audioEnergy;
    @Basic(optional = false)
    @Column(name = "audio_loudness")
    private double audioLoudness;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lyrics_valence")
    private Double lyricsValence;
    @Column(name = "lyrics_arousal")
    private Double lyricsArousal;
    @JoinColumn(name = "track_id", referencedColumnName = "track_id")
    @ManyToOne(optional = false)
    private Track trackId;

    public Audio() {
    }

    public Audio(Integer audioId) {
        this.audioId = audioId;
    }

    public Audio(Integer audioId, double audioBpm, double audioDancebility, double audioEnergy, double audioLoudness) {
        this.audioId = audioId;
        this.audioBpm = audioBpm;
        this.audioDancebility = audioDancebility;
        this.audioEnergy = audioEnergy;
        this.audioLoudness = audioLoudness;
    }

    public Integer getAudioId() {
        return audioId;
    }

    public void setAudioId(Integer audioId) {
        this.audioId = audioId;
    }

    public double getAudioBpm() {
        return audioBpm;
    }

    public void setAudioBpm(double audioBpm) {
        this.audioBpm = audioBpm;
    }

    public double getAudioDancebility() {
        return audioDancebility;
    }

    public void setAudioDancebility(double audioDancebility) {
        this.audioDancebility = audioDancebility;
    }

    public double getAudioEnergy() {
        return audioEnergy;
    }

    public void setAudioEnergy(double audioEnergy) {
        this.audioEnergy = audioEnergy;
    }

    public double getAudioLoudness() {
        return audioLoudness;
    }

    public void setAudioLoudness(double audioLoudness) {
        this.audioLoudness = audioLoudness;
    }

    public Double getLyricsValence() {
        return lyricsValence;
    }

    public void setLyricsValence(Double lyricsValence) {
        this.lyricsValence = lyricsValence;
    }

    public Double getLyricsArousal() {
        return lyricsArousal;
    }

    public void setLyricsArousal(Double lyricsArousal) {
        this.lyricsArousal = lyricsArousal;
    }

    public Track getTrackId() {
        return trackId;
    }

    public void setTrackId(Track trackId) {
        this.trackId = trackId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (audioId != null ? audioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Audio)) {
            return false;
        }
        Audio other = (Audio) object;
        if ((this.audioId == null && other.audioId != null) || (this.audioId != null && !this.audioId.equals(other.audioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.P2RS.MIS.entity.Audio[ audioId=" + audioId + " ]";
    }
    
}
