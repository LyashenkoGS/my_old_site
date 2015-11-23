package com.rhcloud.my_visualjava.web.todo;


import com.rhcloud.my_visualjava.core.todo.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "delTodoServlet",
            value="/DelTodoServlet")
public class delTodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        TodoDao worker = TodoDaoImpl.getInstance();

        worker.deleteTODO(request.getParameter("ID"));
        System.out.println(request.getParameter("ID"));
        System.out.println("del todo servlet have been invoked");
        List<Todo> todoMap = worker.getAllTodo();
        System.out.println(todoMap);

        request.setAttribute("todo", todoMap);

        response.sendRedirect("/index");
    }

}