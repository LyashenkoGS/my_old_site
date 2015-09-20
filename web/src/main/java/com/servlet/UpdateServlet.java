package com.servlet;

import com.database.TODOdbWorker;
import com.database.TodoClass;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        TODOdbWorker worker = new TODOdbWorker();

        worker.updateTODO(request.getParameter("id"),
                request.getParameter("TODO"),
                request.getParameter("name"));
        List<TodoClass> todoMap = worker.getTODO();
        System.out.println(todoMap);

        request.setAttribute("todo", todoMap);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
        rd.forward(request, response);
    }
}
