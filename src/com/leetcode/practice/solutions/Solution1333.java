package com.leetcode.practice.solutions;
import java.util.ArrayList;
import java.util.List;
public class Solution1333 {

    private final static int ID_INDEX = 0;
    private final static int RATING_INDEX = 1;
    private final static int VEGANF_INDEX = 2;
    private final static int PRICE_INDEX = 3;
    private final static int DISTANCE_INDEX = 4;

    /**
     *
     * @param restaurants [id, rating, veganFriendly, price, distance]
     * @param veganFriendly
     * @param maxPrice
     * @param maxDistance
     * @return
     */
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> resultRestaurants = new ArrayList<>();
        for (int[] restaurant: restaurants) {
            if (isOk(restaurant, veganFriendly, maxPrice, maxDistance)) {
                addRestaurant(resultRestaurants, restaurant);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int[] r: resultRestaurants) {
            result.add(r[ID_INDEX]);
        }
        return result;
    }

    private void addRestaurant(List<int[]> result, int[] waitInsert) {
        if (result.isEmpty()) {
            result.add(waitInsert);
            return;
        }
        for (int i = 0; i < result.size(); i ++) {
            int[] r = result.get(i);
            if (isAGreatThanB(waitInsert, r)) {
                result.add(i, waitInsert);
                return;
            }
        }
        result.add(waitInsert);
    }

    public boolean isOk(int[] restaurant, int veganF, int maxPrice, int maxDis) {
        if (veganF == 1 && restaurant[VEGANF_INDEX] != 1) {
            return false;
        }
        if (restaurant[PRICE_INDEX] > maxPrice) {
            return false;
        }
        if (restaurant[DISTANCE_INDEX] > maxDis) {
            return false;
        }
        return true;
    }

    public boolean isAGreatThanB(int[] a, int[] b) {
        int ratingA = a[RATING_INDEX];
        int ratingB = b[RATING_INDEX];
        if (ratingA != ratingB) {
            return ratingA > ratingB;
        } else {
            return a[ID_INDEX] > b[ID_INDEX];
        }
    }
}
