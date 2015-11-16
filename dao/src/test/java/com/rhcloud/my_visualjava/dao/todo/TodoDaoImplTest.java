package com.rhcloud.my_visualjava.dao.todo;

import com.mysql.jdbc.PreparedStatement;
import com.rhcloud.my_visualjava.dao.todo.TodoDao;
import com.rhcloud.my_visualjava.dao.todo.TodoDaoImpl;
import com.rhcloud.my_visualjava.test.com.rhcloud.my_visualjava.todo.Todo;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

import static java.sql.DriverManager.getConnection;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/*
Integration tests for production MySql database and TodoDao
 */
public class TodoDaoImplTest {

    TodoDao todoDao ;

    ConfigurableApplicationContext context =
            new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});


    @Before
    public void setUp() throws Exception {
todoDao=(TodoDao)context.getBean("todoDao");
    }




    @Test
    public void testTodoCrudOperations() throws Exception {
        String todoName = "todoName";
        String developerName = "developerName";
        //todoDao.addTODO(todoName, developerName);
        List<Todo> allTodo=todoDao.getAllTodo();
        boolean containAddedTodo=false;
        for (Todo todo :allTodo) {

        }
        assertTrue(containAddedTodo);
    }
}


