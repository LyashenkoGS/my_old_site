package com.rhcloud.my_visualjava.web.test.my_visualjava.dao.test;

import com.rhcloud.my_visualjava.web.test.my_visualjava.test.Question;
import com.rhcloud.my_visualjava.web.test.my_visualjava.test.TestEntity;

import java.util.Map;
import java.util.Set;

public interface TestDao {
    void changeDefaultJdbcConfiguration();

    Set<TestEntity> getAllTests();

    String getRightAnswer(Question question);

    Set<String> getWrongAnswers(Question question);

    Map<String, Question> getQuestions(TestEntity test);

    Set<String> getTestNames();
    Set<TestEntity> getAllEmptyTests();

    void addTest(String name);

    void addQuestion(String testId, String question);

    void addRightAnswer(String questionId, String rightAnswer);

    void addWrongAnswer(String questionId, String wrongAnswer);

    void delTest(String testId);

    void delQuestion(String questionId);

    void delRightAnswer(String rightAnswerId);

    void delWrongAnswer(String wrongAnswerId);

    void updateTest(String oldName, String newName);

    void updateQuestion(String oldName, String newName);

    void updateRightAnswer(String oldName, String newName);

    void updateWrongAnswer(String oldName, String newName);


}
