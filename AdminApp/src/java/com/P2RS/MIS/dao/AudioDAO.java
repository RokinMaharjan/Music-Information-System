/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.P2RS.MIS.dao;

import com.P2RS.MIS.entity.Audio;
import java.util.List;

/**
 *
 * @author gandoff
 */
public interface AudioDAO {

    List<Audio> getAll();

    void deleteAudio(int id);

    Audio getById(int id);

    void update(Audio track);

}
