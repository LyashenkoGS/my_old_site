package com.rhcloud.my_visualjava.dao.test;

import com.rhcloud.my_visualjava.test.Question;
import com.rhcloud.my_visualjava.test.TestEntity;
import com.rhcloud.my_visualjava.web.todo.JdbcLocalhostConfiguration;
import com.rhcloud.my_visualjava.web.todo.JdbcProductionConfiguration;

import java.sql.*;
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
    public void changeDefaultJdbcConfiguration() {
        this.url = JdbcLocalhostConfiguration.URL;
        this.username = JdbcLocalhostConfiguration.USERNAME;
        this.password = JdbcLocalhostConfiguration.PASSWORD;
    }

    @Override
    public Set<TestEntity> getAllTests() {
        Set<TestEntity> allTests = new HashSet<>();
        Set<String> testsNames = this.getTestNames();

        Set<TestEntity> testEntitiesSet = getAllEmptyTests();
        for (TestEntity testEntity : testEntitiesSet) {

            /*
            add questions
             */

            Map<String, Question> questionMap = getQuestions(testEntity);

            for (Question question : questionMap.values()) {
                question.setRightAnswer(getRightAnswer(question));
                question.setWrongAnswers(getWrongAnswers(question));
            }
            testEntity.setQuestions(questionMap);

            allTests.add(testEntity);
        }
        return allTests;
    }

    @Override
    public String getRightAnswer(Question question) {
        String rightAnswer = null;
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement(); ResultSet resultSet =
                     statement.executeQuery("SELECT name FROM test.answer where question_id='" + question.getId() + "' " +
                             "AND  answer_type_id=1;")) {
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
                     statement.executeQuery("SELECT name FROM test.answer where question_id='"
                             + question.getId() + "' AND  answer_type_id=2;")) {

            while (resultSet.next()) {
                wrongAnswers.add(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wrongAnswers;
    }

    @Override
    public Map<String, Question> getQuestions(TestEntity test) {
        Set<Question> questions = new HashSet<>();
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement(); ResultSet resultSet =
                     statement.executeQuery("SELECT name,id FROM test.question where test_id='" + test.getId() + "';")) {

            while (resultSet.next()) {
                Question tempQuestion = new Question();
                tempQuestion.setId(resultSet.getString("id"));
                tempQuestion.setName(resultSet.getString("name"));
                questions.add(tempQuestion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String, Question> questionMap = new HashMap<>();
        /*
        parse Set<Question> to Map<String, Question> where key is question name
         */
        for (Question question : questions) {
            questionMap.put(question.getName(), question);
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
    public Set<TestEntity> getAllEmptyTests() {
        Set<TestEntity> allEmptyTests = new HashSet<>();
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement(); ResultSet resultSet =
                     statement.executeQuery("SELECT id,name FROM test.test ;")) {

            while (resultSet.next()) {
                TestEntity tempTestEntity = new TestEntity();
                tempTestEntity.setId(resultSet.getString("id"));
                tempTestEntity.setName(resultSet.getString("name"));
                allEmptyTests.add(tempTestEntity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEmptyTests;
    }

    @Override
    public void addTest(String name) {
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement()
        ) {
            connection.setAutoCommit(false);
            statement.executeUpdate("INSERT INTO test.test (name)\n" +
                    "VALUES (" + "'" + name + "'" + ");");
            try {
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addQuestion(String testId, String question) {
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement()
        ) {
            connection.setAutoCommit(false);
            statement.executeUpdate("insert into test.question (name,test_id) values('" + question + "','" + testId + "') ");
            try {
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addRightAnswer(String questionId, String rightAnswer) {
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement()
        ) {
            connection.setAutoCommit(false);
            statement.executeUpdate("insert into test.answer  (name,question_id,answer_type_id) values( '" + rightAnswer + "', '" + questionId + "',1)");
            try {
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addWrongAnswer(String questionId, String wrongAnswer) {
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement()
        ) {
            connection.setAutoCommit(false);
            statement.executeUpdate("insert into test.answer\n" +
                    "(name,question_id,answer_type_id) values('" + wrongAnswer + "','" + questionId + "',2)");
            try {
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delTest(String name) {
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement()
        ) {
            connection.setAutoCommit(false);
            statement.executeUpdate("DELETE FROM test.test\n" +
                    "where name= (" + "'" + name + "'" + ");");
            try {
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delQuestion(String question) {
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement()
        ) {
            connection.setAutoCommit(false);
            statement.executeUpdate("DELETE FROM test.question\n" +
                    "where name= (" + "'" + question + "'" + ");");
            try {
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delRightAnswer(String rightAnswer) {
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement()
        ) {
            connection.setAutoCommit(false);
            statement.executeUpdate("DELETE FROM test.answer\n" +
                    "where name= (" + "'" + rightAnswer + "'" + ");");
            try {
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delWrongAnswer(String wrongAnswer) {
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement()
        ) {
            connection.setAutoCommit(false);
            statement.executeUpdate("DELETE FROM test.answer\n" +
                    "where name= (" + "'" + wrongAnswer + "'" + ");");
            try {
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTest(String oldName, String newName) {

        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
           statement.executeUpdate("UPDATE test.test SET name = '"+newName+"' WHERE name = '" + oldName + "';");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateQuestion(String oldName, String newName) {
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("UPDATE test.question SET name = '" + newName + "' WHERE name = '" + oldName + "';");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRightAnswer(String oldName, String newName) {
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("UPDATE test.answer SET name = '" + newName + "' WHERE name = '" + oldName + "';");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateWrongAnswer(String oldName, String newName) {
        try (Connection connection = getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("UPDATE test.test SET name = '" + newName + "' WHERE name = '" + oldName + "';");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}