package com.example.IT_CONTROLNO;

import com.example.IT_CONTROLNO.DAO.ProjectionDAO;
import com.example.IT_CONTROLNO.model.Projection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/KinoServlet")
public class KinoServlet extends HttpServlet {
    private List<Projection> cinemaList;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cinemaList=(List)req.getSession().getAttribute("allProjections");
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("Kino.jsp");
        req.setAttribute("cinemaList",cinemaList);
        requestDispatcher.forward(req,resp);
    }
    @Override
    public void destroy() {
        super.destroy();
    }
}
