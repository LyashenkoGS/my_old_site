package com.rhcloud.my_visualjava.test;


import java.util.HashSet;
import java.util.Set;

public class Question {
    private String name;
   private Set<String> answers= new HashSet<>();
    private boolean answeredRight=false;

    public boolean isAnsweredRight() {
        return answeredRight;
    }

    public void setAnsweredRight(boolean answeredRight) {
        this.answeredRight = answeredRight;
    }


    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    private String rightAnswer;

    public Set<String> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<String> answers) {
        this.answers = answers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
