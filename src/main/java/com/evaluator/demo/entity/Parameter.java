package com.evaluator.demo.entity;

import java.util.Objects;

public class Parameter {

    private String type;
    private String variable;

    public Parameter(String type, String variable) {
        this.type = type;
        this.variable = variable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        return getType().equals(parameter.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getVariable());
    }
}
