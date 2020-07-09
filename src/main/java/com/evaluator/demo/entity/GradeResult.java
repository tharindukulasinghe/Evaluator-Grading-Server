package com.evaluator.demo.entity;

import java.util.List;

public class GradeResult {

    private int totalMarks;
    private List<Suggestion> suggestionList;

    public GradeResult(int totalMarks, List<Suggestion> suggestionList) {
        this.totalMarks = totalMarks;
        this.suggestionList = suggestionList;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public List<Suggestion> getSuggestionList() {
        return suggestionList;
    }

    public void setSuggestionList(List<Suggestion> suggestionList) {
        this.suggestionList = suggestionList;
    }
}
