package com.moviesdb.api.automation.models.Response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieListResponse {

    private String status_message;
    private int id;
    private boolean success;
    private int status_code;

}
