package com.example.IT_CONTROLNO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ReseravtionServlet")
public class ReseravtionServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_c= (int) req.getSession().getAttribute("idClient");
        int id_m=(int)req.getSession().getAttribute("idMovie");
        System.out.println("cl+ "+id_c+" mv+ "+id_m);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("ReservationForm.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
