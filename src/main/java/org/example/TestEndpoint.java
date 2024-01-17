package org.example;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* Class for testing Endpoint */
public class TestEndpoint {

    /* HttpClient Object for Request calls */
    private static final HttpClient httpClient = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build();

    public static List<String> formatHeaders(Map<String, String> headers) {
        List<String> headerList = new ArrayList<>();
        if(headers.isEmpty()) return headerList;
        for(String key: headers.keySet()) {
            headerList.add(key);
            headerList.add(headers.get(key));
        }
        return headerList;
    }

    static ResponseResult testEndpoint(HttpRequests request) {
        long startTime, endTime;
        Map<String,String> headers = request.getHeaders();
        String method = request.getMethod();
        String requestBody = request.getBody();

        List<String> headerList = formatHeaders(headers);

        if(request.getUrl() == null || request.getName() == null) {
            System.out.println("HttpRequest doesn't contain required parameters...exiting");
            return new ResponseResult("ERROR", false);
        }

        URI uri = URI.create(request.getUrl());
        String name = request.getName();

        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(uri);

        if(!headerList.isEmpty()) {
            requestBuilder.headers(headerList.toArray(String[]::new));
        }

        /* Add RequestBody for POST Method */
        if(method.equals("POST")) {
            requestBuilder.POST(HttpRequest.BodyPublishers.ofString(requestBody));
        } else {
            requestBuilder.GET();
        }

        startTime = System.currentTimeMillis();

        HttpRequest httpRequest = requestBuilder.build();
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            endTime = System.currentTimeMillis();
            int statusCode = response.statusCode();
            /* Condition for UP and DOWN */
            boolean isUp = statusCode >= 200 && statusCode < 300 && (endTime - startTime) < 500;

            return new ResponseResult(uri.getHost(), isUp);
        } catch (Exception e) {
            LoggerInfo.logError("Error during HTTP request to " + request.getUrl(), e);
            return new ResponseResult(uri.getHost(), false);
        }
    }

}
