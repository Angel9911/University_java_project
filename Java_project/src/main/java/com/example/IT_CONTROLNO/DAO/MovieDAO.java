package com.example.IT_CONTROLNO.DAO;

import com.example.IT_CONTROLNO.model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "CINEMA", "a123");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    public List<Movie> getMovies(ResultSet rs) throws SQLException {
        List<Movie> movieList=new ArrayList<>();
        while (rs.next()){
            Movie movie=new Movie();
            movie.setName_movie(rs.getString("MOVIE_NAME"));
            movieList.add(movie);
        }
        return movieList;
    }
    public List<Movie> getCities(ResultSet rs) throws SQLException{
        List<Movie> citylist=new ArrayList<>();
        String city=null;
        while(rs.next()){
            Movie movie=new Movie();
            movie.setCity_movie(rs.getString("NAME_CITY"));
            citylist.add(movie);
        }
        return citylist;
    }
    public int getIdMovie(ResultSet rs) throws SQLException{
        int id_movie=0;
        while(rs.next()){
            id_movie=rs.getInt("ID_MOVIE");
        }
        return id_movie;
    }
    public int selectIdMovie(String name_movie){
        String sqlMovie="SELECT M.ID_MOVIE \n"+
                "FROM MOVIE M \n"+
                "WHERE M.MOVIE_NAME='"+name_movie+"' \n";
        int id_movie = 0;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlMovie)){
            ResultSet resultSet=preparedStatement.executeQuery();
            id_movie=getIdMovie(resultSet);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id_movie;
    }
    public Movie getInfomationOfMovie(ResultSet rs)throws SQLException{ // Shte ni posluji za rezultata na informaciqta za filma po zaqvka
        Movie movie=null;
        while (rs.next()){
            movie=new Movie();
            movie.setName_movie(rs.getString("MOVIE_NAME"));
            movie.setDirector_movie(rs.getString("DIRECTOR"));
            movie.setLenght_movie(rs.getTimestamp("LENGHT"));
            movie.setActors_movie(rs.getString("ACTORS"));
            movie.setSummary_movie(rs.getString("SUMMARY"));
            movie.setRating_movie(rs.getString("RATING"));
        }
        return movie;
    }
    public String getGenresFromMovie(ResultSet rs)throws SQLException{
        String genre=null;
        while (rs.next()){
            genre=rs.getString("Genre");
        }
        return genre;
    }
    public List<Movie> selectMoviesOfProjections(){
        List<Movie> movies=new ArrayList<>();
        String sqlMovie="SELECT M.MOVIE_NAME \n"+
                "FROM MOVIE M \n";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlMovie)){
            ResultSet resultSet=preparedStatement.executeQuery();
            movies=getMovies(resultSet);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return movies;
    }
    public List<Movie> selectCityOfProjection() throws SQLException,ClassNotFoundException{
        String sqlCity="SELECT C.NAME_CITY \n"+
                "FROM CITY C \n";
        List<Movie > listCity = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlCity)){
            ResultSet resultSet=preparedStatement.executeQuery();
            listCity=getCities(resultSet);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listCity;
    }
    //update 15.4.21
    public Movie searchMovieOfName(String MovieName)  throws SQLException,ClassNotFoundException{ // Zaqvka po tursene na ime na film.
        String sqlSearch="SELECT M.MOVIE_NAME,M.SUMMARY,M.LENGHT,M.ACTORS,R.RATING,M.DIRECTOR \n"+
        "FROM MOVIE M \n"+
       "INNER JOIN RATINGS R ON M.RATINGS_ID_RATING=R.ID_RATIONG \n"+
        "WHERE M.MOVIE_NAME='"+MovieName+"'";
        Movie recieveMovie=new Movie();
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlSearch)){
            ResultSet resultSet=preparedStatement.executeQuery();
            recieveMovie=getInfomationOfMovie(resultSet);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recieveMovie;
    }
    public String selectGenreFromNameMovie(String MovieName){
        String gen="Genre";
        String sqlGenre="SELECT LISTAGG(G.GENRE,',') WITHIN GROUP (ORDER BY G.GENRE) AS "+gen+"\n"+
        "FROM GENRE G \n"+
        "INNER JOIN MOVIEGENRE MG on MG.GENRE_ID_GENRE=G.ID_GENRE \n"+
        "INNER JOIN MOVIE M ON MG.MOVIE_ID_MOVIE=M.ID_MOVIE \n"+
        "WHERE M.MOVIE_NAME='"+MovieName+"'";
        String genre = null;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlGenre)){
            ResultSet resultSet=preparedStatement.executeQuery();
            genre=getGenresFromMovie(resultSet);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return genre;
    }
}
