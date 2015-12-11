package com.rhcloud.my_visualjava.web.test;


import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
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


        System.out.println(request.getParameter("json"));
       JSONParser parser = new JSONParser();
        String s = request.getParameter("json");

       try{
            Object obj = parser.parse(" {\n" +
                    "\t\"age\":100,\n" +
                    "\t\"name\":\"mkyong.com\",\n" +
                    "\t\"messages\":[\"msg 1\",\"msg 2\",\"msg 3\"]\n" +
                    "}") ;
           JSONObject jsonObject = (JSONObject)obj;
           String name = (String) jsonObject.get("name");
           System.out.println(name);


       }
        catch (ParseException pe){

            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }
/*

        HttpSession session = request.getSession();
        Set<TestEntity> allTests = (Set<TestEntity>) session.getAttribute("allTests");

        for (TestEntity test : allTests) {
            if (test.getName().equals(testName)) {

                test.checkAllQuestions(answeredQuestions);
                request.setAttribute("checkedTest", test);
            }
        }
*/


        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/answer.jsp");
        rd.forward(request, response);

    }
}
