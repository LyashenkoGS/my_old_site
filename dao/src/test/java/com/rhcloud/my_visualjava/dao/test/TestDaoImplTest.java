package com.rhcloud.my_visualjava.dao.test;

import com.rhcloud.my_visualjava.dao.todo.JdbcLocalhostConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Root on 11.11.2015.
 */
public class TestDaoImplTest {
    final String URL = JdbcLocalhostConfiguration.URL;
    final String USERNAME = JdbcLocalhostConfiguration.USERNAME;
    final String PASSWORD = JdbcLocalhostConfiguration.PASSWORD;

    TestDao testDao;
    @Before
    public void setUp() throws Exception {
testDao = new TestDaoImpl();
        testDao.changeDefaultJdbcConfiguration(URL,USERNAME,PASSWORD);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAllTests() throws Exception {
testDao.getAllTests();
    }
}