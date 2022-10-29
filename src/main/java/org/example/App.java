package org.example;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.*;
import java.net.http.HttpRequest.*;

/**
 * Hello world!
 */
public class App {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";


    public static void main(String[] args) throws IOException, InterruptedException {
    //создали HTTP request

        HttpResponse responseGet =  sendGetRequest();
        System.out.println(responseGet.body());

//        HttpResponse responsePost =  sendPostRequest();
//        System.out.println(responsePost.body());
//        System.out.println(responsePost.statusCode());

    }


    private static HttpResponse sendGetRequest() throws IOException, InterruptedException {

        final String GET_URL = BASE_URL + "/posts";

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(GET_URL))
                .build();

        //создали HTTP клиента
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        //получили ответ HTTP клиента
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        return response;
    }

    private static HttpResponse sendPostRequest() throws IOException, InterruptedException {

        final String POST_URL = BASE_URL + "/posts";

        Post post = new Post();
        post.setUserId(1);
        post.setId(10);
        post.setTitle("Title");
        post.setBody("Body description");

        //System.out.println(post.toString());

        JSONObject jsonObject = new JSONObject(post);


        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString()))
                .uri(URI.create(POST_URL))
                .headers("Content-Type","application/json")
                .build();

        //создали HTTP клиента
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        //получили ответ HTTP клиента
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        return response;

    }
}
