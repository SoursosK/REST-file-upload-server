
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
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + "sparkDB.db");
        Statement stm = conn.createStatement();
        //stm.executeUpdate("drop table colorspairs;");
        
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
//                + "username string, attempt_number string, seq_length string, "
//                + "time_to_complete string, patternlength string, avg_speed string, "
//                + "highest_pressure string, lowest_pressure string, handnum string, "
//                + "fingernum string);");
        
        //colors////
//        stm.executeUpdate("create table colorspairs (id integer primary key autoincrement, "
//                + "username string, attempt_number string, screen_resolution string, "
//                + "pattern_number_a string, pattern_number_b string, "
//                + "xcoord_of_central_point_of_a string, ycoord_of_central_point_of_a string, "
//                + "xcoord_of_central_point_of_b string, ycoord_of_central_point_of_b string, "
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
//                + "username string, attempt_number string, seq_length string, "
//                + "time_to_complete string, patternlength string, avg_speed string, "
//                + "highest_pressure string, lowest_pressure string, handnum string, "
//                + "fingernum string);");


//        stm.executeUpdate("create table test (id integer primary key autoincrement, "
//                + "username string, test string);");


//        stm.executeUpdate("insert into test (username, test) values ('kostas2', 'my test2');");
//        ResultSet res = stm.executeQuery(" SELECT * FROM test WHERE username = 'kostas'; ");
//
//        while(res.next()){
//            System.out.println(res.getString("username") + " " + res.getString("test"));
//        }
//        
//        stm.executeUpdate("insert into test (username, test) values ('kostas3', 'my test3');");
        
//      stm.executeUpdate("create table users (id integer primary key autoincrement, name string, surname string, username string , birthday string, gender string, description string, country string, town string);");

//      stm.executeUpdate("create table friends (id integer primary key autoincrement, username text, friend text);");
      
//      stm.executeUpdate("create table posts (id integer primary key autoincrement, owner text, creator text, content string);");
//      
//      stm.executeUpdate("insert into users (name, surname , username, birthday, gender, description,country,town) values ('george', 'giorgou' ,'george100', '9-10-98', 'male', 'gamaw', 'greece', 'karlovasi');");
//      
//      stm.executeUpdate("insert into users (name, surname , username, birthday, gender, description, country, town) values ('kostas', 'soursos' ,'kostas100', '10-10-98', 'male', 'gamawyeah', 'england', 'london');");
//
//      stm.executeUpdate("insert into friends (username, friend) values ('maraki100', 'nikos100');");
//
//      stm.executeUpdate("insert into posts (owner, creator, content) values ('kostas100', 'kostas100', 'sou aresoun ta mpiskota?');");

//      stm.executeUpdate("alter table users add password string");

    //stm.executeUpdate(" UPDATE users SET password = '123456' WHERE username = 'kostas100'; ");

//        ResultSet res = stm.executeQuery("SELECT * FROM users");
//
//        while(res.next()){
//                System.out.println("ID : " + res.getInt("id"));
//                System.out.println("UserName : " + res.getString("username"));
//                System.out.println("Name : " + res.getString("name"));
//                System.out.println("Password : " + res.getString("password"));
//                System.out.println("Description : " + res.getString("description"));
//
//                System.out.println("-----------------------------");
//        }
//        
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
//        
//        res = stm.executeQuery("SELECT * FROM friends");
//        //res = stm.executeQuery("SELECT * FROM friends WHERE username = 'maraki100' AND friend = 'nikos100'; ");        
//
//        while(res.next()){
//                System.out.println("ID : " + res.getInt("id"));
//                System.out.println("username : " + res.getString("username"));
//                System.out.println("friend : " + res.getString("friend"));
//
//                System.out.println("-----------------------------");
//        }
//
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
//        
//        res = stm.executeQuery("SELECT * FROM posts");
//
//        while(res.next()){
//                System.out.println("ID : " + res.getInt("id"));
//                System.out.println("owner : " + res.getString("owner"));
//                System.out.println("creator : " + res.getString("creator"));
//                System.out.println("content : " + res.getString("content"));
//
//                System.out.println("-----------------------------");
//        }
        

        conn.close();
    }
    
    
    
}
