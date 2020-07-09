package com.evaluator.demo;

import com.evaluator.demo.entity.Assignment;
import com.evaluator.demo.entity.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CompilerService {

    private final Path fileStorageLocation;
    Assignment assignment = new Assignment();

    @Autowired
    public CompilerService(FileStorageProperties fileStorageProperties){
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
    }

    public List<Suggestion> compile(String filename){
        ArrayList<Suggestion> suggestions = new ArrayList<>();
        try {

            Process p = Runtime.getRuntime().exec("javac -classpath " + this.fileStorageLocation + "\\ " + this.fileStorageLocation + "\\" + filename);
            p.waitFor();

            suggestions.add(areaOfaCircle());
            suggestions.add(areaOfaRectangle());
            suggestions.add(areaOfaTriangle());
            suggestions.add(menu());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return suggestions;

    }

    private Suggestion areaOfaCircle(){

        ArrayList<String> inputs = assignment.areaOfaCircleInput;
        ArrayList<String> outputs = assignment.areaOfaCircleOutput;
        ArrayList<String> processOutputs = new ArrayList<>();
        Iterator<String> iterator = inputs.iterator();
        Suggestion suggestion = new Suggestion("","",0,"Functionality - getAreaOfCircle");

        try {
            Process process = Runtime.getRuntime().exec("java -classpath " + this.fileStorageLocation + "\\ " + "Main");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            while (iterator.hasNext()){
                writer.write(iterator.next());
                if(iterator.hasNext()){
                    writer.newLine();
                }
            }
            writer.flush();
            writer.close();

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                processOutputs.add(line);
            }

            if (processOutputs.equals(outputs)){
                suggestion.setMarks(3);
                suggestion.setTitle("Functionality - getAreaOfCircle");
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return suggestion;

    }

    private Suggestion areaOfaRectangle(){

        ArrayList<String> inputs = assignment.areaOfaRectangleInput;
        ArrayList<String> outputs = assignment.areaOfaRectangleOutput;
        ArrayList<String> processOutputs = new ArrayList<>();
        Iterator<String> iterator = inputs.iterator();
        Suggestion suggestion = new Suggestion("","",0,"Functionality - getAreaOfRectangle");

        try {
            Process process = Runtime.getRuntime().exec("java -classpath " + this.fileStorageLocation + "\\ " + "Main");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            while (iterator.hasNext()){
                writer.write(iterator.next());
                if(iterator.hasNext()){
                    writer.newLine();
                }
            }
            writer.flush();
            writer.close();

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                processOutputs.add(line);
            }

            if (processOutputs.equals(outputs)){
                suggestion.setMarks(3);
                suggestion.setTitle("Functionality - getAreaOfRectangle");
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return suggestion;

    }

    private Suggestion areaOfaTriangle(){

        ArrayList<String> inputs = assignment.areaOfaTriangleInput;
        ArrayList<String> outputs = assignment.areaOfaTriangleOutput;
        ArrayList<String> processOutputs = new ArrayList<>();
        Iterator<String> iterator = inputs.iterator();
        Suggestion suggestion = new Suggestion("","",0,"Functionality - getAreaOfRectangle");

        try {
            Process process = Runtime.getRuntime().exec("java -classpath " + this.fileStorageLocation + "\\ " + "Main");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            while (iterator.hasNext()){
                writer.write(iterator.next());
                if(iterator.hasNext()){
                    writer.newLine();
                }
            }
            writer.flush();
            writer.close();

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                processOutputs.add(line);
            }

            if (processOutputs.equals(outputs)){
                suggestion.setMarks(3);
                suggestion.setTitle("Functionality - getAreaOfRectangle");
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return suggestion;

    }

    private Suggestion menu(){

        ArrayList<String> inputs = assignment.exitInput;
        ArrayList<String> outputs = assignment.exitOutput;
        ArrayList<String> processOutputs = new ArrayList<>();
        Iterator<String> iterator = inputs.iterator();
        Suggestion suggestion = new Suggestion("","",0,"Functionality - Menu");

        try {
            Process process = Runtime.getRuntime().exec("java -classpath " + this.fileStorageLocation + "\\ " + "Main");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            while (iterator.hasNext()){
                writer.write(iterator.next());
                if(iterator.hasNext()){
                    writer.newLine();
                }
            }
            writer.flush();
            writer.close();

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                processOutputs.add(line);
            }

            if (processOutputs.equals(outputs)){
                suggestion.setMarks(5);
                suggestion.setTitle("Functionality - Menu");
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return suggestion;

    }
}
