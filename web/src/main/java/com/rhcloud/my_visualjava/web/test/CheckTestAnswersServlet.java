package com.rhcloud.my_visualjava.web.test;


import com.rhcloud.my_visualjava.test.TestEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

            String testName = (String) jsonObject.get("testName");


            for(Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();
                if(!key.equals("testName"))
                System.out.println(jsonObject.get(key));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/answer.jsp");
        rd.forward(request, response);

    }
}
