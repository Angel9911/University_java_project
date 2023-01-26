package com.example.IT_CONTROLNO;

import com.example.IT_CONTROLNO.DAO.ClientDAO;
import com.example.IT_CONTROLNO.model.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private int id_client;
    private String log_Email;
    private String log_Pass;
    private String Client_name;
    private ClientDAO clientDAO=new ClientDAO();
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
        log_Email = req.getParameter("Log_Email"); // trqbva da se izpolzvat parametrite v kavichkite v name atributa na input-textovete
        log_Pass = req.getParameter("Log_Pass");
        Client_name = clientDAO.selectNameOfLog(log_Email, log_Pass);
        id_client=clientDAO.selectIDofClient(Client_name);
        Client client=new Client(id_client,Client_name);
        req.getSession().setAttribute("clientObj",client);
        resp.sendRedirect("HelloServlet");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
