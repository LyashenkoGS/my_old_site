package com.rhcloud.my_visualjava.web.test;

import com.rhcloud.my_visualjava.dao.test.TestDao;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "addQuestion", value = "/addQuestion")
public class AddQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
        TestDao testDao = (TestDao)context.getBean("testDao");
        //TODO: enable switch between local and production DB via web interface in runtime

        testDao.addQuestion(request.getParameter("testName"),request.getParameter("question"));
        response.sendRedirect("/tests");
    }

}