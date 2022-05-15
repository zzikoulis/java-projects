package gr.aueb.cf.projects10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) {
        File inFile = new File("C:/Users/Zisis/Desktop/CODING FACTORY/Java/6η ΕΒΔΟΜΑΔΑ/numbers.txt");
        File outFile = new File("C:/Users/Zisis/Desktop/CODING FACTORY/Java/6η ΕΒΔΟΜΑΔΑ/combinations.txt");
        Scanner in;
        try {
            in = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            System.out.println("File for reading NOT FOUND");
            return;
        }
        PrintStream ps;
        try {
            ps = new PrintStream(outFile);
        } catch (Exception e) {
            System.out.println("Exception in outfile");
            return;
        }
        ArrayList<Integer> numbers = new ArrayList<>();

        if(readNumbersFromFile(in, numbers) != 1){
            return;
        }

        numbers.sort((n1,n2) -> n1 - n2);

        calculateAndPrintToFile(numbers, ps);

        System.out.println("Results are available at: combinations.txt");

        in.close();
        ps.close();
    }

    public static int readNumbersFromFile(Scanner in, ArrayList<Integer> numbers) {
        int counter = 0;
        int nextNumber = 0;

        while (in.hasNextInt()) {
            nextNumber = in.nextInt();
            if (nextNumber == -1) break;
            if ((nextNumber > 0) && (nextNumber < 50)) {
                numbers.add(nextNumber);
                counter++;
            }
        }

        if((counter > 5) && (counter < 50) && (nextNumber == -1))
            return 1;
        if((counter > 5) && (counter < 50)) {
            System.out.println("File for reading must end with '-1' number");
            System.out.println("Please correct the file and try again");
            return 2;
        }
        if(nextNumber == -1) {
            System.out.println("File for reading must have between 6 and 49 numbers to read");
            System.out.println("Please correct the file and try again");
            return 3;
        }

        System.out.println("File for reading must have between 6 and 49 numbers to read and end with '-1' number");
        System.out.println("Please correct the file and try again");
        return 4;
    }

    public static void calculateAndPrintToFile(ArrayList<Integer> numbers, PrintStream ps) {
        int n = 6;
        int[] numberToPrint = new int[6];

        for (int i = 0; i <= numbers.size() - n; i++) {
            for (int j = i + 1; j <= numbers.size() - n + 1; j++) {
                for (int k = j + 1; k <= numbers.size() - n + 2; k++) {
                    for (int m = k + 1; m <= numbers.size() -n + 3; m++) {
                        for (int o = m + 1; o <= numbers.size() -n + 4; o++) {
                            for (int p = o + 1; p < numbers.size(); p++) {
                                numberToPrint[0] = numbers.get(i);
                                numberToPrint[1] = numbers.get(j);
                                numberToPrint[2] = numbers.get(k);
                                numberToPrint[3] = numbers.get(m);
                                numberToPrint[4] = numbers.get(o);
                                numberToPrint[5] = numbers.get(p);
                                if((!isEven(numberToPrint)) &&
                                        (!isOdd(numberToPrint)) &&
                                            (!isContiguous(numberToPrint)) &&
                                                (!isSameEnding(numberToPrint)) &&
                                                    (!isSameTen(numberToPrint)))
                                ps.printf("%d\t%d\t%d\t%d\t%d\t%d\t\n", numbers.get(i), numbers.get(j), numbers.get(k), numbers.get(m),numbers.get(o),numbers.get(p));
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isEven(int[] numberToPrint) {
        int counter = 0;

        for (int j : numberToPrint) {
            if ((j % 2) == 0) {
                counter++;
            }
        }

        return (counter > 4);
    }

    public static boolean isOdd(int[] numberToPrint) {
        int counter = 0;

        for (int j : numberToPrint) {
            if ((j % 2) != 0) {
                counter++;
            }
        }

        return (counter > 4);
    }

    public static boolean isContiguous(int[] numberToPrint) {
        int counter = 0;
        for(int i = 0; i < numberToPrint.length - 1; i++){
            if((numberToPrint[i+1] - numberToPrint[i]) == 1) {
                counter++;
            }
        }

        return (counter > 2);
    }

    public static boolean isSameEnding(int[] numberToPrint) {
        int[] endings = new int[10];
        for(int i =0; i< endings.length; i++) {
            endings[i] = 0;
        }
        for (int j : numberToPrint) {
            endings[j % 10]++;
        }

        for (int ending : endings) {
            if (ending > 3)
                return true;
        }
        return false;
        }

    public static boolean isSameTen(int[] numberToPrint) {
        int[] tens = new int[5];
        for(int i =0; i< tens.length; i++) {
            tens[i] = 0;
        }

        for (int j : numberToPrint) {
            tens[j / 10]++;
        }

        for (int ten : tens) {
            if (ten > 3)
                return true;
        }
        return false;
    }
}
