package servlet;

import com.mvj.database.TODOdbWorker;
import com.mvj.database.TodoClass;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Map mockMap=new HashMap<String,String>();
        mockMap.put("one","one");
        mockMap.put("two","one");
        mockMap.put("three","one");
        System.out.println(mockMap.entrySet());


        request.setAttribute("demoNames", mockMap);
       TODOdbWorker worker = new TODOdbWorker();
        List<TodoClass> todoMap =worker.getTODO();
        System.out.println(todoMap);

        request.setAttribute("todo", todoMap);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
        rd.forward(request, response);
    }
}
