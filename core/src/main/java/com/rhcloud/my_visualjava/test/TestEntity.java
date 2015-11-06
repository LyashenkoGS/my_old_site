package com.rhcloud.my_visualjava.test;

import java.util.HashMap;
import java.util.Map;

public class TestEntity {
    private String name;
    private Map<String, Question> questions = new HashMap<>();

    public Map<String, Question> getQuestions() {
        return questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*
Iterate over all the inputed answered questionsfinding a matched
 question and compare input answer with the right answer from Question entity
 Can throw NPE in case if didn't find appropriate question in TestEntity
 */

    public void checkAllQuestions(Map<String, String> answeredQuestions) throws NullPointerException {
        for (Map.Entry<String, String> stringEntry : answeredQuestions.entrySet()) {
            String inputQuestionName = stringEntry.getKey();
            Question questionByInputName = questions.get(inputQuestionName);
            String rightAnswer = questionByInputName.getRightAnswer();
            String inputAnswer = stringEntry.getValue();
            //set true if answer is equals to the right answer
            questionByInputName.setAnsweredRight(rightAnswer.equals(inputAnswer));
        }
    }

}

