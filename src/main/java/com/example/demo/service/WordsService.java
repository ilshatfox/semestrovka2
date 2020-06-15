package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public interface WordsService {
    public Status addWord(String word);
    public void checkAndAddWord(String word);
}
