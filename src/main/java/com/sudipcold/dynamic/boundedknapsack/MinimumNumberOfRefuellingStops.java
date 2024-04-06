package com.sudipcold.dynamic.boundedknapsack;

public class MinimumNumberOfRefuellingStops {
    // This function finds the maximum distance that can be travelled
    // by making "used" refuelling stops, considering fuel stations from index "index" onwards.
    public static int minRefuelStopsHelper(int index, int used, int curFuel, int[][] stations) {
        // If no refuelling stops are made, return the current fuel level.
        if(used == 0) {
            return curFuel;
        }

        // If more refuelling stops are made than the number of fuel stations remaining,
        // return -inf (impossible to reach the target distance).
        if(used > index) {

            return Integer.MIN_VALUE;
        }

        // Consider two options:
        // 1. Don't make a refuelling stop at the current fuel station.
        int result1 = minRefuelStopsHelper(index - 1, used, curFuel, stations);

        // 2. Make a refuelling stop at the current fuel station.
        int result2 = minRefuelStopsHelper(index - 1, used - 1, curFuel, stations);

        // Return the maximum of the two options, but if the fuel at the current fuel station
        // is not enough to reach the next fuel station, return -inf (impossible to reach the target distance).
        int result = Math.max(result1,
                result2 < stations[index - 1][0] ? Integer.MIN_VALUE : result2 + stations[index - 1][1]);

        return result;
    }
    // This function finds the minimum number of refuelling stops needed
    // to reach the target distance, given a starting fuel level and a list of fuel stations.
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        // Initialize an array to store the maximum distance that can be travelled
        // for each number of refuelling stops.
        int maxD[] = new int[n+1];
        // Find the maximum distance that can be travelled for each number of refuelling stops.
        for(int i = 0; i <= n; i++)
            maxD[i] = minRefuelStopsHelper(n, i, startFuel, stations);
        int result = -1;
        // Find the minimum number of refuelling stops needed by iterating over maxD
        // and finding the first value that is greater than or equal to the target distance.
        for(int i = 0; i <= n; i++) {
            if(maxD[i] >= target){
                result = i;
                break;
            }
        }
        return result;
    }
}
