package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution71 {

    public String simplifyPath(String path) {
        String[] foldersArray = path.split("/");
        List<String> folders = new ArrayList<>();
        for (int i = 1; i < foldersArray.length; i ++) {
            if (foldersArray[i].isEmpty() || foldersArray[i].equals(".")) {
                continue;
            } else if (foldersArray[i].equals("..")) {
                if (!folders.isEmpty()) {
                    folders.remove(folders.size() - 1);
                }
            } else {
                folders.add(foldersArray[i]);
            }
        }
        StringBuilder sb = new StringBuilder("/");
        for (int i = 0; i < folders.size(); i ++) {
            if (i == 0) {
                sb.append(folders.get(i));
            } else {
                sb.append("/" + folders.get(i));
            }
        }
        return sb.toString();
    }
}
