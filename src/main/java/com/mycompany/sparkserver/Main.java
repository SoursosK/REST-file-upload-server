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
import spark.Route;

public class Main {

    String kappa = "keepo";

    public Main() {
        get("/users/:id", "application/json", (Request request, Response response) -> kappa);

        post("/users", (Request request, Response response) -> {
            String username = request.body();//.queryParams("username");
            String username1 = request.params("");
            String email = request.queryParams("email");

//                System.out.println(username1);
            kappa = username + " " + email;

            response.status(201); // 201 Created
            //response.body("hiiii");
            return kappa;
            //return null;
        });

        post("/file", (request, response) -> {
            request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));

            for (int i = 0; i < 2; i++) {
                try (InputStream input = request.raw().getPart("uploaded_file" + i).getInputStream()) {
                    Files.copy(input, Paths.get(System.getProperty("user.home") + "/Desktop/" + "arxeio" + i + ".txt"), StandardCopyOption.REPLACE_EXISTING);
                }
            }

            return "File uploaded";
        });

    }

    public static void main(String[] args) {
        Main a = new Main();
    }
}
