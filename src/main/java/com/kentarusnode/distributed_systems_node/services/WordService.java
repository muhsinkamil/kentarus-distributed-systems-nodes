package com.kentarusnode.distributed_systems_node.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class WordService {
    private ArrayList<String> words = new ArrayList<>(Arrays.asList("Please"));

    public ArrayList<String> getWords() {
        return words;
    }

    public String deleteWords() {
        words.clear();
        return "OK";
    }

    public String deleteWord(String delWord) {
        for (String word : words) {
            if (word == delWord) {
                words.remove(delWord);
            }
        }

        return "OK";
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

}
