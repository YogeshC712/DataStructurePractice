package org.yhc.programming.pattern.greedy;

public class BestTimeBuySellStocks {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Max profit will be - " + maxProfit(prices));
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
