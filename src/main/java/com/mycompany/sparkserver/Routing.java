package com.mycompany.sparkserver;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.MultipartConfigElement;
import static spark.Spark.get;
import static spark.Spark.post;

import spark.Request;
import spark.Response;

public class Routing {
    private final Model model;
    private final Controller controller;
    
    public Routing() {
        this.model= new Model();
        this.controller = new Controller(this.model.getStatement());
        
        Routes();
    }
    
    private void Routes() {
        get("/results", (Request request, Response response) -> {
            String results = this.controller.exportStatistics(request.queryParams("authType"), request.queryParams("username")); 
            System.out.println(results);
            if(results == null){
                response.status(500);
                return "error";
            } else
                return results;            
        });
        
        post("/file", (request, response) -> {
            try{
            request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            
            String authType = request.queryParams("authType");
            String fileName = request.queryParams("fileName");            
            String uploaded_file = request.queryParams("uploaded_file");

            System.out.println("----");
            System.out.println(fileName);
            System.out.println(authType);
            
            //String filePath = System.getProperty("user.home") + "/Desktop/aa/" + fileName;
            String filePath = "./aa/" + fileName;
            try (InputStream input = request.raw().getPart("uploaded_file").getInputStream()) {
                Files.copy(input, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            }
            
            this.controller.storeFile(authType, fileName, filePath);
            }
            catch(Exception e){
                System.out.println(e.toString());
            }

            return "File uploaded";
        });
        
    }
    
    

    public static void main(String[] args) {
        Routing r = new Routing();
    }
}
