package com.mvj.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.mvj.database.JdbcConfiguration.*;
import static java.sql.DriverManager.getConnection;

public class TODOdbWorker implements TODOManager {

    public static void main(String[] args) {
        TODOdbWorker todOdbWorker = new TODOdbWorker();
        System.out.println(todOdbWorker.getTODO());
    }

    @Override
    public List<TodoClass> getTODO() {

        List<TodoClass> todoClass = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "select * from todo";

        try (Connection connection = getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeQuery("SET NAMES 'UTF8'");
            statement.executeQuery("SET CHARACTER SET 'UTF8'");

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                TodoClass aClass = new TodoClass();
                aClass.setId(resultSet.getString("id"));
                aClass.setTodo(resultSet.getString("todo"));
                aClass.setName(resultSet.getString("name"));
                todoClass.add(aClass);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoClass;
    }

    @Override
    public void addTODO(String todo, String name) {
        try (Connection connection = getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW)) {

            preparedStatement.setString(1, todo);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();

            System.out.println("add to data base");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTODO(String id) {
        try (Connection connection = getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DEL)) {

            preparedStatement.setString(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTODO(String id, String todo, String name) {

        String update = "UPDATE todo SET todo = ?, name = ? WHERE id = " + id + "";

        try (Connection connection = getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(update)) {

            preparedStatement.setString(1, todo);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();

            System.out.println("Update data base");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




