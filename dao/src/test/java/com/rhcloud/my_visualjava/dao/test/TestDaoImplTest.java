package com.rhcloud.my_visualjava.dao.test;

import com.rhcloud.my_visualjava.dao.todo.JdbcLocalhostConfiguration;
import com.rhcloud.my_visualjava.test.Question;
import com.rhcloud.my_visualjava.test.TestEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Root on 11.11.2015.
 */
public class TestDaoImplTest {
    final String URL = JdbcLocalhostConfiguration.URL;
    final String USERNAME = JdbcLocalhostConfiguration.USERNAME;
    final String PASSWORD = JdbcLocalhostConfiguration.PASSWORD;

    TestDao testDao;
    @Before
    public void setUp() throws Exception {
testDao = new TestDaoImpl();
        testDao.changeDefaultJdbcConfiguration(URL,USERNAME,PASSWORD);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAllTests() throws Exception {
        Set<TestEntity> tests=testDao.getAllTests();
        assertNotNull(tests);
        assertEquals(tests.size(),1);
        for (TestEntity testEntity : tests) {
         Question question=   testEntity.getQuestions().get("my_question");
        assertNotNull(question);
            assertTrue(question.getName().equals("my_question"));

            for (Question tempQuestion : testEntity.getQuestions().values()) {
                assertNotNull(tempQuestion.getRightAnswer());
                assertEquals(tempQuestion.getRightAnswer(),"right_answer");
                assertFalse(tempQuestion.getAnswers().isEmpty());
            }
        }


    }

    @Test
    public void getRightAnswerTest() throws Exception {
        Question mockQuestion = new Question();
        mockQuestion.setName("my_question");
       String rightAnswer=testDao.getRightAnswer(mockQuestion);
        assertNotNull(rightAnswer);
        assertEquals("right_answer",rightAnswer);
    }

    @Test
    public void getWrongAnswersTest() throws Exception {
        Question mockQuestion = new Question();
        mockQuestion.setName("my_question");
       Set<String> wrongAnswers=testDao.getWrongAnswers(mockQuestion);
        assertNotNull(wrongAnswers);
        assertEquals(wrongAnswers.size(),2);
    }

    @Test
    public void getQuestionsTest() throws Exception {
        TestEntity mockTest = new TestEntity();
        mockTest.setName("my_test");
        Map<String,Question> questions=testDao.getQuestions(mockTest);
        assertNotNull(questions);
        assertEquals(questions.size(),1);
        assertEquals(questions.get("my_question").getName(),"my_question");
    }

    @Test
    public void  getTestNames(){
        Set<String> testNames=testDao.getTestNames();
        assertNotNull(testNames);
        assertEquals(testNames.size(),1);
    }


    @Test
    public void addTest(){
        testDao.addTest("addTestTesting");
       // testDao.addTest("addTestTesting");
    }
}