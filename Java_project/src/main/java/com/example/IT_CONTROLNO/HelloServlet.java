package com.example.IT_CONTROLNO;

import com.example.IT_CONTROLNO.DAO.MovieDAO;
import com.example.IT_CONTROLNO.DAO.ProjectionDAO;
import com.example.IT_CONTROLNO.model.Client;
import com.example.IT_CONTROLNO.model.Movie;
import com.example.IT_CONTROLNO.model.Projection;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    private String getSearchNameMovie;
    private List<Projection> cinemaList;
    private ProjectionDAO projectionDAO=new ProjectionDAO();

    @Override
    public void init() {
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       Client recentClient=(Client)request.getSession().getAttribute("clientObj");
       if(recentClient.getName_client()!=""){
           RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
           request.setAttribute("recentNameClient",recentClient.getName_client());
           request.getSession().setAttribute("recendIdClient",recentClient.getId_Client());
           dispatcher.forward(request,response);
       }
        //getSearchNameMovie=request.getParameter("nameMovie");// tova e opciq dve za tursene po ime na film
        else {
           try {
               cinemaList = projectionDAO.getAllProjections();// tova shte go izpolzvame kato potrebitelq cukne butona kina, da mi izvede kinata v syotvetnite gradove
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }
           if (request.getParameter("kino") != null) {
               request.getSession().setAttribute("allProjections", cinemaList);
               response.sendRedirect("KinoServlet");

           }
       }
    }

    public void destroy() {
    }
}
