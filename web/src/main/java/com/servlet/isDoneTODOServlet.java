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

@WebServlet(name = "isdoneTodo", value = "/isdoneTodo")
public class isDoneTODOServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        TODOdbWorker worker = new TODOdbWorker();

        worker.isDoneTODO((String)request.getParameter("id"));

        List<TodoClass> todoMap = worker.getTODO();

        request.setAttribute("todo", todoMap);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
        rd.forward(request, response);
    }

}
