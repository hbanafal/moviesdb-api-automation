package com.moviesdb.api.automation.models.Response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@AllArgsConstructor
@NoArgsConstructor
public class AddMediaItemResponse {

    private String status_message;
    private List<Object> results;
    private boolean success;
    private int status_code;

}
