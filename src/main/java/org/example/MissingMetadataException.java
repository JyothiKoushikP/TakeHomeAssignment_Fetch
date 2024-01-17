package org.example;

/* Exception to handle if HttpRequests is missing Name or URL (Required fields) */
public class MissingMetadataException extends RuntimeException {
    public MissingMetadataException(String message) {
        super(message);
    }
}
