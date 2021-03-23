package com.ppm.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenReponse {
    private String accessToken;
    private String type = "Bearer";

    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
