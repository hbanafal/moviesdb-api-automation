package com.moviesdb.api.automation.actionsImpl;

import com.moviesdb.api.automation.actions.MovieItemActions;
import com.moviesdb.api.automation.models.Request.AddMediaItemRequest;
import com.moviesdb.api.automation.utilities.APIFunctions;

import io.restassured.response.Response;

public class MovieItemActionsImpl implements MovieItemActions {

    @Override
    public Response addNewMovie(AddMediaItemRequest postMovieRequest, int list_id) {
        return APIFunctions.postRequest(postMovieRequest, "list/" + list_id + "/items");
    }

    @Override
    public Response updateMovie(AddMediaItemRequest postMovieRequest) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response deleteMovie(AddMediaItemRequest postMovieRequest, int list_id) {
        return APIFunctions.deleteRequest(postMovieRequest, "list/" + list_id + "/items");
    }
}
