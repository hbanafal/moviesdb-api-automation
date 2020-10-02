package com.moviesdb.api.automation.models.Response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MediaItemResponse {

}

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@AllArgsConstructor
@NoArgsConstructor
class MovieItem extends MediaItemResponse {
    public String poster_path;
    public boolean adult;
    public String overview;
    public String release_date;
    public String original_title;
    public List<Integer> genre_ids;
    public int id;
    public String media_type;
    public String original_language;
    public String title;
    public String backdrop_path;
    public double popularity;
    public int vote_count;
    public boolean video;
    public double vote_average;
}

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@AllArgsConstructor
@NoArgsConstructor
class TVItem extends MediaItemResponse {

    public String original_name;
    public List<Integer> genre_ids;
    public String media_type;
    public String name;
    public double popularity;
    public List<String> origin_country;
    public int vote_count;
    public String first_air_date;
    public String backdrop_path;
    public String original_language;
    public int id;
    public double vote_average;
    public String overview;
    public String poster_path;

}
