package org.example.leetcode150;

//Question: 134. Gas Station
// Link: https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int startIndex = findStartIndex(gas, cost);
        System.out.println("Start Index is: "+startIndex);
    }

    private static int findStartIndex(int[] gas, int[] cost) {
        int numOfStation = gas.length;
        int position = 0;
        int remainingGasAfterEachMove=0;
        int totalRemainingGasInTank = 0;

        for(int stationNum = 0; stationNum<numOfStation; stationNum++){
            remainingGasAfterEachMove += gas[stationNum] - cost[stationNum];
            if(remainingGasAfterEachMove < 0){
                position = stationNum + 1;
                totalRemainingGasInTank += remainingGasAfterEachMove;
                remainingGasAfterEachMove = 0;
            }
        }
        totalRemainingGasInTank += remainingGasAfterEachMove;
        return totalRemainingGasInTank >= 0 ? position : -1;
    }
}
