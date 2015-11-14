package com.todo;

import com.mysql.jdbc.PreparedStatement;
import com.rhcloud.my_visualjava.dao.todo.TodoDao;
import com.rhcloud.my_visualjava.dao.todo.TodoDaoImpl;
import com.rhcloud.my_visualjava.test.com.rhcloud.my_visualjava.todo.Todo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static java.sql.DriverManager.getConnection;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/*
Integration tests for production MySql database and TodoDao
 */
public class TodoDaoImplIntegrationTest {
    /*
    DB Settings for integration tests
     */
    final String URL = "jdbc:mysql://127.9.81.2:3306/test?useUnicode=yes&characterEncoding=UTF-8";
    final String USERNAME = "adminiwG1ZaB";
    final String PASSWORD = "v3ykjhlpBE9q";
    TodoDao worker = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    Connection connection = null;

    @BeforeClass
    public static void mySqlSetUp() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
    }

    @Before
    public void setUp() throws Exception {
        worker = new TodoDaoImpl();
        connection = getConnection(URL, USERNAME, PASSWORD);
        statement = connection.createStatement();
        statement.executeQuery("SET NAMES 'UTF8'");
        statement.executeQuery("SET CHARACTER SET 'UTF8'");
    }

    @Test
    public void connectToMySqlTestDatabase() throws Exception {
        connection = getConnection(URL, USERNAME, PASSWORD);
    }

    @Test
    public void testGetTodo() throws Exception {
        List<Todo> todoList = worker.getAllTodo();
        assertNotNull(todoList);
    }

    @Test
    public void testTodoCrudOperations() throws Exception {
        //create
        worker.addTODO("testTodo", "testName");

        ResultSet resultSet = statement.executeQuery("SELECT id FROM test.todo where todo='testTodo'");
        resultSet.next();
        assertNotNull(resultSet.getString("id"));
        System.out.println("Id of created TODO = " + resultSet.getString("id"));
        //update
        String id = resultSet.getString("id");
        worker.updateTODO(id, "updatedTestTodo", "updatedTestName");
        List<Todo> todoList = worker.getAllTodo();
        boolean containUpdate = false;
        for (Todo todoClass : todoList) {
            if (todoClass.getName().equals("updatedTestName")) {
                containUpdate = true;
                break;
            }
        }
        assertTrue(containUpdate);
        //delete
        worker.deleteTODO(id);
        todoList = worker.getAllTodo();
        boolean doesntContain = true;
        for (Todo todoClass : todoList) {
            if (todoClass.getId().equals(id))
                doesntContain = false;
            break;
        }
        assertTrue(doesntContain);
    }
}


