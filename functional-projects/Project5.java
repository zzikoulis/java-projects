package gr.aueb.cf.projects10;

import java.util.Scanner;

public class Project5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {0, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 9};
        int[] positions;
        int key;

        System.out.println("Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Please select a number (in order to find its low and high index) and press Enter");
        key = in.nextInt();

        positions = getLowAndHighIndexOf(arr, key);

        if (positions[0] == -1) {
            System.out.printf("Element %d does not exist in the array\n", key);
        } else {
            System.out.printf("Low index: %d\n", positions[0]);
            System.out.printf("High index: %d\n", positions[1]);
            System.out.printf("{%d,%d}", positions[0], positions[1]);
        }

        in.close();
    }

    public static int[] getLowAndHighIndexOf(int[] arr, int key) {
        int[] positions = {-1, -1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                if (positions[0] == -1) {
                    positions[0] = i;
                }
                positions[1] = i;
            }
        }

        return positions;
    }
}
