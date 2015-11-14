package com.servlet;


import com.rhcloud.my_visualjava.dao.test.TestDao;
import com.rhcloud.my_visualjava.dao.test.TestDaoImpl;
import com.rhcloud.my_visualjava.dao.todo.JdbcLocalhostConfiguration;
import com.rhcloud.my_visualjava.test.TestEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "tests", value = "/tests")
                          public class TestsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        TestDao testDao = new TestDaoImpl();
       //TODO: enable switch between local and production DB via web interface in runtime
        // testDao.changeDefaultJdbcConfiguration(JdbcLocalhostConfiguration.URL,JdbcLocalhostConfiguration.USERNAME,JdbcLocalhostConfiguration.PASSWORD);
        Set<TestEntity> allTests = testDao.getAllTests();
  //  request.setAttribute("allTests", allTests);
        HttpSession session = request.getSession();
        session.setAttribute("allTests", allTests);
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/test.jsp");
        rd.forward(request, response);
    }

}
