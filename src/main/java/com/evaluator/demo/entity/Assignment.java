package com.evaluator.demo.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Assignment {

    public HashMap<String, Method> methods = new HashMap<>();

    public ArrayList<String> menu = new ArrayList<>();

    public ArrayList<String> areaOfaCircleInput = new ArrayList<>();
    public ArrayList<String> areaOfaCircleOutput = new ArrayList<>();

    public ArrayList<String> areaOfaRectangleInput = new ArrayList<>();
    public ArrayList<String> areaOfaRectangleOutput = new ArrayList<>();

    public ArrayList<String> areaOfaTriangleInput = new ArrayList<>();
    public ArrayList<String> areaOfaTriangleOutput = new ArrayList<>();

    public ArrayList<String> exitInput = new ArrayList<>();
    public ArrayList<String> exitOutput = new ArrayList<>();

    public Assignment(){
        Method getAreaOfCircle = new Method();
        getAreaOfCircle.setMethodName("getAreaOfCircle");
        Parameter radius = new Parameter("double","radius");
        ArrayList<Parameter> p1 = new ArrayList<>();
        p1.add(radius);
        getAreaOfCircle.setParameters(p1);
        getAreaOfCircle.setReturnType("double");
        methods.put("getAreaOfCircle",getAreaOfCircle);

        Method getAreaOfRectangle = new Method();
        getAreaOfRectangle.setMethodName("getAreaOfRectangle");
        Parameter length = new Parameter("double","length");
        Parameter width = new Parameter("double","width");
        ArrayList<Parameter> p2 = new ArrayList<>();
        p2.add(length);
        p2.add(width);
        getAreaOfRectangle.setParameters(p2);
        getAreaOfRectangle.setReturnType("double");
        methods.put("getAreaOfRectangle",getAreaOfRectangle);

        Method getAreaOfTriangle = new Method();
        getAreaOfTriangle.setMethodName("getAreaOfTriangle");
        Parameter base = new Parameter("double","base");
        Parameter height = new Parameter("double","height");
        ArrayList<Parameter> p3 = new ArrayList<>();
        p3.add(base);
        p3.add(height);
        getAreaOfTriangle.setParameters(p3);
        getAreaOfTriangle.setReturnType("double");
        methods.put("getAreaOfTriangle",getAreaOfTriangle);

        menu.add("Geometry Calculator");
        menu.add("1. Calculate the Area of a Circle");
        menu.add("2. Calculate the Area of a Rectangle");
        menu.add("3. Calculate the Area of a Triangle");
        menu.add("4. Quit");

        areaOfaCircleInput.add("1");
        areaOfaCircleInput.add("7");

        areaOfaCircleOutput.add("Geometry Calculator");
        areaOfaCircleOutput.add("1. Calculate the Area of a Circle");
        areaOfaCircleOutput.add("2. Calculate the Area of a Rectangle");
        areaOfaCircleOutput.add("3. Calculate the Area of a Triangle");
        areaOfaCircleOutput.add("4. Quit");
        areaOfaCircleOutput.add("153.93804002589985");

        areaOfaRectangleInput.add("2");
        areaOfaRectangleInput.add("4");
        areaOfaRectangleInput.add("5");

        areaOfaRectangleOutput.add("Geometry Calculator");
        areaOfaRectangleOutput.add("1. Calculate the Area of a Circle");
        areaOfaRectangleOutput.add("2. Calculate the Area of a Rectangle");
        areaOfaRectangleOutput.add("3. Calculate the Area of a Triangle");
        areaOfaRectangleOutput.add("4. Quit");
        areaOfaRectangleOutput.add("20.0");

        areaOfaTriangleInput.add("3");
        areaOfaTriangleInput.add("4");
        areaOfaTriangleInput.add("5");

        areaOfaTriangleOutput.add("Geometry Calculator");
        areaOfaTriangleOutput.add("1. Calculate the Area of a Circle");
        areaOfaTriangleOutput.add("2. Calculate the Area of a Rectangle");
        areaOfaTriangleOutput.add("3. Calculate the Area of a Triangle");
        areaOfaTriangleOutput.add("4. Quit");
        areaOfaTriangleOutput.add("10.0");

        exitInput.add("4");

        exitOutput.add("Geometry Calculator");
        exitOutput.add("1. Calculate the Area of a Circle");
        exitOutput.add("2. Calculate the Area of a Rectangle");
        exitOutput.add("3. Calculate the Area of a Triangle");
        exitOutput.add("4. Quit");
        exitOutput.add("Exiting...");

    }
}
