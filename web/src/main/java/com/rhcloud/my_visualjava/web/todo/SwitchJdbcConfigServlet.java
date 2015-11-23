package com.rhcloud.my_visualjava.web.todo;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "changeTodoJdbcConfig",
        value="/changeTodoJdbcConfig")
public class SwitchJdbcConfigServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TodoDao worker = TodoDaoImpl.getInstance();
        worker.changeDefaultJdbcConfiguration();
        System.out.println("config changed");

        response.sendRedirect("/index");
    }
}
