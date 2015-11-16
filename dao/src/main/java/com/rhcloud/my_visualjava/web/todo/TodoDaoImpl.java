package com.rhcloud.my_visualjava.web.todo;


import com.rhcloud.my_visualjava.core.todo.Todo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class TodoDaoImpl implements TodoDao {
    String url = JdbcProductionConfiguration.URL;
    String username = JdbcProductionConfiguration.USERNAME;
    String password = JdbcProductionConfiguration.PASSWORD;

    @Override
    public void changeDefaultJdbcConfiguration() {
        this.url = JdbcLocalhostConfiguration.URL;
        this.username = JdbcLocalhostConfiguration.USERNAME;
        this.password = JdbcLocalhostConfiguration.PASSWORD;

    }
        @Override
    public List<Todo> getAllTodo() {

        List<Todo> todoClass = new ArrayList<>();

        //load mySql driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            statement.executeQuery("SET NAMES 'UTF8'");
            statement.executeQuery("SET CHARACTER SET 'UTF8'");

            ResultSet resultSet = statement.executeQuery("select * from todo");

            while (resultSet.next()) {
                Todo aClass = new Todo();
                aClass.setId(resultSet.getString("id"));
                aClass.setTodo(resultSet.getString("todo"));
                aClass.setName(resultSet.getString("name"));
                aClass.setIsdone(resultSet.getBoolean("isdone"));
                todoClass.add(aClass);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoClass;
    }

    @Override
    public List<Todo> getAllActiveTodo() {
        List<Todo> todoClass = new ArrayList<>();

        //load mySql driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            statement.executeQuery("SET NAMES 'UTF8'");
            statement.executeQuery("SET CHARACTER SET 'UTF8'");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM test.todo where isdone=0 ");

            while (resultSet.next()) {
                Todo aClass = new Todo();
                aClass.setId(resultSet.getString("id"));
                aClass.setTodo(resultSet.getString("todo"));
                aClass.setName(resultSet.getString("name"));
                aClass.setIsdone(resultSet.getBoolean("isdone"));
                todoClass.add(aClass);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoClass;
    }

    @Override
    public List<Todo> getAllDoneTodo() {
        List<Todo> todoClass = new ArrayList<>();

        //load mySql driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            statement.executeQuery("SET NAMES 'UTF8'");
            statement.executeQuery("SET CHARACTER SET 'UTF8'");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM test.todo where isdone=1 ");

            while (resultSet.next()) {
                Todo aClass = new Todo();
                aClass.setId(resultSet.getString("id"));
                aClass.setTodo(resultSet.getString("todo"));
                aClass.setName(resultSet.getString("name"));
                aClass.setIsdone(resultSet.getBoolean("isdone"));
                todoClass.add(aClass);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoClass;
    }


    @Override
    public void addTODO(String todo, String name) {
        try (Connection connection = getConnection(url,  username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(JdbcProductionConfiguration.INSERT_NEW)) {

            preparedStatement.setString(1, todo);
            preparedStatement.setString(2, name);
            preparedStatement.setBoolean(3, false);
            preparedStatement.executeUpdate();

            System.out.println("add to data base");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTODO(String id) {
        try (Connection connection = getConnection(url,  username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(JdbcProductionConfiguration.DEL)) {

            preparedStatement.setString(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTODO(String id, String todo, String name) {

        String update = "UPDATE todo SET todo = ?, name = ? WHERE id = " + id + "";

        try (Connection connection = getConnection(url,  username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(update)) {

            preparedStatement.setString(1, todo);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();

            System.out.println("Update data base");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void isDoneTODO(String id) {
        String update = "UPDATE todo SET isdone = ? WHERE id =" + id + "";

        try (Connection connection = getConnection(url,  username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(update)) {

            preparedStatement.setBoolean(1, true);

            preparedStatement.executeUpdate();

            System.out.println("Update data base");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




