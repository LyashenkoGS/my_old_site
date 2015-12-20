package com.rhcloud.my_visualjava.web.test.my_visualjava.web.test;

import com.rhcloud.my_visualjava.web.test.my_visualjava.dao.test.TestDao;
import com.rhcloud.my_visualjava.web.test.my_visualjava.dao.test.TestDaoImpl;
import com.rhcloud.my_visualjava.web.test.my_visualjava.test.Question;
import com.rhcloud.my_visualjava.web.test.my_visualjava.test.TestEntity;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class JsonParseTest {
    @Test
    public void parseReadJsonTest() {

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse("{\"testName\":\"my_test\",\"Can we have multiple classes in same java file?\":\"False\",\"Primitive variables are stored on Stack\":\"True\",\"my_question\":\"right_answer\"}");
            JSONObject jsonObject = (JSONObject) obj;
            Map<String, String> questionAnswer = new HashMap<>();

            String testName = (String) jsonObject.get("testName");
            for (Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext(); ) {
                String key = (String) iterator.next();
                if (!key.equals("testName")) {
                    questionAnswer.put(key, (String) jsonObject.get(key));
                }
            }

            for (String s : questionAnswer.keySet()) {
                // System.out.println(s);
                //  System.out.println(questionAnswer.get(s));
            }

            TestDao testDao = TestDaoImpl.getInstance();
            Set<TestEntity> testEntitySet = testDao.getAllTests();
            for (TestEntity testEntity : testEntitySet) {
                if (testEntity.getName().equals(testName)) {
                    System.out.println(testEntity.getName());
                    testEntity.checkAllQuestions(questionAnswer);
                    for (Map.Entry<String, Question> entry : testEntity.getQuestions().entrySet()) {
                        System.out.println(entry.getValue().getName());
                        System.out.println(entry.getValue().isAnsweredRight());

                    }
                }

            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}