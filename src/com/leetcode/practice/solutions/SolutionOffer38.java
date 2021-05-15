package com.leetcode.practice.solutions;

import java.util.*;

public class SolutionOffer38 {

    public String[] permutation(String s) {
        List<String> resultList = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        inputResult(chars, new ArrayDeque<>(), resultList);
        String[] result = new String[resultList.size()];
        resultList.toArray(result);
        return result;
    }

    public void inputResult(char[] chars, Deque<Character> stack, List<String> result) {
        if (chars.length == 0) {
            char[] resC = new char[stack.size()];
            Iterator<Character> iterator = stack.iterator();
            for(int i = 0; i < stack.size(); i ++) {
                resC[i] = iterator.next();
            }
            result.add(new String(resC));
            return;
        }
        char lastChar = chars[0];
        for (int i = 0; i < chars.length; i ++) {
            if (i == 0 || chars[i] != lastChar) {
                stack.push(chars[i]);
                char[] newChars = new char[chars.length - 1];
                if (i != 0) {
                    System.arraycopy(chars, 0, newChars, 0, i);
                }
                if (i != chars.length - 1) {
                    System.arraycopy(chars, i + 1, newChars, i, chars.length - i - 1);
                }
                inputResult(newChars, stack, result);
                lastChar = stack.pop();
            }
        }

    }

}
