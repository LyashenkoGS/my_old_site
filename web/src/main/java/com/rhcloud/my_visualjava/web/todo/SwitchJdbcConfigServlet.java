package com.rhcloud.my_visualjava.web.todo;


import com.rhcloud.my_visualjava.dao.test.TestDao;
import com.rhcloud.my_visualjava.dao.test.TestDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "switchJdbcConfig",
        value="/switchJdbcConfig")
public class SwitchJdbcConfigServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TodoDao worker = TodoDaoImpl.getInstance();
        TestDao testDao= TestDaoImpl.getInstance();
        testDao.changeDefaultJdbcConfiguration();
        worker.changeDefaultJdbcConfiguration();
        System.out.println("config changed");

        response.sendRedirect("/index");
    }
}
