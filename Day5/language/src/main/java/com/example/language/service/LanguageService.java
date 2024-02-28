package com.example.language.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.language.model.Language;
import com.example.language.repository.LanguageRepo;

@Service
public class LanguageService {
    @Autowired
    private LanguageRepo languageRepo;

    public Language postlanguage(Language language) {
        return languageRepo.save(language);
    }

    public List<Language> getlanguages() {
        return languageRepo.findAll();
    }

    public Language getlanguageById(int languageId) {
        return languageRepo.findById(languageId).orElse(null);
    }

    public List<Language> getAllLanguages() {
        return languageRepo.findAll();
    }

    public Language getLanguageById(int patientId) {
        return languageRepo.findById(patientId).orElse(null);
    }

    public Language putlanguage(int languageId, Language language) {
        Optional<Language> optionallanguage = languageRepo.findById(languageId);
        if (optionallanguage.isPresent()) {
            Language existinglanguage = optionallanguage.get();
            existinglanguage.setlanguageName(language.getlanguageName());
            existinglanguage.setlanguageEmail(language.getlanguageEmail());
            existinglanguage.setSalary(language.getSalary());
            existinglanguage.setDepartment(language.getDepartment());
            return languageRepo.save(existinglanguage);
        } else {
            return null;
        }
    }

    public boolean deletelanguage(int id) {
        Optional<Language> optionallanguage = languageRepo.findById(id);
        if (optionallanguage.isPresent()) {
            languageRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
