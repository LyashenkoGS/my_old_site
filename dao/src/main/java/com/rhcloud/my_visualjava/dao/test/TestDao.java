package com.rhcloud.my_visualjava.dao.test;

import com.rhcloud.my_visualjava.test.Question;
import com.rhcloud.my_visualjava.test.TestEntity;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public interface TestDao {
    void changeDefaultJdbcConfiguration(String url, String userName, String password);

    Set<TestEntity> getAllTests();

    String getRightAnswer(Question question);

    Set<String> getWrongAnswers(Question question);

    Map<String, Question> getQuestions(TestEntity test);

    Set<String> getTestNames();

    void addTest(String name);

    void addQuestion(String testName, String Question);

    void addRightAnswer(String questionName, String rightAnswer);

    void addWrongAnswer(String questionName, String wrongAnswer);

    void delTest(String name);

    void delQuestion(String testName, String Question);

    void delRightAnswer(String questionName, String rightAnswer);

    void delWrongAnswer(String questionName, String wrongAnswer);



}
