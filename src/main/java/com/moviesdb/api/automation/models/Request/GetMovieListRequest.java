package com.moviesdb.api.automation.models.Request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Builder;

@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GetMovieListRequest {
    private int list_id;
}
