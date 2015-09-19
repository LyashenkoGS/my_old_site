package com.database;

import com.mysql.jdbc.PreparedStatement;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static java.sql.DriverManager.getConnection;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/*
Integration tests for production MySql database and TODOdbWorker
 */
public class TODOdbWorkerIntegrationTest {
    /*
    DB Settings for integration tests
     */
    final String URL = "jdbc:mysql://127.9.81.2:3306/test?useUnicode=yes&characterEncoding=UTF-8";
    final String USERNAME = "adminiwG1ZaB";
    final String PASSWORD = "v3ykjhlpBE9q";
    TODOdbWorker worker = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    Connection connection = null;

    @BeforeClass
    public static void mySqlSetUp() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
    }

    @Before
    public void setUp() throws Exception {
        worker = new TODOdbWorker();
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
        List<TodoClass> todoList = worker.getTODO();
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
        List<TodoClass> todoList = worker.getTODO();
        boolean containUpdate = false;
        for (TodoClass todoClass : todoList) {
            if (todoClass.getName().equals("updatedTestName")) {
                containUpdate = true;
                break;
            }
        }
        assertTrue(containUpdate);
        //delete
        worker.deleteTODO(id);
        todoList=worker.getTODO();
                boolean doesntContain=true;
        for (TodoClass todoClass : todoList) {
        if (todoClass.getId().equals(id))
            doesntContain=false;
            break;
        }
       assertTrue(doesntContain);
    }
}


