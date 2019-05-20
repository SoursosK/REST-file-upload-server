
package com.mycompany.sparkserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model {
    private Connection conn = null;
    private Statement stm = null;
    
    public Model(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + "sparkDB.db");
            
            stm = conn.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Statement getStatement() {
        return stm;
    }
    
    
    //Execute SQL queries 
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + "sparkDB.db");
        Statement stm = conn.createStatement();
//        stm.executeUpdate("delete from colorsmetadata;");
                
//        ResultSet res = stm.executeQuery("select * from colorsmetadata");
//        while(res.next())
//            System.out.println(res.getString("username"));
        
        
        //piano/////
//        stm.executeUpdate("create table colorspairs (id integer primary key autoincrement, "
//                + "username string, attempt_number string, screen_resolution string, "
//                + "pattern_number_a string, pattern_number_b string, "
//                + "xcoord_of_central_point_of_a string, ycoord_of_central_point_of_a string, "
//                + "xcoord_of_central_point_of_b string, ycoord_of_central_point_of_b string, "
//                + "first_xcoord_of_a string, first_ycoord_of_a string, "
//                + "last_xcoord_of_a string, last_ycoord_of_a string, "
//                + "distance_ab string, intertime_ab string, avg_speedab string, "
//                + "avg_pressure string);");
        
        //auto prepei na parw to username apo title
//        stm.executeUpdate("create table pianoraw (id integer primary key autoincrement, "
//                + "username string, number_of_activated_point string, xpoint string, "
//                + "ypoint string, timestamp string, pressure string);");
        
//        stm.executeUpdate("create table pianotouch (id integer primary key autoincrement, "
//                + "username string, attempt_number string, sequence string, "
//                + "hold_duration1 string, hold_duration2 string, hold_duration3 string, "
//                + "hold_duration4 string);");
        
//        stm.executeUpdate("create table pianometadata (id integer primary key autoincrement, "
//                + "username string, attempt_number string, sequence string, seq_length string, "
//                + "time_to_complete string, patternlength string, avg_speed string, "
//                + "highest_pressure string, lowest_pressure string, handnum string, "
//                + "fingernum string);");
        
        //colors////
//        stm.executeUpdate("create table colorspairs (id integer primary key autoincrement, "
//                + "username string, attempt_number string, screen_resolution string, "
//                + "pattern_number_a string, pattern_number_b string, "
//                + "xcoord_of_central_point_of_a string, ycoord_of_central_point_of_a string, "
//                + "xcoord_of_central_point_of_b string, ycoord_of_central_point_of_b string, "
//                + "first_xcoord_of_a string, first_ycoord_of_a string, "
//                + "last_xcoord_of_a string, last_ycoord_of_a string, "
//                + "distance_ab string, intertime_ab string, avg_speedab string, "
//                + "avg_pressure string);");
        
        //auto prepei na parw to username apo title
//        stm.executeUpdate("create table colorsraw (id integer primary key autoincrement, "
//                + "username string, number_of_activated_point string, xpoint string, "
//                + "ypoint string, timestamp string, pressure string);");
        
//        stm.executeUpdate("create table colorstouch (id integer primary key autoincrement, "
//                + "username string, attempt_number string, sequence string, "
//                + "hold_duration1 string, hold_duration2 string, hold_duration3 string, "
//                + "hold_duration4 string);");
        
//        stm.executeUpdate("create table colorsmetadata (id integer primary key autoincrement, "
//                + "username string, attempt_number string, sequence string, seq_length string, "
//                + "time_to_complete string, patternlength string, avg_speed string, "
//                + "highest_pressure string, lowest_pressure string, handnum string, "
//                + "fingernum string);");
        
        conn.close();
    }   
}


        