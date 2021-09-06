package com.vishwa.movieBookingSystem.dtos;
/**
 * This class will be used to convert client JSON request
 * to Java Object and vice-versa
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class MovieDTO {


    @JsonProperty("movie_id")
    private int movieId;
    @JsonProperty("movie_name")
    private String movieName;
    @JsonProperty("movie_desc")
    private String movieDescription;
    @JsonProperty("release_date")
    private LocalDateTime releaseDate;
    private int duration;
    @JsonProperty("cover_Photo_url")
    private String coverPhotoUrl;
    @JsonProperty("trailer_url")
    private String trailerUrl;

    public String getMovieName() {
        return movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getStatusId() {
        return statusId;
    }

    private int statusId;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieDescription='" + movieDescription + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", coverPhotoUrl='" + coverPhotoUrl + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                ", statusId=" + statusId +
                '}';
    }
}