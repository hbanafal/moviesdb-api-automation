package com.moviesdb.api.automation.steps;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import com.moviesdb.api.automation.actions.MovieListActions;
import com.moviesdb.api.automation.actionsImpl.MovieListActionsImpl;
import com.moviesdb.api.automation.models.Request.CreateMovieListRequest;
import com.moviesdb.api.automation.models.Request.UpdateMovieListRequest;
import com.moviesdb.api.automation.models.Response.CreateMovieListResponse;
import com.moviesdb.api.automation.models.Response.ErrorResponse;
import com.moviesdb.api.automation.models.Response.GetMovieListResponse;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.model.TestStep;

public class MovieListActionSteps extends TestStep {

    CreateMovieListRequest createMovieListRequest;
    MovieListActions movieListActions;
    Response response;
    ErrorResponse errorResponse;
    CreateMovieListResponse createMovieListResponse;
    GetMovieListResponse getMovieListResponse;
    public static int id;

    @Step
    public void userIsHavingDetailsToCreateNewMovieList(String name, String iso_639_1, String description,
            boolean public_status) {
        createMovieListRequest = CreateMovieListRequest.builder().name(name).iso_639_1(iso_639_1)
                .description(description).build();
    }

    @Step
    public void userCreateNewMovieList() {
        movieListActions = new MovieListActionsImpl();
        response = movieListActions.createMovieList(createMovieListRequest);
    }

    @Step
    public void userShouldGetStatusCodeAndValidateResponseBodyFieldsWithError() {
        errorResponse = response.getBody().as(ErrorResponse.class);

        SoftAssertions softAssertion = new SoftAssertions();
        softAssertion.assertThat(response.getStatusCode()).as("Error reponse code is not correct").isEqualTo(404);
        softAssertion.assertThat(errorResponse.getStatus_code()).as("Error Status code is not correct").isEqualTo("34");
        softAssertion.assertThat(errorResponse.getStatus_message()).as("Error Success message is not correct")
                .isEqualTo("The resource you requested could not be found.");
        softAssertion.assertThat(errorResponse.isSuccess()).as("Error Success status is not false").isEqualTo(false);
        softAssertion.assertAll();
    }

    @Step
    public void userShouldSuccessfullyCreateMovieList() {
        Assert.assertEquals(201, response.getStatusCode());
        createMovieListResponse = response.getBody().as(CreateMovieListResponse.class);
        id = createMovieListResponse.getId();
        SoftAssertions softAssertion = new SoftAssertions();
        softAssertion.assertThat(createMovieListResponse.getStatus_message())
                .as("Status message is not correct in  Create List response")
                .isEqualTo("The item/record was created successfully.");
        softAssertion.assertThat(createMovieListResponse.getStatus_code())
                .as("Status code is not correct in  Create List response").isEqualTo(1);
        softAssertion.assertThat(createMovieListResponse.isSuccess())
                .as("Success status is not true in  Create List response").isEqualTo(true);
        softAssertion.assertAll();
    }

    @Step
    public void userGetMovieListUsingId(Integer listId) {
        movieListActions = new MovieListActionsImpl();
        if (listId == null)
            listId = id;
        response = movieListActions.getMoviesList(listId);
    }

    @Step
    public void userShouldGetMovieListAndValidateResponseBody(String name) {
        getMovieListResponse = response.getBody().as(GetMovieListResponse.class);
        SoftAssertions softAssertion = new SoftAssertions();
        softAssertion.assertThat(response.getStatusCode()).as("Reposne code is not correct in  Get List response")
                .isEqualTo(200);
        softAssertion.assertThat(getMovieListResponse.getName()).as("Correct list is not fetched Get List response")
                .isEqualTo(name);
        softAssertion.assertAll();

    }

    @Step
    public void userUpdatesMovieListDescription(String description) {
        movieListActions = new MovieListActionsImpl();
        UpdateMovieListRequest patchMovieListRequest = UpdateMovieListRequest.builder().description(description)
                .build();
        response = movieListActions.updateMovieList(patchMovieListRequest, id);
    }

    @Step
    public void userShouldValidateUpdateResponseBody(String newDescription) {
        SoftAssertions softAssertion = new SoftAssertions();
        softAssertion.assertThat(response.getStatusCode()).as("Reposne code is not correct in  Update List response")
                .isEqualTo(201);
        softAssertion.assertThat(response.jsonPath().getString("status_message"))
                .as("Status message is not correct in  Update List response")
                .isEqualTo("The item/record was updated successfully.");
        softAssertion.assertThat(response.jsonPath().getString("status_code"))
                .as("Status code is not correct in  Update List response").isEqualTo("12");

        softAssertion
                .assertThat(
                        movieListActions.getMoviesList(id).getBody().as(GetMovieListResponse.class).getDescription())
                .as("Description is not updated successfully").isEqualTo(newDescription);

        softAssertion.assertAll();
    }

    @Step
    public void userDeleteMovieList() {
        movieListActions = new MovieListActionsImpl();
        response = movieListActions.deleteMoviesList(id);
    }

    @Step
    public void userShouldValidateDeleteResponse() {
        SoftAssertions softAssertion = new SoftAssertions();
        softAssertion.assertThat(response.getStatusCode()).as("Reposne code is not correct in  Update List response")
                .isEqualTo(200);
        softAssertion.assertThat(response.jsonPath().getString("status_message"))
                .as("Status message is not correct in  Delete List response")
                .isEqualTo("The item/record was deleted successfully.");
        softAssertion.assertThat(response.jsonPath().getString("status_code"))
                .as("Status code is not correct in  Delete List response").isEqualTo("13");
        softAssertion.assertAll();
    }

}
