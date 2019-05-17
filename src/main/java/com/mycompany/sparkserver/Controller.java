package com.mycompany.sparkserver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.MultipartConfigElement;
import static spark.Spark.get;
import static spark.Spark.post;

import spark.Request;
import spark.Response;

public class Controller {
    private final Model model;
    private final csvManager csvManager;
    
    public Controller() {
        this.model = new Model();
        this.csvManager = new csvManager(this.model.getStatement());
        
        Routing();
    }
    
    private void Routing() {
        get("/:name", "application/json", (Request request, Response response) -> "");
        
        post("/file", (request, response) -> {
            request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            
            String authType = request.queryParams("authType");
            String fileName = request.queryParams("fileName");
//            System.out.println(authType);
//            System.out.println(fileName);
            
            String filePath = System.getProperty("user.home") + "/Desktop/aa/" + fileName;
            try (InputStream input = request.raw().getPart("uploaded_file").getInputStream()) {
                Files.copy(input, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            }
            
            this.csvManager.storeFile(authType, fileName, filePath);

            return "File uploaded";
        });
        
    }
    
    

    public static void main(String[] args) {
        Controller c = new Controller();
    }
}
