package org.example.uber.section2;

public class CapacityToShipPackage {
    public static void main(String[] args) {
        //int[] weights = {1,2,3,4,5,6,7,8,9,10};
        //int days = 5;
        int [] weights = {3,2,2,4,1,4};
        int days = 3;
        int minCapacityToShip = shipWithinDays(weights, days);
        System.out.println(minCapacityToShip);
    }

    private static int shipWithinDays(int[] weights, int days) {
        int min = 0;//Maximum weight for a single day which is minimum capacity of ths ship for a single day
        int max = 0;  //Total weight which is maximum capacity of the ship to ship in a single day
        for(int weight: weights){
            min = Math.max(min, weight);
            max +=weight;
        }
        while (min < max){
            int mid = min + (max - min)/2;
            if(canShip(weights, days, mid)){
                max = mid;
            }else {
                min = mid + 1;
            }
        }
        return min;
    }

    private static boolean canShip(int[] weights, int days, int mid) {
        int dayNeeded = 1;
        int currentLoad = 0;
        for (int weight : weights){
            if(currentLoad + weight > mid){
                dayNeeded++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }
        return dayNeeded <= days;
    }
}
