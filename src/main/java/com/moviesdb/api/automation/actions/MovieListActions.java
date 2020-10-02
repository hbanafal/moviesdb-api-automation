package com.moviesdb.api.automation.actions;

import com.moviesdb.api.automation.models.Request.CreateMovieListRequest;
import com.moviesdb.api.automation.models.Request.UpdateMovieListRequest;

import io.restassured.response.Response;

public interface MovieListActions {

    Response getMoviesList(int list_id);

    Response createMovieList(CreateMovieListRequest postMovieListRequest);

    Response updateMovieList(UpdateMovieListRequest updateMovieListRequest, int list_id);

    Response clearMoviesList(int list_id);

    Response deleteMoviesList(int list_id);
}
