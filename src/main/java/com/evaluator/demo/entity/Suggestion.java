package com.evaluator.demo.entity;

public class Suggestion {
    private String actual;
    private String expected;
    private int marks;
    private String title;

    public Suggestion(String actual, String expected, int marks, String title) {
        this.actual = actual;
        this.expected = expected;
        this.marks = marks;
        this.title = title;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
