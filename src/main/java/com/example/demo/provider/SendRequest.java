package com.example.demo.provider;

import com.jsunsoft.http.HttpRequest;
import com.jsunsoft.http.HttpRequestBuilder;
import com.jsunsoft.http.ResponseDeserializer;
import com.jsunsoft.http.ResponseHandler;

public class SendRequest {
//    public static void main(String[] args) {
//        send();
//    }
    public static String send(String url){
        String uri = url;

        HttpRequest<String> httpRequest = HttpRequestBuilder.createGet(uri, String.class)
                .responseDeserializer(ResponseDeserializer.ignorableDeserializer()).build();
        ResponseHandler<String> response = httpRequest.execute();
        System.out.println(response.getStatusCode());
        System.out.println(response.get());
        return response.get();
    }

//    public static String sendPost(String url, String data){
//        String uri = url;
//
//        HttpRequest<String> httpRequest = HttpRequestBuilder.createPost(uri, String.class).dateDeserializeContext()
//                .responseDeserializer(ResponseDeserializer.ignorableDeserializer()).build();
//        ResponseHandler<String> response = httpRequest.execute();
//        System.out.println(response.getStatusCode());
//        System.out.println(response.get());
//        return response.get();
//    }
}
