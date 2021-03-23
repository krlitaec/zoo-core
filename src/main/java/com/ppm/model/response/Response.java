package com.ppm.model.response;

import java.sql.Timestamp;
import java.time.Instant;

public class Response {
    //Atributes
    private Timestamp timestamp;
    private String data;
    private int responseCode;
    private String status;

    public Response() {
    }

    public Response( String data, int responseCode, String status) {
        this.timestamp = Timestamp.from(Instant.now());
        this.data = data;
        this.responseCode = responseCode;
        this.status = status;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}