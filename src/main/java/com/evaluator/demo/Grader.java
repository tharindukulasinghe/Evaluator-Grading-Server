package com.evaluator.demo;

import com.evaluator.demo.entity.Suggestion;
import com.evaluator.demo.filecompiler.Java8Lexer;
import com.evaluator.demo.filecompiler.Java8Parser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.List;

public class Grader {

    public List<Suggestion> grade(String javaFile){
        Java8Lexer java8Lexer = new Java8Lexer(CharStreams.fromString(javaFile));

        CommonTokenStream tokens = new CommonTokenStream(java8Lexer);

        Java8Parser parser = new Java8Parser(tokens);
        ParseTree tree = parser.compilationUnit();

        ParseTreeWalker walker = new ParseTreeWalker();
        BaseListener listener = new BaseListener();

        walker.walk(listener, tree);

        return listener.suggestions;
    }
}
