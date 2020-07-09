package com.evaluator.demo;

import com.evaluator.demo.entity.Assignment;
import com.evaluator.demo.entity.Method;
import com.evaluator.demo.entity.Parameter;
import com.evaluator.demo.entity.Suggestion;
import com.evaluator.demo.filecompiler.Java8BaseListener;
import com.evaluator.demo.filecompiler.Java8Lexer;
import com.evaluator.demo.filecompiler.Java8Parser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseListener extends Java8BaseListener {

    public List<Suggestion> suggestions = new ArrayList<>();
    Assignment assignment = new Assignment();

    @Override
    public void enterMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {

        Java8Parser.MethodHeaderContext methodHeader = ctx.methodHeader();

        String methodName = methodHeader.methodDeclarator().Identifier().getText();
        String returnType = methodHeader.result().getText();
        ArrayList<Parameter> parameters = new ArrayList<>();

        Java8Parser.FormalParameterListContext parameterList = methodHeader.methodDeclarator().formalParameterList();

        if(parameterList != null){
            if(parameterList.formalParameters() != null){
                List<Java8Parser.FormalParameterContext> formalParameterContexts = parameterList.formalParameters().formalParameter();

                Iterator<Java8Parser.FormalParameterContext> iterator = formalParameterContexts.iterator();

                while (iterator.hasNext()){
                    Java8Parser.FormalParameterContext formalParameter = iterator.next();
                    String type = formalParameter.unannType().getText();
                    String variable = formalParameter.variableDeclaratorId().getText();
                    Parameter parameter = new Parameter(type,variable);
                    parameters.add(parameter);
                }
            }
            Java8Parser.LastFormalParameterContext lastFormalParameter = parameterList.lastFormalParameter();

            if(lastFormalParameter != null){
                String type = lastFormalParameter.formalParameter().unannType().getText();
                String variable = lastFormalParameter.formalParameter().variableDeclaratorId().getText();
                Parameter parameter = new Parameter(type,variable);
                parameters.add(parameter);
            }

        }
        Method method = new Method();
        method.setMethodName(methodName);
        method.setReturnType(returnType);
        method.setParameters(parameters);

        this.gradeMethod(method);

    }

    public void gradeMethod(Method method){

        if(assignment.methods.containsKey(method.getMethodName())){
            int totalMarks = 0;
            Method assignmentMethod = assignment.methods.get(method.getMethodName());

            if(assignmentMethod.getMethodName().equals(method.getMethodName())){
                totalMarks += 1;
                Suggestion suggestion = new Suggestion(method.getMethodName(),assignmentMethod.getMethodName(),1,"Method Declaration");
                suggestions.add(suggestion);
            }
            else {
                Suggestion suggestion = new Suggestion(method.getMethodName(),assignmentMethod.getMethodName(),0,"Method Declaration");
                suggestions.add(suggestion);
            }
            if(isParametersEqual(method.getParameters(),assignmentMethod.getParameters())){
                totalMarks += 1;
                Suggestion suggestion = new Suggestion(method.parametersToString(),assignmentMethod.parametersToString(),1,"Method Parameters - "  + method.getMethodName());
                suggestions.add(suggestion);
            }
            else {
                Suggestion suggestion = new Suggestion(method.parametersToString(),assignmentMethod.parametersToString(),0,"Method Parameters - " + method.getMethodName());
                suggestions.add(suggestion);
            }
            if(method.getReturnType().equals(assignmentMethod.getReturnType())){
                totalMarks += 1;
                Suggestion suggestion = new Suggestion(method.getReturnType(),assignmentMethod.getReturnType(),1,"Method Return Type");
                suggestions.add(suggestion);
            }
            else {
                Suggestion suggestion = new Suggestion(method.getReturnType(),assignmentMethod.getReturnType(),0,"Method Return Type");
                suggestions.add(suggestion);
            }
        }
    }

    public boolean isParametersEqual(ArrayList<Parameter> listA, ArrayList<Parameter> listB){
        return listA.containsAll(listB) && listB.containsAll(listA);
    }
}
