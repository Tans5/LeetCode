package com.leetcode.practice;


import com.leetcode.practice.solutions.*;


public class Main {
    public static void main(String[] args) {
        Solution150 s = new Solution150();
        int result = s.evalRPN(new String[]{ "2","1","+","3","*" });
        System.out.println(result);
    }
}
