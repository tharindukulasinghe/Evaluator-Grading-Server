package com.evaluator.demo.controllers;

import com.evaluator.demo.CompilerService;
import com.evaluator.demo.FileStorageService;
import com.evaluator.demo.Grader;
import com.evaluator.demo.UploadFileResponse;
import com.evaluator.demo.entity.GradeResult;
import com.evaluator.demo.entity.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private CompilerService compilerService;


    @PostMapping("/uploadFile")
    public GradeResult uploadFile(@RequestParam("geometry") MultipartFile geometry, @RequestParam("driver") MultipartFile driver) {
        String fileName = fileStorageService.storeFile(geometry);
        String driverFile = fileStorageService.storeFile(driver);
        List<Suggestion> compileSuggestions = compilerService.compile(driverFile);

        List<Suggestion> astSuggestions = new ArrayList<>();

        try {
            String content = new String(geometry.getBytes());
            Grader grader = new Grader();
            astSuggestions = grader.grade(content);
        } catch (Exception e) {

        }

        List<Suggestion> combinedSuggestionList = new ArrayList<>();
        combinedSuggestionList.addAll(compileSuggestions);
        combinedSuggestionList.addAll(astSuggestions);

        int totalCompilerMarks = 0;
        for (Suggestion suggestion: compileSuggestions){
            totalCompilerMarks += suggestion.getMarks();
        }

        if(totalCompilerMarks == 14){
            Suggestion objectCreation = new Suggestion("","",5,"Object Creation");
            Suggestion methodCalls = new Suggestion("","",5,"Correct Method Calls");
            Suggestion keyBoardInputs = new Suggestion("","", 5, "Keyboard Inputs");
            Suggestion errorMessage = new Suggestion("","", 4,"Error Message");

            combinedSuggestionList.add(objectCreation);
            combinedSuggestionList.add(methodCalls);
            combinedSuggestionList.add(keyBoardInputs);
            combinedSuggestionList.add(errorMessage);
        }

        int totalMarks = 0;
        for (Suggestion suggestion: combinedSuggestionList){
            totalMarks += suggestion.getMarks();
        }

        GradeResult gradeResult = new GradeResult(totalMarks, combinedSuggestionList);
        return gradeResult;
    }


}
