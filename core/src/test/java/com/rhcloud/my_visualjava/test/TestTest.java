package com.rhcloud.my_visualjava.test;


import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTest {

    @Test(expected = NullPointerException.class)
    public void testCheckAllQuestions() throws Exception {
        TestEntity mockTest = new TestEntity();
        Map<String, Question> questions = new HashMap<>();
        Question simpleQuestion = new Question();
        simpleQuestion.setRightAnswer("kon v palto");
        simpleQuestion.setName("kto?");

        Question simpleQuestion2 = new Question();
        simpleQuestion2.setRightAnswer("da");
        simpleQuestion2.setName("xochy?");

        mockTest.getQuestions().put(simpleQuestion2.getName(), simpleQuestion2);
        mockTest.getQuestions().put(simpleQuestion.getName(), simpleQuestion);

        Map<String, String> answersFromWeb = new HashMap<>();
        answersFromWeb.put("kto?", "kon v shlyape");
        answersFromWeb.put("xochy?", "da");

        answersFromWeb.put("xochy v  ?", "daddd");//a reason to NPE

        mockTest.checkAllQuestions(answersFromWeb);

        assertFalse(mockTest.getQuestions().get(simpleQuestion.getName()).isAnsweredRight());
        assertTrue(mockTest.getQuestions().get(simpleQuestion2.getName()).isAnsweredRight());
    }

    @Test
    public void testJson(){
        JSONParser parser = new JSONParser();
        String s = "{\" To start the execution of a thread after you create it, you must\": \"Call the start() method\",\" What method in the Thread class do you call to make the current thread cease executing for a specified amount of time?:3\": \"stop()\",\" You designate a method as being synchronized by::4\": \"Placing a synchronized section of code within it\"}";

        try{
            Object obj = parser.parse("}") ;
            JSONObject jsonObject = (JSONObject)obj;
            String name = (String) jsonObject.get("To start the execution of a thread after you create it");
            System.out.println(name);

        }
    catch (Exception e)
    {

    }
    }
}