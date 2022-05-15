package gr.aueb.cf.projects10;

import java.util.Arrays;

public class Project7 {

    public static void main(String[] args) {
        int[][] arr = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int[][] arr2 = null;

        arr2 = shallowCopy(arr);
        arr2[1][1] = 1;
        System.out.println("---After shallow copy---");
        System.out.println("arr[1][1] = " + arr[1][1]);
        System.out.println("arr2[1][1] = " + arr2[1][1]);
        System.out.println();

        arr2[1][1] = 5;

        arr2 = deepCopy(arr);
        arr2[1][1] = 1;
        System.out.println("---After deep copy---");
        System.out.println("arr[1][1] = " + arr[1][1]);
        System.out.println("arr2[1][1] = " + arr2[1][1]);
    }

    public static int[][] shallowCopy(int[][] arr) {
        int[][] returnedArray = null;

        returnedArray = Arrays.copyOf(arr, arr.length);

        return returnedArray;
    }

    public static int[][] deepCopy(int[][] arr) {
        int[][] returnedArray = null;

        returnedArray = new int[arr.length][];

        for (int i = 0; i < arr.length; i++) {
            returnedArray[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return returnedArray;
    }

}
