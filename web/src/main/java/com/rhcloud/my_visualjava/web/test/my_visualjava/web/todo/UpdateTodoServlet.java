package com.rhcloud.my_visualjava.web.test.my_visualjava.web.todo;

import com.rhcloud.my_visualjava.web.test.my_visualjava.core.todo.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "updateTodo",
value="/updateTodo")
public class UpdateTodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        TodoDao worker = TodoDaoImpl.getInstance();

        worker.updateTODO(request.getParameter("id"),
                request.getParameter("TODO"),
                request.getParameter("name"));
        List<Todo> todoMap = worker.getAllTodo();
        System.out.println(todoMap);

        request.setAttribute("todo", todoMap);

        response.sendRedirect("/index");
    }
}
