package org.example;

import java.util.*;

public class SetWords {

    public void findWords(){
        List<String> words = Arrays.asList(
                "абрикос", "киви", "банан", "ананас", "киви", "груша", "яблоко", "абрикос",
                "мандарин", "банан", "персик", "абрикос", "ананас", "груша");

        Set<String> uniqueWords = new HashSet<>(words);
        System.out.println("Список уникальных слов: " + uniqueWords);

        Map<String, Integer> wordsCount = new HashMap<>();
        for (String word : words) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("Слово встречается: " + wordsCount);
    }
}
