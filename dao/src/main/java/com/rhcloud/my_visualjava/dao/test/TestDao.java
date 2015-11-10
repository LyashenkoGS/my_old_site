package com.rhcloud.my_visualjava.dao.test;

import com.rhcloud.my_visualjava.test.TestEntity;

import java.util.Set;

public interface TestDao {
Set<TestEntity> getAllTests();

   TestEntity getTestByName(String testName);
}
