package com.rhcloud.my_visualjava.web.test.my_visualjava.dao.test;

import com.rhcloud.my_visualjava.web.test.my_visualjava.test.TestEntity;
import com.rhcloud.my_visualjava.web.test.my_visualjava.web.todo.JdbcLocalhostConfiguration;
import com.rhcloud.my_visualjava.web.test.my_visualjava.test.Question;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class TestDaoImplTest {
    final String URL = JdbcLocalhostConfiguration.URL;
    final String USERNAME = JdbcLocalhostConfiguration.USERNAME;
    final String PASSWORD = JdbcLocalhostConfiguration.PASSWORD;
    ConfigurableApplicationContext context =
            new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});

    TestDao testDao;

    @Before
    public void setUp() throws Exception {


        testDao =(TestDao)context.getBean("testDao");
    }

    @After
    public void tearDown() throws Exception {
        context.close();
    }
    @Test
    public void testGetAllTests() throws Exception {
        Set<TestEntity> tests = testDao.getAllTests();
        assertNotNull(tests);
        assertEquals(tests.size(), 1);
        for (TestEntity testEntity : tests) {
            Question question = testEntity.getQuestions().get("my_question");
            assertNotNull(question);
            assertTrue(question.getName().equals("my_question"));

            for (Question tempQuestion : testEntity.getQuestions().values()) {
                assertNotNull(tempQuestion.getRightAnswer());
                assertEquals(tempQuestion.getRightAnswer(), "right_answer");
                assertFalse(tempQuestion.getWrongAnswers().isEmpty());
            }
        }


    }

    @Test
    public void getRightAnswerTest() throws Exception {
        Question mockQuestion = new Question();
        mockQuestion.setId("1");
        String rightAnswer = testDao.getRightAnswer(mockQuestion);
        assertNotNull(rightAnswer);
        assertEquals("right_answer", rightAnswer);
    }

    @Test
    public void getWrongAnswersTest() throws Exception {
        Question mockQuestion = new Question();
        mockQuestion.setId("1");
        Set<String> wrongAnswers = testDao.getWrongAnswers(mockQuestion);
        assertNotNull(wrongAnswers);
        assertEquals(wrongAnswers.size(), 2);
    }
  @Test
    public void getQuestionsTest() throws Exception {
        TestEntity mockTest = new TestEntity();
        mockTest.setId("1");
        Map<String, Question> questions = testDao.getQuestions(mockTest);
        assertNotNull(questions);
        assertEquals(questions.size(), 1);
        assertEquals(questions.get("my_question").getName(), "my_question");
    }

    @Test
    public void getTestNames() {
        Set<String> testNames = testDao.getTestNames();
        assertNotNull(testNames);
        assertEquals(testNames.size(), 1);
    }


    @Test
            public void getAllEmptyTestesTest() {
    Set<TestEntity> allEmptyTestes=testDao.getAllEmptyTests();
        for (TestEntity emptyTest : allEmptyTestes) {
        assertEquals(emptyTest.getName(),"my_test");
        }
    }
/*
//TODO find out how to write CRUD using id
    @Test
    public void CRUDonTestEntity() {
        String addTestTesting = "addTestTesting";
        testDao.addTest(addTestTesting);
        String addQuestionTesting = "addQuestionTesting";
        testDao.addQuestion(addTestTesting, addQuestionTesting);

        String addWrongAnswerTesting = "addWrongAnswerTesting";

    */
/* assert that DB contains just added Question*//*


        TestEntity mockTestEntity = new TestEntity();
        mockTestEntity.setName(addTestTesting);
        Map<String, Question> questionMap = testDao.getQuestions(mockTestEntity);

        assertTrue(questionMap.containsKey(addQuestionTesting));
        testDao.delQuestion(addQuestionTesting);

        questionMap = testDao.getQuestions(mockTestEntity);
        assertFalse(questionMap.containsKey(addQuestionTesting));

        testDao.delTest(addTestTesting);
        assertFalse(testDao.getTestNames().contains(addTestTesting));

        String addRightAnswerTesting = "addRightAnswerTesting";
        Question mockQuestion = new Question();
        mockQuestion.setName(addQuestionTesting);

        testDao.addRightAnswer(addQuestionTesting, addRightAnswerTesting);
        assertTrue(testDao.getRightAnswer(mockQuestion).equals(addRightAnswerTesting));
        testDao.delRightAnswer(addRightAnswerTesting);
        assertNull(testDao.getRightAnswer(mockQuestion));

        testDao.addWrongAnswer(addQuestionTesting, addWrongAnswerTesting);
        assertTrue(testDao.getWrongAnswers(mockQuestion).contains(addWrongAnswerTesting));
        testDao.delWrongAnswer(addWrongAnswerTesting);
        assertTrue(testDao.getWrongAnswers(mockQuestion).isEmpty());

    }

*/

}