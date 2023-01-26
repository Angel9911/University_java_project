package com.example.IT_CONTROLNO;

import com.example.IT_CONTROLNO.DAO.MovieDAO;
import com.example.IT_CONTROLNO.DAO.ProjectionDAO;
import com.example.IT_CONTROLNO.model.Movie;
import com.example.IT_CONTROLNO.model.Projection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet("/AfterSearchServlet")
public class AfterSearchServlet extends HttpServlet {
    private int GetIDclient;
    private int GetIDmovie;
    private String getDate;
    private String getCityCombo;
    private String getMovieCombo=null;
    private String getGenre;
    private String getSearchNameMovie="";
    private Movie resultOfSeachName;
    private Movie resultOfCombo;
    private MovieDAO movieDAO=new MovieDAO();
    private ProjectionDAO projectionDAO=new ProjectionDAO();
    private List<Projection> SearchListProjection;
    private List<Projection> ListProjectionsCombo;
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetIDclient = (int) req.getSession().getAttribute("recendIdClient");// TUK VZEMAME ID NA CLIENT;
        req.getSession().setAttribute("idClient",GetIDclient);
        String convertMovieName="",converCity="",converMovie="";
        java.util.Date senddat = new Date();
        getDate=req.getParameter("projDate");
        getCityCombo=req.getParameter("cities");
        getMovieCombo=req.getParameter("movies");
        getSearchNameMovie=req.getParameter("nameMovie");// tova e opciq dve za tursene po ime na film
        if(getSearchNameMovie!=""){

            byte bytesNameMovie[] = getSearchNameMovie.getBytes("ISO-8859-1");
             convertMovieName = new String(bytesNameMovie, "UTF-8");

        }else {

            final String OLD_FORMAT = "yyyy-MM-dd";// OT TUK
            final String NEW_FORMAT = "MM-dd-yyyy";

            String oldDateString = getDate;//2021-06-02
            String newDateString;

            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
            Date d = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            try {
                d = sdf.parse(oldDateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            sdf.applyPattern(NEW_FORMAT);
            newDateString = sdf.format(d);// DO TUK - vzemam string ot date i mu smenqm formata

            System.out.println(newDateString);//06-02-2021
            DateTimeFormatter f = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            LocalDate localDate = LocalDate.parse(newDateString, f);
            Calendar c = Calendar.getInstance();
            c.set(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
             senddat = c.getTime();

            getCityCombo = req.getParameter("cities");
            getMovieCombo = req.getParameter("movies");
            byte bytesCity[] = getCityCombo.getBytes("ISO-8859-1");
            byte bytesMovie[] = getMovieCombo.getBytes("ISO-8859-1");
             converCity = new String(bytesCity, "UTF-8");
             converMovie = new String(bytesMovie, "UTF-8");
        }
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("ResultSearch.jsp");
        if(getSearchNameMovie!="") {
            try{
                resultOfSeachName=movieDAO.searchMovieOfName(convertMovieName);// тук също извежда информация за филма,но като се търси по име
                getGenre=movieDAO.selectGenreFromNameMovie(convertMovieName);
                SearchListProjection=projectionDAO.searchOfNameProjections(convertMovieName);// tyk syshto shte izvejda projekciite sprqmo filma,no po tursene na ime
                GetIDmovie=movieDAO.selectIdMovie(convertMovieName);// TUK VZEMAME ID NA MOVIE;
                req.getSession().setAttribute("idMovie",GetIDmovie);
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
            req.setAttribute("NameMovie", resultOfSeachName.getName_movie());
            req.setAttribute("ActorsMovie", resultOfSeachName.getActors_movie());
            req.setAttribute("DirectorMovie", resultOfSeachName.getDirector_movie());
            req.setAttribute("SummaryMovie", resultOfSeachName.getSummary_movie());
            req.setAttribute("LenghtMovie", resultOfSeachName.getLenght_movie());
            req.setAttribute("RatingMovie", resultOfSeachName.getRating_movie());
            req.setAttribute("Genres", getGenre);
            req.setAttribute("ListProjectiosName",SearchListProjection);
        }
        else if(converMovie!="" && converCity!=""){
            try {
                resultOfCombo=movieDAO.searchMovieOfName(converMovie);
                getGenre=movieDAO.selectGenreFromNameMovie(converMovie);
                ListProjectionsCombo=projectionDAO.searchProjectionDate(converCity,converMovie,senddat);
                GetIDmovie=movieDAO.selectIdMovie(converMovie);// TUK VZEMAME ID NA MOVIE;
                req.getSession().setAttribute("idMovie",GetIDmovie);
            }catch (SQLException | ClassNotFoundException throwables){
                throwables.printStackTrace();
            }
            req.setAttribute("NameMovie", resultOfCombo.getName_movie());
            req.setAttribute("ActorsMovie", resultOfCombo.getActors_movie());
            req.setAttribute("DirectorMovie", resultOfCombo.getDirector_movie());
            req.setAttribute("SummaryMovie", resultOfCombo.getSummary_movie());
            req.setAttribute("LenghtMovie", resultOfCombo.getLenght_movie());
            req.setAttribute("RatingMovie", resultOfCombo.getRating_movie());
            req.setAttribute("Genres", getGenre);
            req.setAttribute("ListProjectiosName",ListProjectionsCombo);
        }
        requestDispatcher.forward(req,resp);
   }
    @Override
    public void destroy() {
        super.destroy();
    }
}
