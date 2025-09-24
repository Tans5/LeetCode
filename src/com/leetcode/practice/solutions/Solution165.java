package com.leetcode.practice.solutions;

/**
 * 给你两个 版本号字符串 version1 和 version2 ，请你比较它们。版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略前导零。
 *
 * 比较版本号时，请按 从左到右的顺序 依次比较它们的修订号。如果其中一个版本字符串的修订号较少，则将缺失的修订号视为 0。
 *
 * 返回规则如下：
 *
 * 如果 version1 < version2 返回 -1，
 * 如果 version1 > version2 返回 1，
 * 除此之外返回 0。
 *
 *
 * 示例 1：
 *
 * 输入：version1 = "1.2", version2 = "1.10"
 *
 * 输出：-1
 *
 * 解释：
 *
 * version1 的第二个修订号为 "2"，version2 的第二个修订号为 "10"：2 < 10，所以 version1 < version2。
 *
 * 示例 2：
 *
 * 输入：version1 = "1.01", version2 = "1.001"
 *
 * 输出：0
 *
 * 解释：
 *
 * 忽略前导零，"01" 和 "001" 都代表相同的整数 "1"。
 *
 * 示例 3：
 *
 * 输入：version1 = "1.0", version2 = "1.0.0.0"
 *
 * 输出：0
 *
 * 解释：
 *
 * version1 有更少的修订号，每个缺失的修订号按 "0" 处理。
 */
public class Solution165 {
    public int compareVersion(String version1, String version2) {
        String[] splitVersion1 = version1.split("\\.");
        String[] splitVersion2 = version2.split("\\.");
        int minLen = Math.min(splitVersion1.length, splitVersion2.length);
        for (int i = 0; i < minLen; i ++) {
            String s1 = fixVersionStr(splitVersion1[i]);
            String s2 = fixVersionStr(splitVersion2[i]);
            int d = compaireVersionStr(s1, s2);
            if (d != 0) {
                return d;
            }
        }

        String[] checkVersions = null;
        if (splitVersion1.length == splitVersion2.length) {
            return 0;
        } else if(splitVersion1.length > splitVersion2.length) {
            checkVersions = splitVersion1;
        } else {
            checkVersions = splitVersion2;
        }
        for (int i = minLen; i < checkVersions.length; i ++) {
            String s1 = fixVersionStr(checkVersions[i]);
            String s2 = "";
            int d = compaireVersionStr(s1, s2);
            if (d != 0) {
                if (splitVersion1 == checkVersions) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }

    private String fixVersionStr(String s) {
        int startIndex = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '0') {
                startIndex ++;
            } else {
                break;
            }
        }
        return new String(s.toCharArray(), startIndex, s.length() - startIndex);
    }

    private int compaireVersionStr(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 > len2) {
            return 1;
        }
        if (len1 < len2) {
            return -1;
        }
        for (int i = 0; i < len1; i ++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (c1 > c2) {
                return 1;
            }
            if (c1 < c2) {
                return -1;
            }
        }
        return 0;
    }
}
