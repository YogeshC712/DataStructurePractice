package org.yhc.programming.pattern.greedy;

public class BestTimeBuySellStocks {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Max profit will be - " + maxProfit(prices));

        int[] prices1 = {3,4,6,2,5,8};
        System.out.println("Max profit (greedy approach) will be - " + maxProfitGreedy(prices1));
    }

    private static int maxProfitGreedy(int[] prices){
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int price: prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    private static int maxProfit(int[] prices){
        //Greedy Algorithm
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price: prices) {
            //Buy at lowest price seen so far AND sell with Current price
            if(price < minPrice){
                minPrice = price;
            }else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }
}
