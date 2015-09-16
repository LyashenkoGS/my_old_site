package com.mvj.database;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class TODOdbWorker implements TODOManager {

    private static final String URL = "jdbc:mysql://127.0.0.1:8742/test";
    private static final String USERNAME = "adminiwG1ZaB";
    private static final String PASSWORD = "v3ykjhlpBE9q";

    private static final String INSERT_NEW = "insert into todo (todo, name) values (?,?)";
    private static final String DEL = "delete from todo where todo=?";

    @Override
    public Map<String, String> getTODO() {

        try {
            SQLConnection.portForvatdingOverSsh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<String, String>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "select * from todo";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

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

            //preparedStatement.executeQuery();
            preparedStatement.setString(1, todo);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }




