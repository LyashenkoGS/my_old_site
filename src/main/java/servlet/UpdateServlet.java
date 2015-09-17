package servlet;

import com.mvj.database.TODOdbWorker;
import com.mvj.database.TodoClass;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Zheka on 17.09.2015.
 */
@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        TODOdbWorker worker = new TODOdbWorker();

        worker.updateTODO((String) request.getParameter("id"), (String) request.getParameter("TODO"), (String) request.getParameter("name"));
        System.out.println((String) request.getParameter("id"));
        System.out.println((String) request.getParameter("TODO"));
        System.out.println((String) request.getParameter("name"));
        System.out.println("Update servlet have been invoked");
        List<TodoClass> todoMap = worker.getTODO();
        System.out.println(todoMap);

        request.setAttribute("todo", todoMap);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
        rd.forward(request, response);
    }
}
