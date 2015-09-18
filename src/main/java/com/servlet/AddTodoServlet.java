package com.servlet;

import com.database.TODOdbWorker;
import com.database.TodoClass;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by LyashenkoGS on 9/16/2015.
 */
public class AddTodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        TODOdbWorker worker = new TODOdbWorker();

        worker.addTODO((String) request.getParameter("TODO"), (String) request.getParameter("name"));
        System.out.println((String) request.getParameter("TODO"));
        System.out.println((String) request.getParameter("name"));
        System.out.println("add todo servlet have been invoked");
        List<TodoClass> todoMap = worker.getTODO();
        System.out.println(todoMap);

        request.setAttribute("todo", todoMap);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
        rd.forward(request, response);
    }

}