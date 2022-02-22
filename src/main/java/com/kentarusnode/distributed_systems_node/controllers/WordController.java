package com.kentarusnode.distributed_systems_node.controllers;

import com.kentarusnode.distributed_systems_node.services.WordService;
import com.kentarusnode.distributed_systems_node.structures.GetWordsResponseStructure;
import com.kentarusnode.distributed_systems_node.structures.PostWordsRequestStructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/words")
public class WordController {

    @Autowired
    WordService wordService;

    @GetMapping()
    public GetWordsResponseStructure getWords() {
        return wordService.getWords();
    }

    @DeleteMapping()
    public String deleteWords() {
        return wordService.deleteWords();
    }

    @DeleteMapping(value = "{wordValue}")
    public String deleteWord(@PathVariable String wordValue) {
        return wordService.deleteWord(wordValue);
    }

    @PostMapping()
    public int postWords(@RequestBody PostWordsRequestStructure body) {
        return wordService.postWords(body.getWords(), body.getStartIndex());
    }
}
