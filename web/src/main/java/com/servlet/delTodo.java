package com.servlet;

import com.rhcloud.my_visualjava.dao.todo.TodoDaoImpl;
import com.rhcloud.my_visualjava.test.com.rhcloud.my_visualjava.todo.Todo;

import javax.servlet.RequestDispatcher;
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

@WebServlet(name = "delTodo",
            value="/delTodo")
public class delTodo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        TodoDaoImpl worker = new TodoDaoImpl();

        worker.deleteTODO(request.getParameter("ID"));
        System.out.println(request.getParameter("ID"));
        System.out.println("del todo servlet have been invoked");
        List<Todo> todoMap = worker.getTODO();
        System.out.println(todoMap);

        request.setAttribute("todo", todoMap);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
        rd.forward(request, response);
    }

}