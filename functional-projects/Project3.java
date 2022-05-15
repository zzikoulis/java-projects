package gr.aueb.cf.projects10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Project3 {

    public static void main(String[] args) {
        int[][] characters = new int[256][2];
        FileReader fr = null;
        try {
            fr = new FileReader("C:/Users/Zisis/Desktop/CODING FACTORY/Java/6η ΕΒΔΟΜΑΔΑ/Project3.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File for reading NOT FOUND");
            return;
        }
        BufferedReader bf = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        int nextFreePosition = 0;
        int[][] forStatistics = null;

        initTable(characters);

        try {
            sb = readFile(sb, bf);
        } catch (IOException e) {
            System.out.println("IO Exception when reading file");
            return;
        }

        nextFreePosition = fillTable(sb, characters);

        forStatistics = deepCopy(characters, nextFreePosition);

        System.out.println("FILE STATISTICS\n");
        Arrays.sort(forStatistics, (l1, l2) -> l1[0] - l2[0]);
        System.out.println("ORDERED BY CHARACTER ASCII CODE");
        printStatistics(forStatistics);
        System.out.println();

        Arrays.sort(forStatistics, (t1, t2) -> t1[1] - t2[1]);
        System.out.println("ORDERED BY CHARACTERS' TOTAL APPEARANCES");
        printStatistics(forStatistics);

        try {
            fr.close();
            bf.close();
        } catch (IOException e) {
            System.out.println("IO Exception when closing file");
        }
    }

    public static void initTable(int[][] characters) {
        for(int i = 0; i < characters.length; i++) {
            characters[i][0] = -1;
            characters[i][1] = 0;
        }
    }

    public static StringBuilder readFile(StringBuilder sb, BufferedReader bf) throws IOException {
        int bufSize = 8192;
        char[] buf = new char[bufSize];
        int n = 0;

        while ((n = bf.read(buf, 0, bufSize)) != -1) {
            sb.append(buf, 0, n);
        }

        return sb;
    }

    public static int fillTable(StringBuilder sb, int[][] characters) {
        int nextCharacter = -1;
        int characterPosition = -1;
        int nextFreePosition = 0;

        for(int i = 0; i < sb.length(); i++) {
            nextCharacter = (int) sb.charAt(i);
            characterPosition = getPosition(nextCharacter, characters, nextFreePosition);
            if(characterPosition == -1) {
                addCharacter(nextCharacter, characters, nextFreePosition);
                nextFreePosition++;
            }
            else {
                incrementCharacterFrequency(characters, characterPosition);
            }
        }

        return nextFreePosition;
    }

    public static int getPosition(int nextCharacter, int[][] characters, int nextFreePosition) {

        for(int i = 0; i < nextFreePosition; i++) {
            if(characters[i][0] == nextCharacter) {
                return i;
            }
        }
        return -1;
    }

    public static void addCharacter(int characterToAdd, int[][] characters, int nextFreePosition) {
        characters[nextFreePosition][0] = characterToAdd;
        characters[nextFreePosition][1] = 1;
    }

    public static void  incrementCharacterFrequency(int[][] characters, int characterPosition) {
        characters[characterPosition][1]++;
    }

    public static int[][] deepCopy(int[][] characters, int nextFreePosition) {
        int[][] returnedArray = null;

        returnedArray = new int[nextFreePosition][];

        for (int i = 0; i < nextFreePosition; i++) {
            returnedArray[i] = Arrays.copyOf(characters[i], characters[i].length);
        }
        return returnedArray;
    }

    public static void printStatistics(int[][] orderedArray) {
        int totalCharacters = 0;

        for(int i = 0; i < orderedArray.length; i++) {
            totalCharacters += orderedArray[i][1];
        }

        System.out.println("CHARACTER   " + "TOTAL TIMES   " + "FREQUENCY");
        for(int i = 0; i < orderedArray.length; i++) {
            System.out.printf("    %c         %5d      " , (char)orderedArray[i][0], orderedArray[i][1]);
            System.out.printf("  %5.2f %%\n", (double)(orderedArray[i][1] * 100) / totalCharacters);
        }
    }
}
