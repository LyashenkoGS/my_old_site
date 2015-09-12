package com.mvj.database;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class TODOdbWorker implements TODOManager {

    private static final String URL = "jdbc:mysql://localhost:3306/tablesmvj";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW = "insert into dbtodo (todo, name) values (?,?)";

    private Connection connection;

    @Override
    public Map<String, String> getTODO() {
        Map<String, String> map = new HashMap<String, String>();

        String query = "select * from dbtodo";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                map.put(resultSet.getString("name"), resultSet.getString("todo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public void addTODO(String todo, String name) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);

            preparedStatement.setString(1, todo);
            preparedStatement.setString(2, name);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }




