package com.arcane.arithmetic;

public class Fill_Question {
    private String question;
    private String answer;
    private String difficulty;
    private int question_id;
    private String subject;

    public String getQuestion(){return this.question;}
    public void setQuestion(String question){ this.question = question;}
    public String getAnswer(){return this.answer;}
    public void setAnswer(String answer){this.answer = answer;}
    public String getDifficulty(){return this.difficulty;}
    public int getQuestion_id(){return this.question_id;}
    public void setQuestion_id(int question_id){this.question_id = question_id;}
    public String getSubject(){return this.subject;}

}
