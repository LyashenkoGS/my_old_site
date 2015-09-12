package com.mvj.database;

import org.junit.Test;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TODOdbWorkerTest {

    private static final String URL = "jdbc:mysql://localhost:3306/tablesmvj";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    @Test
    public void testGetTODO() throws Exception {
        TODOdbWorker todOdbWorker = new TODOdbWorker();
        Map<String,String> maps = new HashMap<String,String>();
        assertTrue(todOdbWorker.getTODO().getClass().equals(maps.getClass()));
    }

    @Test
    public void testAddTODO() throws Exception {
        TODOdbWorker todOdbWorker = new TODOdbWorker();
        todOdbWorker.addTODO("zieg", "heil");

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("select * from dbtodo");
            assertEquals("zieg", resultSet.getString(2));
            assertEquals("heil", resultSet.getString(3));
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}