package com.rhcloud.my_visualjava.dao.test;


import com.rhcloud.my_visualjava.dao.todo.JdbcProductionConfiguration;
import com.rhcloud.my_visualjava.test.TestEntity;
import com.rhcloud.my_visualjava.test.com.rhcloud.my_visualjava.todo.Todo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import static java.sql.DriverManager.getConnection;

public class TestDaoImpl implements TestDao {
    String url = JdbcProductionConfiguration.URL;
    String username = JdbcProductionConfiguration.USERNAME;
    String password = JdbcProductionConfiguration.PASSWORD;
    @Override
    public void changeDefaultJdbcConfiguration(String url, String userName, String password){
        this.url=url;
        this.username=userName;
        this.password=password;
    }
    //load mySql driver



    @Override
    public Set<TestEntity> getAllTests()
    {

        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement();ResultSet resultSet =
                statement.executeQuery("SELECT * FROM test.test")) {

            while (resultSet.next()) {
                System.out.print(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
