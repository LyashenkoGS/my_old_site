package com.rhcloud.my_visualjava.web.test.my_visualjava.web.test;


import com.rhcloud.my_visualjava.web.test.my_visualjava.dao.test.TestDao;
import com.rhcloud.my_visualjava.web.test.my_visualjava.dao.test.TestDaoImpl;
import com.rhcloud.my_visualjava.web.test.my_visualjava.test.Question;
import com.rhcloud.my_visualjava.web.test.my_visualjava.test.TestEntity;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "answer", value = "/answer")
public class CheckTestAnswersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(request.getParameter("json"));
            JSONObject jsonObject = (JSONObject) obj;
            Map<String, String> questionAnswer = new HashMap<>();

            String testName = (String) jsonObject.get("testName");
            for (Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext(); ) {
                String key = (String) iterator.next();
                if (!key.equals("testName")) {
                    questionAnswer.put(key, (String) jsonObject.get(key));
                }
            }

            TestDao testDao = TestDaoImpl.getInstance();
            Set<TestEntity> testEntitySet = testDao.getAllTests();
            for (TestEntity testEntity : testEntitySet) {
                if (testEntity.getName().equals(testName)) {
                    System.out.println(testEntity.getName());
                    testEntity.checkAllQuestions(questionAnswer);
                    for (Map.Entry<String, Question> entry : testEntity.getQuestions().entrySet()) {
                        System.out.println(entry.getValue().getName());
                        System.out.println(entry.getValue().isAnsweredRight());
                    }
                    request.setAttribute("testEntity", testEntity);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/answer.jsp");
        rd.forward(request, response);

    }
}
