package com.rhcloud.my_visualjava.web.test.my_visualjava.web.todo;

import com.rhcloud.my_visualjava.web.test.my_visualjava.core.todo.Todo;

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

        TodoDao worker = TodoDaoImpl.getInstance();

        worker.isDoneTODO((String)request.getParameter("id"));

        List<Todo> todoMap = worker.getAllTodo();

        request.setAttribute("todo", todoMap);

        response.sendRedirect("/index");
    }

}
