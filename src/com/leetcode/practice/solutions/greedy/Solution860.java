package com.leetcode.practice.solutions.greedy;

import java.util.Arrays;

/**
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：bills = [5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 */
public class Solution860 {

    public boolean lemonadeChange(int[] bills) {
        int[] myCash = new int[21];
        for (int bill: bills) {
            if (bill == 5) {
                myCash[5] ++;
            }
            if (bill == 10) {
                if (myCash[5] <= 0) {
                    return false;
                }
                myCash[5] --;
                myCash[10] ++;
            }
            if (bill == 20) {
                if (myCash[10] > 0 && myCash[5] > 0) {
                    myCash[20] ++;
                    myCash[10] --;
                    myCash[5] --;
                    continue;
                }
                if (myCash[5] > 2) {
                    myCash[5] -= 3;
                    myCash[20] ++;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
