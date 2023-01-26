package com.example.IT_CONTROLNO;

import com.example.IT_CONTROLNO.DAO.ClientDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
    private String name_Client;
    private String email_Client;
    private String phone_Client;
    private int age_Client;
    private String password_Client;
    private ClientDAO clientDAO = new ClientDAO();

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
        name_Client=req.getParameter("nameClient"); // trqbva da se izpolzvat parametrite v kavichkite v name atributa na input-textovete
        email_Client=req.getParameter("emailClient");
        phone_Client=req.getParameter("phoneClient");
        age_Client= Integer.parseInt(req.getParameter("ageClient"));
        password_Client=req.getParameter("passClient");
        clientDAO.RegistrationOfClient(name_Client,email_Client,phone_Client,age_Client,password_Client);
    }
    @Override
    public void destroy() {
        super.destroy();
    }
}
