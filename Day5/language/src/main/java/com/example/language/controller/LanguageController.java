package com.example.language.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.language.model.Language;
import com.example.language.service.LanguageService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping("/postlanguage")
    public ResponseEntity<Language> post(@RequestBody Language language) {

        try {
            Language store = languageService.postlanguage(language);
            return new ResponseEntity<>(store, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/language")
    public ResponseEntity<List<Language>> getAllLanguagess() {
        List<Language> patients = languageService.getAllLanguages();
        if (!patients.isEmpty()) {
            return new ResponseEntity<>(patients, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/language/{languageId}")
    public ResponseEntity<Language> getById(@PathVariable int languageId) {
        Language patient = languageService.getLanguageById(languageId);
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/putlanguage/{languageId}")
    public ResponseEntity<Language> put(@PathVariable int languageId, @RequestBody Language language) {
        Language updatedlanguage = languageService.putlanguage(languageId, language);
        if (updatedlanguage != null) {
            return ResponseEntity.ok(updatedlanguage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletelanguage/{languageId}")
    public ResponseEntity<Boolean> delete(@PathVariable("languageId") int languageId) {
        boolean deleted = languageService.deletelanguage(languageId);
        if (deleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

}
