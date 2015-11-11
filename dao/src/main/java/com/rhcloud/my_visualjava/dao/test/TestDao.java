package com.rhcloud.my_visualjava.dao.test;

import com.rhcloud.my_visualjava.test.TestEntity;

import java.sql.SQLException;
import java.util.Set;

public interface TestDao {
    void changeDefaultJdbcConfiguration(String url, String userName, String password);

    Set<TestEntity> getAllTests() throws SQLException;
}
