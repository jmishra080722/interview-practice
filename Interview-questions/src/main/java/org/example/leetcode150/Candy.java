package org.example.leetcode150;


//135. Candy
//Url: https://leetcode.com/problems/candy/?envType=study-plan-v2&envId=top-interview-150
public class Candy {

    public static void main(String[] args) {
        int[] ratings = {1,2,87,87,87,2,1};
        int totalCandiesRequired= getTotalCandies(ratings);
        System.out.println(totalCandiesRequired);
    }


    public static int candy(int[] ratings) {
        int numOfChild = ratings.length;
        int totalCandy = numOfChild;
        int i = 1;

        while (i < numOfChild){

            if(ratings[i] == ratings[i-1]){
                i++;
                continue;
            }

            int currentPeak = 0;
            while(i < numOfChild && ratings[i] > ratings[i-1]){
                currentPeak++;
                totalCandy = totalCandy + currentPeak;
                i++;
            }

            if(i == numOfChild){
                return totalCandy;
            }

            int currentValley = 0;
            while (i <  numOfChild && ratings[i] < ratings[i-1]){
                currentValley++;
                totalCandy = totalCandy + currentValley;
                i++;
            }

            totalCandy = totalCandy - Math.min(currentPeak , currentValley);
        }
        return totalCandy;
    }

    private static int getTotalCandies(int[] ratings) {
        int numOfChild = ratings.length;
        int totalCandies =  numOfChild;
        int i = 1;

        while(i < numOfChild){

            if(ratings[i] == ratings[i-1]){
                i++;
                continue;
            }

            //Current rating is higher hat previous : peak
            int currentPeak = 0;
            while( i < numOfChild && ratings[i] > ratings[i-1]){
                currentPeak++;
                totalCandies = totalCandies + currentPeak;
                i++;
            }

            if(i == numOfChild){
                return totalCandies;
            }

            //Current Rating is lower tha previous: valley
            int currentValley = 0;
            while(i < numOfChild && ratings[i] < ratings[i-1]){
                currentValley++;
                totalCandies = totalCandies + currentValley;
                i++;
            }

            totalCandies = totalCandies - Math.min(currentPeak, currentValley );
        }

        return totalCandies;

    }
}
