package com.mvj.database;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class TODOdbWorker implements TODOManager {

    private static final String URL = "jdbc:mysql://192.168.0.2:3306/tablesmvj";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW = "insert into dbtodo (todo, name) values (?,?)";
    private static final String DEL = "delete from dbtodo where todo=?";

    @Override
    public Map<String, String> getTODO() {
        Map<String, String> map = new HashMap<String, String>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "select * from dbtodo";

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




