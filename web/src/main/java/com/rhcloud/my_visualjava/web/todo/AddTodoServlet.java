package com.rhcloud.my_visualjava.web.todo;

import com.rhcloud.my_visualjava.test.com.rhcloud.my_visualjava.todo.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by LyashenkoGS on 9/16/2015.
 */

@WebServlet(name = "addTodo",
            value="/addTodo")
public class AddTodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        TodoDaoImpl worker = new TodoDaoImpl();

        worker.addTODO(request.getParameter("TODO"), request.getParameter("name"));
        List<Todo> todoMap = worker.getAllTodo();
        System.out.println(todoMap);

        request.setAttribute("todo", todoMap);

       response.sendRedirect("/index");
    }
}