package com.leetcode.practice.solutions;

public class SolutionOffer13 {

    public int movingCount(int m, int n, int k) {
        if (k <= 0) {
            return 1;
        }
        boolean[][] map = new boolean[m][n];
        map[0][0] = true;
        int result = 1;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if ((i - 1 >= 0 && map[i - 1][j]) || (j - 1 >= 0 && map[i][j - 1])) {
                    if (canReach(j, i, k)) {
                        map[i][j] = true;
                        result ++;
                    }
                }
            }
        }
        return result;
    }

    public boolean canReach(int x, int y, int k) {
        return (getSum(x) + getSum(y)) <= k;
    }

    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
