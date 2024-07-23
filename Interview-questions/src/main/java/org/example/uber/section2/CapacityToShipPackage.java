package org.example.uber.section2;

import java.util.HashMap;
import java.util.Map;

public class CapacityToShipPackage {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        /*int [] weights = {3,2,2,4,1,4};
        int days = 3;*/
        int minCapacityToShip = shipWithinDays(weights, days);
        System.out.println(minCapacityToShip);
    }

    private static int shipWithinDays2(int[] weights, int days) {
        int minCapacity = 0;
        int maxCapacity = 0;
        for(int weight: weights){
            minCapacity = Math.max(minCapacity, weight);
            maxCapacity +=weight;
        }
        while (minCapacity <=maxCapacity){
            int currentCapacity=0;
            int dayNeeded = 1;
            for(int weight: weights){
                currentCapacity +=weight;
                if(currentCapacity > minCapacity){
                    dayNeeded++;
                    currentCapacity =weight;
                }
            }
            if(dayNeeded == days){
                return minCapacity;
            }
            minCapacity++;
        }
        return 0;
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
