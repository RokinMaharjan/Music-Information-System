/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.P2RS.MIS.recommender;

import com.P2RS.MIS.dao.AudioDAO;
import com.P2RS.MIS.dao.impl.AudioDAOImpl;
import com.P2RS.MIS.entity.Audio;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author gandoff
 */
public class ClusterAlgorithm {

    public static List<Integer> getCluster(int id, List<Audio> audioList) {

        double[][] dataMatrix = createDataMatrix(audioList);
        double[][] distanceMatrix;

        System.out.println("DataMatrix");
        displayMatrix(dataMatrix);

        distanceMatrix = calcDistances(dataMatrix);

        List<Integer> cluster = new ArrayList();
  
        int row = id - 1;
        System.out.println("Distance matrix");
        displayMatrix(distanceMatrix);
        
        int iteration =0;
        while (cluster.size() < 5) {
            
            if(distanceMatrix.length  == 1){
                break;
            }
            
            ++iteration;
            int column = 1;
            double min = distanceMatrix[row][0];
            for (int j = 0; j < distanceMatrix[row].length; j++) {
                {
                    if (min > distanceMatrix[row][j] && distanceMatrix[row][j] != 0.0) {
                        min = distanceMatrix[row][j];
                        column = j;
                    }
                }
            }
            
              System.out.println(column);

            for (int j = 0; j < distanceMatrix[0].length; j++) {
                distanceMatrix[row][j] = Math.min(distanceMatrix[row][j], distanceMatrix[column][j]);
            }
            System.out.println("Update");
            distanceMatrix = updateMatrix(distanceMatrix, column);
            displayMatrix(distanceMatrix);
            if (!cluster.contains(column + iteration)
                    && (column + iteration)!= id) {
                cluster.add(column + iteration);
           }
            if (column < row) {
                row = column;
            }
        }
        System.out.println(cluster);
        return cluster;
    }

    public static double[][] createDataMatrix(List<Audio> audios) {
        double[][] dataMatrix = new double[audios.size()][6];

        Audio audio = new Audio();
        for (int i = 0; i < audios.size(); i++) {
            audio = audios.get(i);
            for (int j = 0; j < 6; j++) {
                if (j == 0) {
                    dataMatrix[i][j] = audio.getAudioLoudness();
                }
                if (j == 1) {
                    dataMatrix[i][j] = audio.getAudioEnergy();
                }
                if (j == 2) {
                    dataMatrix[i][j] = audio.getAudioDancebility();
                }
                if (j == 3) {
                    dataMatrix[i][j] = audio.getAudioBpm();
                }
                if (j == 4) {
                    dataMatrix[i][j] = audio.getLyricsArousal();
                }
                if (j == 5) {
                    dataMatrix[i][j] = audio.getLyricsArousal();
                }
            }
        }
        return dataMatrix;

    }

    public static double[][] calcDistances(double[][] dataMatrix) {
        double[][] distanceMatrix = new double[dataMatrix.length][dataMatrix.length];
        for (int i = 0; i < dataMatrix.length; i++) {
            for (int k = 0; k < dataMatrix.length; k++) {
                for (int j = 0; j < dataMatrix[i].length; j++) {
                    if (j == 1 || j == 2) {
                        distanceMatrix[i][k] = distanceMatrix[i][k] + (Math.pow((dataMatrix[k][j] - dataMatrix[i][j]), 2));
                    }
                    if (j == 0) {
                        distanceMatrix[i][k] = (distanceMatrix[i][k] + (Math.pow((dataMatrix[k][j] - dataMatrix[i][j]), 2))) * 1;
                    }
                    if (j == 3) {
                        distanceMatrix[i][k] = (distanceMatrix[i][k] + (Math.pow((dataMatrix[k][j] - dataMatrix[i][j]), 2))) * 1;
                    }
                    if (j == 4 || j==5) {
                        distanceMatrix[i][k] = (distanceMatrix[i][k] + (Math.pow((dataMatrix[k][j] - dataMatrix[i][j]), 2))) * 0.4;
                    }
                   
                }
                distanceMatrix[i][k] = Math.sqrt(distanceMatrix[i][k]);
                distanceMatrix[i][k] = new BigDecimal(distanceMatrix[i][k]).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
        }
        return distanceMatrix;
    }

    public static double[][] updateMatrix(double[][] dataMatrix, int rmv) {
        double[][] updateMatrix = new double[dataMatrix.length - 1][dataMatrix[0].length - 1];
        boolean rowFound = false;
        boolean columnFound = false;
        for (int i = 0; i < dataMatrix.length; i++) {
            for (int j = 0; j < dataMatrix[i].length; j++) {
                if ((j == rmv || columnFound) && j != dataMatrix[i].length - 1) {
                    dataMatrix[i][j] = dataMatrix[i][j + 1];
                    columnFound = true;
                }
            }
            columnFound = false;
        }
        for (int i = 0; i < dataMatrix.length; i++) {
            for (int j = 0; j < dataMatrix[i].length; j++) {
                if ((i == rmv || rowFound) && i != dataMatrix[i].length - 1) {
                    dataMatrix[i][j] = dataMatrix[i + 1][j];
                    rowFound = true;
                }
            }

        }

        for (int i = 0; i < updateMatrix.length; i++) {
            for (int j = 0; j < updateMatrix[i].length; j++) {
                updateMatrix[i][j] = dataMatrix[i][j];
            }

        }
        return updateMatrix;
    }

    public static void displayMatrix(double[][] dataMatrix) {
        System.out.println("Display matrix");
        for (int i = 0; i < dataMatrix.length; i++) {
            for (int j = 0; j < dataMatrix[i].length; j++) {
                System.out.print(dataMatrix[i][j] + "\t");
            }
            System.out.println("");
        }
    }

}
