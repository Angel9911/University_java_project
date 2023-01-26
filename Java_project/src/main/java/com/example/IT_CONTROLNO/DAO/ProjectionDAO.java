package com.example.IT_CONTROLNO.DAO;

import com.example.IT_CONTROLNO.model.Projection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjectionDAO {
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
    public List<Projection> getAllProjections(ResultSet rs) throws SQLException {
        List<Projection> cinemasLiST=new ArrayList<>();
        while (rs.next()) {
            Projection projection=new Projection();
            projection.setCity_projetion(rs.getString("NAME_CITY"));
            projection.setProjection_date(rs.getDate("DATE_PROJ"));
            projection.setProjection_time(rs.getTimestamp("TIME_PROJ"));
            projection.setMax_seats(rs.getInt("max_seats"));
            cinemasLiST.add(projection);
        }
        return cinemasLiST;
    }
    public List<Projection> getCinemas(ResultSet rs) throws SQLException {
        List<Projection> cinemasLiST=new ArrayList<>();
        while (rs.next()) {
            Projection projection=new Projection();
            projection.setCity_projetion(rs.getString("NAME_CITY"));
            cinemasLiST.add(projection);
        }
        return cinemasLiST;
    }
    public int getIdProjection(ResultSet rs) throws SQLException{
        int id_proj=0;
        while(rs.next()){
            id_proj=rs.getInt("ID_PROJ");
        }
        return id_proj;
    }
    public List<Projection> getProjetions(ResultSet rs) throws SQLException{
        List<Projection> projectionList=new ArrayList<>();
        while (rs.next()){
            Projection projection=new Projection();
            projection.setProjection_date(rs.getDate("DATE_PROJ"));
            projection.setCity_projetion(rs.getString("NAME_CITY"));
            projection.setProjection_time(rs.getTimestamp("TIME_PROJ"));
            projectionList.add(projection);
        }
        return projectionList;
    }
    public List<Projection> searchProjectionDate(String kino, String MovieName, java.util.Date DateProjection) throws SQLException {
        java.sql.Date sqlcon=new java.sql.Date(DateProjection.getTime());
        String sqlSearch = "SELECT P.DATE_PROJ,C.NAME_CITY,P.TIME_PROJ \n" +
                "FROM PROJECTION P \n" +
                "INNER JOIN CITY C ON P.CITY_ID_CITY=C.ID_CITY \n" +
                "INNER JOIN MOVIE M ON P.MOVIE_ID_MOVIE=M.ID_MOVIE \n" +
                "WHERE C.NAME_CITY=? AND M.MOVIE_NAME=? OR P.DATE_PROJ=?";
        List<Projection> listSearchMovie=new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlSearch)) {
            preparedStatement.setString(1,kino);
            preparedStatement.setString(2,MovieName);
            preparedStatement.setDate(3,sqlcon);
            ResultSet resultSet=preparedStatement.executeQuery();
            listSearchMovie=getProjetions(resultSet);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listSearchMovie;
    }
    public List<Projection> searchOfNameProjections(String nameMovie){
        String sqlSearch="SELECT P.DATE_PROJ,C.NAME_CITY,P.TIME_PROJ \n"+
        "FROM PROJECTION P \n"+
        "INNER JOIN CITY C ON p.city_id_city=c.id_city \n"+
        "INNER JOIN MOVIE M ON P.MOVIE_ID_MOVIE=M.ID_MOVIE \n"+
       "WHERE M.MOVIE_NAME='"+nameMovie+"'";
        List<Projection> Searchlist=new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlSearch)){
            ResultSet resultSet=preparedStatement.executeQuery();
            Searchlist=getProjetions(resultSet);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Searchlist;
    }
    public List<Projection> getAllCinemas() throws SQLException {
        String sql = "SELECT * FROM CITY";
        List<Projection> listCinemas = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            listCinemas = getCinemas(resultSet);
        }
        return listCinemas;
    }
    public int SelectIdFromProjection(Date date,Date time,int MovieId){
        String sqlSearch="SELECT P.ID_PROJ \n"+
                "FROM PROJECTION P \n"+
                "INNER JOIN MOVIE M ON P.MOVIE_ID_MOVIE=M.ID_MOVIE \n"+
                "WHERE P.date='"+date+"' AND P.TIME='"+time+"' AND M.ID_MOVIE='"+MovieId+"';";
        int idProject = 0;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlSearch)){
            ResultSet resultSet=preparedStatement.executeQuery();
            idProject=getIdProjection(resultSet);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return idProject;
    }
    public  void insertReservation(int br_seats,int project_id,int client_id,int city_id){
        String reservation=
                "BEGIN \n"+
                        "INSERT RESERVATIONS(ID_RESERVATION,SEATS,PROJECTION_ID_PROJ,CLIENT_ID_CLIENT,CITY_ID_CITY) \n" +
                        "values(SEQUENCE_RESERVATION.nextval,'"+br_seats+"','"+project_id+"','"+client_id+"','"+city_id+"') \n" +
                        "END; \n";
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()){
            statement.executeUpdate(reservation);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public  List<Projection> getAllProjections() throws SQLException {
        String sqlSearch="SELECT C.NAME_CITY,P.DATE_PROJ ,P.TIME_PROJ,ST.MAX_SEATS \n"+
       "FROM CITY C \n"+
       "INNER JOIN PROJECTION P ON p.city_id_city=c.id_city \n"+
       "INNER JOIN streaming_rooms ST ON p.streaming_rooms_id_room=st.id_room";
        List<Projection> Searchlist=new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlSearch)){
            ResultSet resultSet=preparedStatement.executeQuery();
            Searchlist=getAllProjections(resultSet);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Searchlist;
    }

}

