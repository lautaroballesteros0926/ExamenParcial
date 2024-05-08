package org.example;

public class Question {
    private String description;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String description, String[] options, int correctAnswerIndex) {
        this.description = description;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getDescription() {
        return description;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}