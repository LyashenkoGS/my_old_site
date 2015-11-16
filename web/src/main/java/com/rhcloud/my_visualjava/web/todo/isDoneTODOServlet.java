package com.rhcloud.my_visualjava.web.todo;

import com.rhcloud.my_visualjava.web.todo.TodoDaoImpl;
import com.rhcloud.my_visualjava.test.com.rhcloud.my_visualjava.todo.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "isdoneTodo", value = "/isdoneTodo")
public class IsDoneTodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        TodoDaoImpl worker = new TodoDaoImpl();

        worker.isDoneTODO((String)request.getParameter("id"));

        List<Todo> todoMap = worker.getAllTodo();

        request.setAttribute("todo", todoMap);

        response.sendRedirect("/index");
    }

}
