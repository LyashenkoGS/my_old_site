package com.database;

import junit.framework.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
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
    TODOdbWorker worker = new TODOdbWorker();

    @Test
    public void connectToMySqlTestDatabase() throws Exception{
    Connection connection = getConnection(JdbcConfiguration.URL, JdbcConfiguration.USERNAME, JdbcConfiguration.PASSWORD);
             Statement statement = connection.createStatement();
            System.out.println("try set up connection");
        }

    @Test
    public void testGetTodo() throws Exception {
       List<TodoClass> todoList= worker.getTODO();
        assertNotNull(todoList);
       assertFalse(todoList.isEmpty());
    }

    @Test
    public void testTodoCrudOperations() throws Exception {
      //  worker.addTODO("testTod","testTodoName");
        //get id of created todo
//        Connection connection = getConnection(JdbcConfiguration.URL, JdbcConfiguration.USERNAME, JdbcConfiguration.PASSWORD);
//        Statement statement = connection.createStatement();
//        ResultSet ret = statement.executeQuery("SELECT id FROM test.todo where todo='main menu'");
//        System.out.println(ret.getString("id"));// WTF??!   WTF??!        WTF??!
          //  worker.deleteTODO(ret.getString("id"));

    }
}



//    @Test
//    public void testAddTODO() throws Exception {
//        TODOdbWorker todOdbWorker = new TODOdbWorker();
//        todOdbWorker.addTODO("zieg1", "heil1");
//
//        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//             Statement statement = connection.createStatement()) {
//
//            ResultSet resultSet = statement.executeQuery("select * from tablesmvj.dbtodo");
//            assertEquals("zieg1", resultSet.getString(2));
//            assertEquals("he21321321321312312312il1", resultSet.getString(3));
//            }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
