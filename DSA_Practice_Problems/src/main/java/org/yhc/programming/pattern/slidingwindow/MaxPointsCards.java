package org.yhc.programming.pattern.slidingwindow;

/**
 * Given an array of integers representing card values, write a function to calculate the maximum score you can achieve by picking exactly k cards.
 * You must pick cards in order from either end. You can take some cards from the beginning, then switch to taking cards from the end, but you cannot skip cards or pick from the middle.
 * For example, with k = 3:
 * Take the first 3 cards: valid
 * Take the last 3 cards: valid
 * Take the first card, then the last 2 cards: valid
 * Take the first 2 cards, then the last card: valid
 * Take card at index 0, skip some, then take card at index 5: not valid (skipping cards)
 * Constraints: 1 <= k <= cards.length
 * Input -
 * cards = [2,11,4,5,3,9,2]
 * k = 3
 * Output - 17
 *
 */
public class MaxPointsCards {
    public static void main(String[] args) {
        int[] cards = {2,11,4,5,3,9,2};
        int k = 3;
        System.out.println("Max points if we pick K cards will be - " + maxPoints(cards, k));
    }

    private static int maxPoints(int[] cards, int k) {
        int total = 0;
        for (int card: cards) {
            total += card;
        }

        int n = cards.length;
        if(n == k){
            return total;
        }

        int start = 0;
        int maxPoints = Integer.MIN_VALUE;
        int currWindow = 0;

        for (int end = 0; end < n; end++) {
            currWindow += cards[end];

            if(end - start + 1 == n - k){
                maxPoints = Math.max(total - currWindow, maxPoints);
                currWindow -= cards[start];
                start++;
            }
        }
        return maxPoints;
    }
}
