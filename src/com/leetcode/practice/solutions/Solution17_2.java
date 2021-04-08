package com.leetcode.practice.solutions;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17_2 {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[] digitsArrays = digits.toCharArray();
        if (digitsArrays.length < 1) {
            return result;
        }
        Map<Character, Character[]> charsMap = new HashMap<>();
        charsMap.put('2', new Character[]{'a', 'b', 'c'});
        charsMap.put('3', new Character[]{'d', 'e', 'f'});
        charsMap.put('4', new Character[]{'g', 'h', 'i'});
        charsMap.put('5', new Character[]{'j', 'k', 'l'});
        charsMap.put('6', new Character[]{'m', 'n', 'o'});
        charsMap.put('7', new Character[]{'p', 'q', 'r', 's'});
        charsMap.put('8', new Character[]{'t', 'u', 'v'});
        charsMap.put('9', new Character[]{'w', 'x', 'y', 'z'});
        enqueueResult(digitsArrays, 0, digitsArrays.length - 1, new char[]{}, charsMap, result);
        return result;
    }

    public void enqueueResult(char[] digits, int start, int end, char[] queue, Map<Character, Character[]> charsMap, List<String> result) {
        if (start > end) {
            result.add(new String(queue));
            return;
        }
        Character[] charsArray = charsMap.get(digits[start]);
        for (Character character : charsArray) {
            char[] newQueue = new char[queue.length + 1];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            newQueue[newQueue.length - 1] = character;
            enqueueResult(digits, start + 1, end, newQueue, charsMap, result);
        }
    }

}
