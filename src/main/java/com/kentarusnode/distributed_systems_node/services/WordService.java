package com.kentarusnode.distributed_systems_node.services;

import java.util.ArrayList;
import java.util.Arrays;

import com.kentarusnode.distributed_systems_node.constants.ConfigConstants;
import com.kentarusnode.distributed_systems_node.constants.ResponseConstants;

import org.springframework.stereotype.Service;

@Service
public class WordService {
    private ArrayList<String> words = new ArrayList<>(Arrays.asList("Please"));

    public ArrayList<String> getWords() {
        return words;
    }

    public String deleteWords() {
        words.clear();
        return ResponseConstants.OK;
    }

    public String deleteWord(String delWord) {
        String result = ResponseConstants.NOK;
        for (int i = 0; i < this.words.size(); i++) {
            if (this.words.get(i).equals(delWord)) {
                this.words.remove(i);
                result = ResponseConstants.OK;
                break;
            }
        }

        return result;
    }

    public int postWords(ArrayList<String> words, int startIndex) {
        for (int i = startIndex; i < words.size(); i++) {
            if (this.words.size() >= ConfigConstants.maxLimit) {
                // Max limit storage reached. Let the main server try the next node with
                // startIndex from current one.
                return i;
            }
            this.words.add(words.get(i));
        }
        return words.size();
    }

}
