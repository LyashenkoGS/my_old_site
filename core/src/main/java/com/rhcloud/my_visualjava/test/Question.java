package com.rhcloud.my_visualjava.test;


import java.util.HashSet;
import java.util.Set;

public class Question {
    private String id;
    private String name;
    private Set<String> wrongAnswers = new HashSet<>();
    private boolean answeredRight = false;
    private String rightAnswer;

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



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<String> getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(Set<String> wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }
}
