package com.evaluator.demo.entity;

import java.util.ArrayList;
import java.util.Objects;

public class Method {

    private String methodName;
    private ArrayList<Parameter> parameters;
    private String returnType;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Method method = (Method) o;
        return getMethodName().equals(method.getMethodName()) &&
                getParameters().equals(method.getParameters()) &&
                getReturnType().equals(method.getReturnType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMethodName(), getParameters(), getReturnType());
    }

    public String parametersToString(){
        String result = "";

        for(Parameter p: parameters){
            result = result.concat(p.getType() + " ");
        }

        return result;
    }
}
