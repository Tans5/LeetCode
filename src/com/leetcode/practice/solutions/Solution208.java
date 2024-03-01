package com.leetcode.practice.solutions;

public class Solution208 {

    CharNode[] children = new CharNode[26];

    public void insert(String word) {
        CharNode node = null;
        int size = word.length();
        for (int i = 0; i < size; i ++) {
            int charIndex = word.charAt(i) - 'a';
            if (charIndex > 25 || charIndex < 0) {
                return;
            }
            CharNode[] children;
            if (node == null) {
                children = this.children;
            } else {
                children = node.children;
            }
            CharNode n = children[charIndex];
            if (n == null) {
                n = new CharNode();
                children[charIndex] = n;
            }
            node = n;
        }
        node.isWordEnd = true;
    }

    public boolean search(String word) {
        CharNode node = null;
        for (int i = 0; i < word.length(); i ++) {
            int charIndex = word.charAt(i) - 'a';
            if (charIndex > 25 || charIndex < 0) {
                return false;
            }
            CharNode[] children;
            if (node == null) {
                children = this.children;
            } else {
                children = node.children;
            }
            CharNode n = children[charIndex];
            if (n == null) {
                return false;
            }
            node = n;
        }
        return node.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        CharNode node = null;
        for (int i = 0; i < prefix.length(); i ++) {
            int charIndex = prefix.charAt(i) - 'a';
            if (charIndex > 25 || charIndex < 0) {
                return false;
            }
            CharNode[] children;
            if (node == null) {
                children = this.children;
            } else {
                children = node.children;
            }
            CharNode n = children[charIndex];
            if (n == null) {
                return false;
            }
            node = n;
        }
        return true;
    }

    class CharNode {

        CharNode[] children = new CharNode[26];

        boolean isWordEnd = false;
    }
}
