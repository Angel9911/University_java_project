package com.example.IT_CONTROLNO.model;

import java.sql.Timestamp;

public class Movie {
    protected int id_movie;
    protected String name_movie;
    protected String director_movie;
    protected Timestamp lenght_movie;
    protected String actors_movie;
    protected String summary_movie;
    protected String rating_movie;
    protected String genre_movie;

    protected String city_movie; //>?
    public Movie(){
        this.id_movie=getId_movie();
        this.name_movie=getName_movie();
        this.director_movie=getDirector_movie();
        this.lenght_movie=getLenght_movie();
        this.actors_movie=getActors_movie();
        this.summary_movie=getSummary_movie();
        this.rating_movie=getRating_movie();
        this.genre_movie=getGenre_movie();
        this.city_movie=getCity_movie();
    }

    public int getId_movie() {
        return id_movie;
    }

    public void setId_movie(int id_movie) {
        this.id_movie = id_movie;
    }

    public String getName_movie() {
        return name_movie;
    }

    public void setName_movie(String name_movie) {
        this.name_movie = name_movie;
    }

    public String getDirector_movie() {
        return director_movie;
    }

    public void setDirector_movie(String director_movie) {
        this.director_movie = director_movie;
    }

    public Timestamp getLenght_movie() {
        return lenght_movie;
    }

    public void setLenght_movie(Timestamp lenght_movie) {
        this.lenght_movie = lenght_movie;
    }

    public String getActors_movie() {
        return actors_movie;
    }

    public void setActors_movie(String actors_movie) {
        this.actors_movie = actors_movie;
    }

    public String getSummary_movie() {
        return summary_movie;
    }

    public void setSummary_movie(String summary_movie) {
        this.summary_movie = summary_movie;
    }

    public String getRating_movie() {
        return rating_movie;
    }

    public void setRating_movie(String rating_movie) {
        this.rating_movie = rating_movie;
    }

    public String getGenre_movie() {
        return genre_movie;
    }

    public void setGenre_movie(String genre_movie) {
        this.genre_movie = genre_movie;
    }


    public String getCity_movie() {
        return city_movie;
    }

    public void setCity_movie(String city_movie) {
        this.city_movie = city_movie;
    }

}
