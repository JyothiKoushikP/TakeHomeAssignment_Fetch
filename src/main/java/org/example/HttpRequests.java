package org.example;
import java.util.HashMap;
import java.util.Map;

/* This Class is Defined to support a neater way of programming the requests with a fixed Schema */
/* According to the structure given , the HttpRequests class takes the object , default values are invoked if the optional fields are missing */
public class HttpRequests {
    /* All Parameters are declared private for security purpose, however can be modified using getter and setter methods below */
    private Map<String, String> headers;
    private String method;
    private String name;
    private String url;
    private String body;

    public HttpRequests(){}

    /* Parameterized Constructor */
    public HttpRequests(Map<String,String> headers,String method,String name,String url,String body) {
        this.headers = headers;
        this.method = method;
        this.name = name;
        this.url = url;
        this.body = body;
    }


    /* Getter Methods */
    public String getName() {
        return name;
    }
    public String getUrl(){
        return url;
    }
    public String getMethod(){
        return method != null ? method : "GET";
    }
    public Map<String,String> getHeaders(){
        return headers != null ? headers : new HashMap<>();
    }
    public String getBody() {
        return body != null ? body: "";
    }

    /* Setter Methods */
    public void setName(String endPointName){
        this.name = endPointName;
    }
    public void setUrl(String requestURL){
        this.url = requestURL;
    }
    public void setMethod(String method){
        this.method = method;
    }
    public void setHeaders(Map<String,String> requestHeaders){
        this.headers = requestHeaders;
    }
    public void setBody(String requestBody){
        this.body = requestBody;
    }

    /* Function to invoke print contents for a HttpRequest Object */
    public void printRequestContents() {
        System.out.println("***************************");
        System.out.println("RequestUrl: " + this.getUrl());
        System.out.println("RequestHeaders: " + this.getHeaders());
        System.out.println("RequestEndpointName: " + this.getName());
        System.out.println("RequestMethod: " + this.getMethod());
        System.out.println("RequestBody: " + this.getBody());
        System.out.println("***************************");
        System.out.println();
    }

}

