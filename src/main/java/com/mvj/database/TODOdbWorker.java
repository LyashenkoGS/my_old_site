package com.mvj.database;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class TODOdbWorker implements TODOManager {

    private static final String URL = "jdbc:mysql://127.9.81.2:3306/test?useUnicode=yes&characterEncoding=UTF-8";
    private static final String USERNAME = "adminiwG1ZaB";
    private static final String PASSWORD = "v3ykjhlpBE9q";

    private static final String INSERT_NEW = "insert into todo (todo, name) values (?,?)";
    private static final String DEL = "delete from todo where todo=?";

    @Override
    public Map<String, String> getTODO() {

        Map<String, String> map = new HashMap<String, String>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "select * from todo";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeQuery("SET NAMES 'UTF8'");
            statement.executeQuery("SET CHARACTER SET 'UTF8'");

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                map.put(resultSet.getString("todo"), resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public void addTODO(String todo, String name) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
    public void deleteTODO(String todo) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DEL)) {

            preparedStatement.setString(1, todo);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTODO(String id, String todo, String name) {

        String update = "UPDATE todo SET todo = ?, name = ? WHERE id = " + id + "";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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




