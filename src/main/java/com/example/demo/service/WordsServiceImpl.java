package com.example.demo.service;

import com.example.demo.models.Word;
import com.example.demo.repositories.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WordsServiceImpl implements WordsService{
    @Autowired
    private WordsRepository wordsRepository;



    public Status addWord(String word) {
        Status status = new Status();
        List<Word> words = wordsRepository.findAll();
        if (words.size() != 0) {
            Word word1 = words.get(0);
            String word2 = word1.getWord();
            if (word.startsWith(word2.substring(word2.length()-1, word2.length()))) {
                status.setStatus(true);
                status.setMessage("Пишите следующее слово! Последнее слово: " + word);
                status.setAllMessage("Пишите следующее слово! Последнее слово: " + word);
                word1.setWord(word);
//                Word obj = Word.builder().id(1).word(word).build();
                wordsRepository.save(word1);
            } else {
                status.setStatus(false);
                status.setMessage("Слово не подошло, последяя и первая буква не совпадают. Последнее слово: " + word2);
                status.setAllMessage("Тупое слово");
            }
        } else {
            status.setStatus(true);
            status.setMessage("Игра началась! Пишите следующее слово! Последнее слово: " + word);
            status.setAllMessage("Игра началась! Пишите следующее слово! Последнее слово: " + word);
            Word obj = Word.builder().id((long) 1).word(word).build();
            wordsRepository.save(obj);
        }
        return status;
    }

    public void checkAndAddWord(String word) {

    }
}
