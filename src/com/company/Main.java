package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[] words = {
                "car",
                "cheating",
                "dale",
                "deal",
                "lead",
                "listen",
                "silent",
                "teaching"
        };

        // map of charmaps to list of words with this charmap
        Map<Map<Character, Integer>, List<String>> friends = new HashMap<>();

        // add all words to their charmaps
        for (String word : words) {
            Map<Character, Integer> charmap = wordToMap(word);

            // if no friends yet - create one
            if (!friends.containsKey(charmap)) {
                List<String> list = new ArrayList<>();
                list.add(word);
                friends.put(charmap, list);
                // add to list of friends
            } else
                friends.get(charmap).add(word);
        }

        // output to print
        List<String> output = new ArrayList<>();

        for(List<String> current : friends.values()) {
            // only those that have friends
            if(current.size() > 1) {
                // sort friends alphabetically
                Collections.sort(current);

                // merge all friends into one string
                String line = "";
                for(String next : current) {
                    line += next;
                    line += " ";
                }

                output.add(line);
            }
        }

        // sort output alphabetically
        Collections.sort(output);
        for(String next: output)
            System.out.println(next);
    }

    // charmap
    // convert word to a map of character to number of occurencies
    // e.g. dude to (d -> 2, u -> 1, e -> 1)
    private static Map<Character, Integer> wordToMap(String word) {
        Map<Character, Integer> result = new HashMap<>();

        for(int i = 0; i < word.length(); i++) {
            char next = word.charAt(i);
            if(!result.containsKey(next))
                result.put(next, 1);

            result.put(next, result.get(next) + 1);
        }

        return result;
    }
}