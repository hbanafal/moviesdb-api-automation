package com.moviesdb.api.automation.actionsImpl;

import com.moviesdb.api.automation.actions.MovieListActions;
import com.moviesdb.api.automation.models.Request.CreateMovieListRequest;
import com.moviesdb.api.automation.models.Request.UpdateMovieListRequest;
import com.moviesdb.api.automation.utilities.APIFunctions;

import io.restassured.response.Response;

public class MovieListActionsImpl implements MovieListActions {

    @Override
    public Response getMoviesList(int list_id) {
        return APIFunctions.getRequest("list/" + list_id);
    }

    @Override
    public Response createMovieList(CreateMovieListRequest postMovieListRequest) {
        return APIFunctions.postRequest(postMovieListRequest, "list");
    }

    @Override
    public Response updateMovieList(UpdateMovieListRequest updateMovieListRequest, int list_id) {
        return APIFunctions.updateRequest(updateMovieListRequest, "list/" + list_id);
    }

    @Override
    public Response clearMoviesList(int list_id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response deleteMoviesList(int list_id) {
        return APIFunctions.deleteRequest("list/" + list_id);
    }
}
