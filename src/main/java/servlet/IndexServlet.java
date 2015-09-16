package servlet;

import com.mvj.database.TODOdbWorker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Map mockMap=new HashMap<String,String>();
        mockMap.put("one","one");
        mockMap.put("two","one");
        mockMap.put("three","one");
        System.out.println(mockMap.entrySet());


        request.setAttribute("demoNames", mockMap);
       TODOdbWorker worker = new TODOdbWorker();
        Map todoMap =worker.getTODO();
        System.out.println(todoMap);

        request.setAttribute("todo", todoMap);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
        rd.forward(request, response);
    }
}
