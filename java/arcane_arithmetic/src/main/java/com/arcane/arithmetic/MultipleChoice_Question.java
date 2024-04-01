package com.arcane.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultipleChoice_Question {
    private String question;
    private String answer;
    private String difficulty;
    private int question_id;

    private List<String> options = new ArrayList<>();
    private String subject;

    public String getQuestion(){return this.question;}
    public void setQuestion(String question){ this.question = question;}
    public String getAnswer(){return this.answer;}
    public void setAnswer(String answer){this.answer = answer;}
    public String getDifficulty(){return this.difficulty;}
    public int getQuestion_id(){return this.question_id;}
    public void setQuestion_id(int question_id){this.question_id = question_id;}
    public List<String> getOptions(){return this.options;}
    public void setOptions(String option){
        this.options = Arrays.asList(option.split(",",-1));
    }
    public String getSubject(){return this.subject;}
}
