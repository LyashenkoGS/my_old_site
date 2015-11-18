package com.rhcloud.my_visualjava.dao.test;

import com.rhcloud.my_visualjava.test.Question;
import com.rhcloud.my_visualjava.test.TestEntity;

import java.util.Map;
import java.util.Set;

public interface TestDao {
    void changeDefaultJdbcConfiguration();

    Set<TestEntity> getAllTests();

    String getRightAnswer(Question question);

    Set<String> getWrongAnswers(Question question);

    Map<String, Question> getQuestions(TestEntity test);

    Set<String> getTestNames();

    void addTest(String name);

    void addQuestion(String testName, String question);

    void addRightAnswer(String questionName, String rightAnswer);

    void addWrongAnswer(String questionName, String wrongAnswer);

    void delTest(String name);

    void delQuestion(String question);

    void delRightAnswer(String rightAnswer);

    void delWrongAnswer(String wrongAnswer);

    void updateTest(String oldName, String newName);

    void updateQuestion(String oldName, String newName);

    void updateRightAnswer(String oldName, String newName);

    void updateWrongAnswer(String oldName, String newName);


}
