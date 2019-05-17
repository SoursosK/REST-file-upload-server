package com.mycompany.sparkserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class csvManager {

    private final Statement stm;

    public csvManager(Statement stm) {
        this.stm = stm;
    }

    public static void main(String[] args) {
        csvManager a = new csvManager(null);
        //a.storeFile("piano", "username_01_raw.csv");
        //a.storeFile("piano", "username_metadata.csv");
    }
            
    public void storeFile(String authType, String fileName, String filePath) {
        String[] parts = fileName.split("_");
        for(String a: parts)
            System.out.println(a);
        
        if (parts.length == 2) {
            
            if (authType.equals("piano"))
                this.pianoMetadata(filePath);
            else if (authType.equals("colors"))
                this.colorsMetadata(filePath);

        } else {
            if (parts[2].equals("raw.csv")) {
       
                if (authType.equals("piano")) 
                    this.pianoRaw(parts[0], filePath);
                else if (authType.equals("colors")) 
                    this.colorsRaw(parts[0], filePath);
                
            } else if (parts[2].equals("pairs.csv")) {
                
                if (authType.equals("piano")) 
                    this.pianoPairs(filePath);
                else if (authType.equals("colors")) 
                    this.colorsPairs(filePath);
                
            } else if (parts[2].equals("touch.csv")) {
                
                if (authType.equals("piano")) 
                    this.pianoTouch(filePath);
                else if (authType.equals("colors")) 
                    this.colorsTouch(filePath);
                
            } 
        }
    }

    private void pianoRaw(String username, String filePath) {
        try(
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ){
            for (CSVRecord csvRecord : csvParser) {
                if(csvRecord.getRecordNumber() == 1)
                    continue;

                stm.executeUpdate("insert into pianoraw (username, number_of_activated_point, "
                        + "xpoint, ypoint, timestamp, pressure) values ('" + username 
                        +"', '" + csvRecord.get(0) +"', '" + csvRecord.get(1) +"', '" + csvRecord.get(2) 
                        +"', '" + csvRecord.get(3) +"', '" + csvRecord.get(4) +"');");
            }
        } catch (IOException ex) {
            Logger.getLogger(csvManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(csvManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pianoPairs(String filePath) {
        try(
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ){
            for (CSVRecord csvRecord : csvParser) {
                if(csvRecord.getRecordNumber() == 1)
                    continue;

                stm.executeUpdate("insert into pianoraw (username,attempt_number, screen_resolution, pattern_number_a, pattern_number_b, xcoord_of_central_point_of_a, ycoord_of_central_point_of_a, xcoord_of_central_point_of_b, ycoord_of_central_point_of_b, distance_ab, intertime_ab, avg_speedab, avg_pressure) values ('" + csvRecord.get(0) + "', '" + csvRecord.get(1) + "','" + csvRecord.get(2) + "','" + csvRecord.get(3) + "','" + csvRecord.get(4) + "','" + csvRecord.get(5) + "','" + csvRecord.get(6) + "','" + csvRecord.get(7) + "','" + csvRecord.get(8) + "','" + csvRecord.get(9) + "','" + csvRecord.get(10) + "','" + csvRecord.get(11) + "','" + csvRecord.get(12) + "');");
            }
        } catch (IOException ex) {
            Logger.getLogger(csvManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(csvManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pianoTouch(String filePath) {

    }

    private void pianoMetadata(String filePath) {
        
    }

    private void colorsRaw(String username, String filePath) {
        try(
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ){
            for (CSVRecord csvRecord : csvParser) {
                if(csvRecord.getRecordNumber() == 1)
                    continue;

                stm.executeUpdate("insert into pianoraw (username, number_of_activated_point, "
                        + "xpoint, ypoint, timestamp, pressure) values ('" + username 
                        +"', '" + csvRecord.get(0) +"', '" + csvRecord.get(1) +"', '" + csvRecord.get(2) 
                        +"', '" + csvRecord.get(3) +"', '" + csvRecord.get(4) +"');");
            }
        } catch (IOException ex) {
            Logger.getLogger(csvManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(csvManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void colorsPairs(String filePath) {

    }

    private void colorsTouch(String filePath) {

    }

    private void colorsMetadata(String filePath) {

    }

}
