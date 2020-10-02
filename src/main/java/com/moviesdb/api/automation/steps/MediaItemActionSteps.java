package com.moviesdb.api.automation.steps;

import java.util.List;

import org.assertj.core.api.SoftAssertions;

import com.moviesdb.api.automation.actions.MovieItemActions;
import com.moviesdb.api.automation.actionsImpl.MovieItemActionsImpl;
import com.moviesdb.api.automation.models.Request.AddMediaItemRequest;
import com.moviesdb.api.automation.models.Request.MediaItemRequest;
import com.moviesdb.api.automation.models.Response.AddMediaItemResponse;
import com.moviesdb.api.automation.models.Response.GetMovieListResponse;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.model.TestStep;

public class MediaItemActionSteps extends TestStep {

    AddMediaItemRequest addMediaItemReq;
    AddMediaItemResponse addMediaItemRes;
    GetMovieListResponse getMovieListRes;
    MovieItemActions movieItemActions;
    MovieListActionSteps movieListAction;
    Response response;

    @Step
    public void userIsHavingNewMediaItemToAdd(List<MediaItemRequest> mediaItems) {
        addMediaItemReq = AddMediaItemRequest.builder().items(mediaItems).build();
    }

    @Step
    public void userAddNewMediaItem() {
        movieItemActions = new MovieItemActionsImpl();
        response = movieItemActions.addNewMovie(addMediaItemReq, MovieListActionSteps.id);
    }

    @Step
    public void userShouldSuccessfullyAddMediaItem() {
        addMediaItemRes = response.getBody().as(AddMediaItemResponse.class);
        SoftAssertions softAssertion = new SoftAssertions();
        softAssertion.assertThat(addMediaItemRes.getStatus_message()).as("Status message is not correct for Add Item")
                .isEqualTo("Success.");
        softAssertion.assertThat(addMediaItemRes.getStatus_code()).as("Status code is not correct for Add Item")
                .isEqualTo(1);
        softAssertion.assertThat(addMediaItemRes.isSuccess()).as("Success is not true for Add Item").isEqualTo(true);

        softAssertion.assertAll();
    }

    @Step
    public void userDeleteMediaItem(List<MediaItemRequest> mediaItems) {
        movieItemActions = new MovieItemActionsImpl();
        addMediaItemReq = AddMediaItemRequest.builder().items(mediaItems).build();
        response = movieItemActions.deleteMovie(addMediaItemReq, MovieListActionSteps.id);
    }

    @Step
    public void userShouldSuccessfullyDeleteMediaItem() {
        SoftAssertions softAssertion = new SoftAssertions();
        softAssertion.assertThat(response.jsonPath().getString("status_message"))
                .as("Status message is not correct for Delete Item").isEqualTo("Success.");
        softAssertion.assertThat(response.jsonPath().getString("status_code"))
                .as("Status code is not correct for Delete Item").isEqualTo("1");
        softAssertion.assertThat(response.getStatusCode()).as("HTTP response status code is not correct")
                .isEqualTo(200);
        softAssertion.assertAll();
    }

}
