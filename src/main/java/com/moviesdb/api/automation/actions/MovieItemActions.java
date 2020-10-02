package com.moviesdb.api.automation.actions;

import com.moviesdb.api.automation.models.Request.AddMediaItemRequest;

import io.restassured.response.Response;

public interface MovieItemActions {

    Response addNewMovie(AddMediaItemRequest postMovieRequest, int list_id);

    Response updateMovie(AddMediaItemRequest postMovieRequest);

    Response deleteMovie(AddMediaItemRequest postMovieRequest, int list_id);
}
