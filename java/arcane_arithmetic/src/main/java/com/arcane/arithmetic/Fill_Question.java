package com.arcane.arithmetic;

/**
 * Helper class to load fill-in-the-blank questions from the database.
 * Mimics the form of the Json Object
 *
 * @author Candice Williams
 */
public class Fill_Question {
    private String question;
    private String answer;
    private String difficulty;
    private int question_id;
    private String subject;

    /**
     *returns question
     * @return question
     */
    public String getQuestion(){return this.question;}

    /**
     * sets question
     * @param question question retrived from database
     */
    public void setQuestion(String question){ this.question = question;}

    /**
     * returns answer
     * @return answer
     */
    public String getAnswer(){return this.answer;}

    /**
     * sets answer
     * @param answer answer retrived from database
     */
    public void setAnswer(String answer){this.answer = answer;}

    /**
     * gets difficulty of question
     * @return question difficulty
     * @see DifficultyController
     */
    public String getDifficulty(){return this.difficulty;}

    /**
     * gets question id from database
     * @return question id
     */
    public int getQuestion_id(){return this.question_id;}

    /**
     * sets question id
     * @param question_id question id retrived from database
     */
    public void setQuestion_id(int question_id){this.question_id = question_id;}

    /**
     * gets subject for question
     * @return the subject of the question
     */
    public String getSubject(){return this.subject;}

}
