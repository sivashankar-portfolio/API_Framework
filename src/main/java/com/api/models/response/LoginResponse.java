package com.api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record LoginResponse(

        String token,
        String type,
        String username,
        String email,
        List<String> roles,
        int id
) {
}
