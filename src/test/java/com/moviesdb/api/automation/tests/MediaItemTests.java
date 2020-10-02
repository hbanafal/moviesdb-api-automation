package com.moviesdb.api.automation.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.moviesdb.api.automation.models.Request.MediaItemRequest;
import com.moviesdb.api.automation.steps.MediaItemActionSteps;
import com.moviesdb.api.automation.steps.MovieListActionSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MediaItemTests {

    @Steps
    MovieListActionSteps moviesListAction;

    @Steps
    MediaItemActionSteps movieItemAction;

    static List<MediaItemRequest> mediaItems = new ArrayList<>();

    @BeforeClass
    public static void createList() {
        MovieListActionSteps moviesListAction = new MovieListActionSteps();
        moviesListAction.userIsHavingDetailsToCreateNewMovieList("My first list", "en", "This is description", true);
        moviesListAction.userCreateNewMovieList();
        moviesListAction.userShouldSuccessfullyCreateMovieList();
        mediaItems.add(new MediaItemRequest("movie", "550"));
    }

    @Test
    @Title("Verify Add media item in the list.")
    public void test1AddMovieInList() {
        movieItemAction.userIsHavingNewMediaItemToAdd(mediaItems);
        movieItemAction.userAddNewMediaItem();
        movieItemAction.userShouldSuccessfullyAddMediaItem();
    }

    @Test
    @Title("Verify Delete movie item in the list.")
    public void test2DeleteMovieInList() {
        movieItemAction.userDeleteMediaItem(mediaItems);
        movieItemAction.userShouldSuccessfullyDeleteMediaItem();
    }

    @AfterClass
    public static void deleteList() {
        MovieListActionSteps moviesListAction = new MovieListActionSteps();
        moviesListAction = new MovieListActionSteps();
        moviesListAction.userDeleteMovieList();
    }
}
