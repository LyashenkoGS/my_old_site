package com.rhcloud.my_visualjava.web.test;


import com.rhcloud.my_visualjava.test.TestEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "answer", value = "/answer")
public class CheckTestAnswersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Map<String, String> answeredQuestions = new HashMap<>();
        String testName = request.getParameter("testName");
        Map<String, String[]> parametersMap = request.getParameterMap();
        parametersMap.remove("testName");
        System.out.println(testName);
        for (Map.Entry entry : parametersMap.entrySet()) {
            String tempKey = (String) entry.getKey();
            String[] values = (String[]) entry.getValue();
            String truncatedValue = values[0];
            //TODO: implement logging
         /*   System.out.print(tempKey + ":");
            System.out.println(truncatedValue);*/
            answeredQuestions.put(tempKey, truncatedValue);
        }

        HttpSession session = request.getSession();
        Set<TestEntity> allTests = (Set<TestEntity>) session.getAttribute("allTests");

        for (TestEntity test : allTests) {
            if (test.getName().equals(testName)) {

                test.checkAllQuestions(answeredQuestions);
                request.setAttribute("checkedTest", test);
            }
        }


        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/answer.jsp");
        rd.forward(request, response);

    }
}
