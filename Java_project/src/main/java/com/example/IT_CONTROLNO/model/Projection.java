package com.example.IT_CONTROLNO.model;

import java.sql.Timestamp;
import java.util.Date;

public class Projection {
    private Date projection_date;
    private Timestamp projection_time;
    private String city_projetion;
    private String nameMovie;
    private int number_seats;
    private String client_name;
    private String client_email;
    private String rating_movie;
    private int max_seats;

    public Projection(){
        this.projection_date=getProjection_date();
        this.projection_time=getProjection_time();
        this.city_projetion=getCity_projetion();
        this.nameMovie=getNameMovie();
        this.number_seats=getNumber_seats();
        this.client_name=getClient_name();
        this.client_email=getClient_email();
        this.rating_movie=getRating_movie();
        this.max_seats=getMax_seats();
    }


    public int getMax_seats() {
        return max_seats;
    }

    public void setMax_seats(int max_seats) {
        this.max_seats = max_seats;
    }



    public String getRating_movie() {
        return rating_movie;
    }

    public void setRating_movie(String rating_movie) {
        this.rating_movie = rating_movie;
    }

    public Date getProjection_date() {
        return projection_date;
    }

    public void setProjection_date(Date projection_date) {
        this.projection_date = projection_date;
    }

    public Timestamp getProjection_time() {
        return projection_time;
    }

    public void setProjection_time(Timestamp projection_time) {
        this.projection_time = projection_time;
    }

    public String getCity_projetion() {
        return city_projetion;
    }

    public void setCity_projetion(String city_projetion) {
        this.city_projetion = city_projetion;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public int getNumber_seats() {
        return number_seats;
    }

    public void setNumber_seats(int number_seats) {
        this.number_seats = number_seats;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

}
