package gr.aueb.cf.projects10;

import java.util.Arrays;

public class Project4 {

    public static void main(String[] args) {
        int[][] arr = { {1012, 1136}, {1317, 1417}, {1015, 1020} };
        int[][] carTime = null;
        int[] maxCarsStats = null;

        carTime = createCarTimeArray(arr);

        Arrays.sort(carTime, (c1, c2) -> c1[0] - c2[0]);

        maxCarsStats = getMaxCarStatistics(carTime);

        System.out.printf("Maximum number of cars: %d\n", maxCarsStats[0]);
        System.out.printf("Between %d and %d\n", maxCarsStats[1], maxCarsStats[2]);
    }

    public static int[][] createCarTimeArray(int[][]  arr) {
        int[][] carTime = new int[arr.length * 2][2];
        int nextPosition = 0;

        for (int i = 0; i < arr.length; i++) {
            carTime[nextPosition][0] = arr[i][0];
            carTime[nextPosition][1] = 1;
            carTime[nextPosition + 1][0] = arr[i][1];
            carTime[nextPosition + 1][1] = 0;
            nextPosition += 2;
        }

        return carTime;
    }

    public static int[] getMaxCarStatistics(int[][] arr) {
        int[] maxCarsStats = {0, 0, 0};
        int carsNow = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i][1] == 1) {
                carsNow++;
                if (carsNow >= maxCarsStats[0]) {
                    maxCarsStats[0] = carsNow;
                    maxCarsStats[1] = arr[i][0];
                    }
                } else {
                if (carsNow == maxCarsStats[0]) {
                    maxCarsStats[2] = arr[i][0];
                }
            carsNow--;
            }
        }
        return maxCarsStats;
    }
}
