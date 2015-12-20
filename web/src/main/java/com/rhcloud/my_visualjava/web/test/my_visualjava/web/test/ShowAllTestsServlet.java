package com.rhcloud.my_visualjava.web.test.my_visualjava.web.test;


import com.rhcloud.my_visualjava.web.test.my_visualjava.dao.test.TestDao;
import com.rhcloud.my_visualjava.web.test.my_visualjava.dao.test.TestDaoImpl;
import com.rhcloud.my_visualjava.web.test.my_visualjava.test.TestEntity;

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
public class ShowAllTestsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

       /* ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});*/
        TestDao testDao = TestDaoImpl.getInstance();
        //TODO: enable switch between local and production DB via web interface in runtime

        Set<TestEntity> allTests = testDao.getAllTests();
        HttpSession session = request.getSession();
        session.setAttribute("allTests", allTests);
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/test.jsp");
        rd.forward(request, response);
    }

}
