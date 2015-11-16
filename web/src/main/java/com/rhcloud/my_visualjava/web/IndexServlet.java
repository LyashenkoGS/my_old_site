package com.rhcloud.my_visualjava.web;

import com.rhcloud.my_visualjava.test.com.rhcloud.my_visualjava.todo.Todo;
import com.rhcloud.my_visualjava.web.todo.TodoDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="index",
        value = "/index",
        displayName = "Visual Java project")
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        TodoDaoImpl worker = new TodoDaoImpl();
        List<Todo> allTodo = worker.getAllTodo();
        List<Todo> allActiveTodo = worker.getAllActiveTodo();
        List<Todo> allDoneTodo = worker.getAllDoneTodo();
        
        //TODO:add logging
        System.out.println(allTodo);

        request.setAttribute("todo", allTodo);
        request.setAttribute("allActiveTodo", allActiveTodo);
        request.setAttribute("allDoneTodo",allDoneTodo);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
        rd.forward(request, response);
    }
}
