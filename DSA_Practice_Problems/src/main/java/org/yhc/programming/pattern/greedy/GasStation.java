package org.yhc.programming.pattern.greedy;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {5,2,0,3,3};
        int[] cost = {1,5,5,1,1};

        int startGasStation = canCompleteCircuit(gas, cost);
        System.out.println("To complete circuit we should start at station: "+startGasStation);
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost){
            return -1;
        }

        int fuel = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            if(fuel + gas[i] - cost[i] < 0){
                // can't reach next station: try starting from next station. Reset fuel
                start = i + 1;
                fuel = 0;
            }else {
                // can reach next station: update remaining fuel
                fuel += gas[i] - cost[i];
            }
        }
        return start;
    }
}
