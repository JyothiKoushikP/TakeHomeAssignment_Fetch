package org.example;

/* A Class used to define the testResult of an Endpoint (with Domain name and isUp Boolean) */
public class ResponseResult {
    private final String domain;
    private final boolean up; /* Boolean Value, set to False but if the response satisfies, it is true */

    public ResponseResult(String domain, boolean up) {
        this.domain = domain;
        this.up = up;
    }

    public String getDomain() {
        return domain;
    }

    public boolean isUp() {
        return up;
    }
}