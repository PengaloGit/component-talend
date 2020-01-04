package com.company.talend.components.service;



import com.company.talend.components.processor.Error;
import okhttp3.*;

import java.io.IOException;

public class Http {

    private final OkHttpClient httpClient = new OkHttpClient();
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private  String URL;

    public Http(String URL) {
        this.URL = URL;
    }

    public void sendPost(Error error) throws Exception {
        String json = jsonBuilder(error);
        RequestBody body = RequestBody.create(json,JSON);

        Request request = new Request.Builder()
                .url(URL)
                .post(body)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        }

    }

    private String jsonBuilder(Error error){
        return "{" +
                "'File' : " + error.getFileName() + "," +
                "'Row' : " + error.getRow() + "," +
                "'Error' : " + error.getWorkflowError() +
                "'Exception' : " + error.getRuntimeError() + "," +
                "}" ;
    }

}
