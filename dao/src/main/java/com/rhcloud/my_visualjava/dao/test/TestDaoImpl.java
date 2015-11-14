package com.rhcloud.my_visualjava.dao.test;


import com.rhcloud.my_visualjava.dao.todo.JdbcLocalhostConfiguration;
import com.rhcloud.my_visualjava.dao.todo.JdbcProductionConfiguration;
import com.rhcloud.my_visualjava.test.Question;
import com.rhcloud.my_visualjava.test.TestEntity;
import com.rhcloud.my_visualjava.test.com.rhcloud.my_visualjava.todo.Todo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.sql.DriverManager.getConnection;

public class TestDaoImpl implements TestDao {
    String url = JdbcProductionConfiguration.URL;
    String username = JdbcProductionConfiguration.USERNAME;
    String password = JdbcProductionConfiguration.PASSWORD;

    @Override
    public void changeDefaultJdbcConfiguration(String url, String userName, String password) {
        this.url = url;
        this.username = userName;
        this.password = password;
    }


    @Override
    public Set<TestEntity> getAllTests() {
Set<TestEntity> allTests = new HashSet<>();
        Set<String> testsNames = new HashSet<>();
        testsNames=this.getTestNames();
        for (String testName : testsNames) {
            TestEntity tempTestEntity = new TestEntity();
            tempTestEntity.setName(testName);

            /*
            add questions
             */
            Map<String,Question> questionMap = new HashMap<>();
            questionMap=getQuestions(tempTestEntity);

            for (Question question : questionMap.values()) {
                question.setRightAnswer(getRightAnswer(question));
                question.setAnswers(getWrongAnswers(question));
            }


            tempTestEntity.setQuestions(questionMap);


            allTests.add(tempTestEntity);
        }
        return allTests;
    }

    @Override
    public String getRightAnswer(Question question) {
        String rightAnswer = null;
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement(); ResultSet resultSet =
                     statement.executeQuery("SELECT name FROM test.right_answer where question_name='" + question.getName() + "';")) {

            while (resultSet.next()) {
                rightAnswer = resultSet.getString("name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rightAnswer;
    }

    @Override
    public Set<String> getWrongAnswers(Question question) {
        Set<String> wrongAnswers = new HashSet<>();
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement(); ResultSet resultSet =
                     statement.executeQuery("SELECT name FROM test.wrong_answer where question_name='"
                             + question.getName() + "';")) {

            while (resultSet.next()) {
                wrongAnswers.add(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wrongAnswers;
    }

    @Override
    public Map<String,Question> getQuestions(TestEntity test) {
        Set<Question> questions = new HashSet<>();
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement(); ResultSet resultSet =
                     statement.executeQuery("SELECT name FROM test.question where test_name='my_test';")) {

            while (resultSet.next()) {
                Question tempQuestion = new Question();
                tempQuestion.setName(resultSet.getString("name"));
                questions.add(tempQuestion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String,Question> questionMap= new HashMap<>();
        /*
        parse Set<Question> to Map<String, Question> where key is question name
         */
        for (Question question : questions) {
         questionMap.put(question.getName(),question);
        }
        return questionMap;
    }

    @Override
    public Set<String> getTestNames() {
        Set<String> testNames = new HashSet<>();
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement(); ResultSet resultSet =
                     statement.executeQuery("SELECT name FROM test.test ;")) {

            while (resultSet.next()) {
                testNames.add(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testNames;
    }

    @Override
    public void addTest(String name) {
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement();
                    ) {
            statement.executeUpdate("INSERT INTO test.test (name)\n" +
                    "VALUES ("+"'"+name+"'"+");");

                    } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addQuestion(String testName, String Question) {

    }

    @Override
    public void addRightAnswer(String questionName, String rightAnswer) {

    }

    @Override
    public void addWrongAnswer(String questionName, String wrongAnswer) {

    }

    @Override
    public void delTest(String name) {

    }

    @Override
    public void delQuestion(String testName, String Question) {

    }

    @Override
    public void delRightAnswer(String questionName, String rightAnswer) {

    }

    @Override
    public void delWrongAnswer(String questionName, String wrongAnswer) {

    }


}
