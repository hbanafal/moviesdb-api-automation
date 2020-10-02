package com.moviesdb.api.automation.tests;

import java.util.UUID;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.moviesdb.api.automation.steps.MovieListActionSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MoviesListTests {

    @Steps
    MovieListActionSteps moviesList;

    @Test()
    @Title("Verify Create List Action")
    public void test1CreateList() {
        moviesList.userIsHavingDetailsToCreateNewMovieList("My first list", "en", "This is description", true);
        moviesList.userCreateNewMovieList();
        moviesList.userShouldSuccessfullyCreateMovieList();
    }

    @Test
    @Title("Verify Get List Action")
    public void test2GetList() {
        moviesList.userGetMovieListUsingId(null);
        moviesList.userShouldGetMovieListAndValidateResponseBody("My first list");
    }

    @Test
    @Title("Verify Get List with Error Action")
    public void test2GetListWithError() {
        moviesList.userGetMovieListUsingId(1234567123);
        moviesList.userShouldGetStatusCodeAndValidateResponseBodyFieldsWithError();
    }

    @Test
    @Title("Verify Update List Action")
    public void test3UpdateList() {
        String newDescription = "This is new description" + UUID.randomUUID().toString();
        moviesList.userUpdatesMovieListDescription(newDescription);
        moviesList.userShouldValidateUpdateResponseBody(newDescription);
    }

    @Test
    @Title("Verify Delete List Action")
    public void test4DeleteList() {
        moviesList.userDeleteMovieList();
        moviesList.userShouldValidateDeleteResponse();
    }

}
