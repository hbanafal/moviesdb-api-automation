package com.moviesdb.api.automation.models.Response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@AllArgsConstructor
@NoArgsConstructor
public class GetMovieListResponse {

    public String poster_path;
    public int id;
    public String backdrop_path;
    public int total_results;
    public String revenue;
    public int page;
    public List<? extends MediaItemResponse> results;
    public List<Map<String, String>> object_ids;
    public String iso_639_1;
    public int total_pages;
    public String description;
    public CreatedBy created_by;
    public String iso_3166_1;
    public double average_rating;
    public int runtime;
    public String name;
    public String sort_by;
    public List<Map<String, String>> comments;

    @JsonProperty("public")
    public boolean getPublic() {
        return this.publicStatus;
    }

    public void setPublic(boolean publicStatus) {
        this.publicStatus = publicStatus;
    }

    boolean publicStatus;

    @Getter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @AllArgsConstructor
    @NoArgsConstructor
    public class CreatedBy {
        public String gravatar_hash;
        public String name;
        public String username;
        public String id;
    }

}
