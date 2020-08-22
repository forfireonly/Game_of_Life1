package life;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Universe {

    private int size = 10;
    private long seed = 10;
    private int generations = 100;




    public void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = size;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    public void setGenerations (int generations) {
        if (generations < 0) {
            throw new IllegalArgumentException();
        }
        this.generations = generations;
    }
    public int getSize() {
        return size;
    }

    public long getSeed() {
        return seed;
    }

    public int getGenerations() {
        return generations;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void displayGeneration(String[][] universe) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(universe[i][j]);
            }
            System.out.println();
        }
    }

    public String[][] endState(String[][] generation0) {

        String[][] nextGeneration = generation0;
        int counter = getGenerations();
        if (generations > 0) {

            for (int i = 0; i < counter ; i++) {
                //System.out.println(counter);
                nextGeneration = GenerationAlgorithm.createGenerations(generation0);

                for (int x = 0; x < size; x++) {
                    System.arraycopy(nextGeneration[x], 0, generation0[x], 0, size);
                }
            }
        }
        return nextGeneration;
    }

    public String[][] creatingUniverse() {
        String[][] newUniverseArray = new String[size][size];
        Random randomno = new Random();
        randomno.setSeed(seed);
        boolean value;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // create random object
                // get next next boolean value
                value = randomno.nextBoolean();
                if (value) {
                    newUniverseArray[i][j] = "O";
                } else {
                    newUniverseArray[i][j] = " ";
                }
            }
        }
        return newUniverseArray;
    }

    public int countAlive(String[][] someUniverse) {
        int liveCount = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ("O".equals(someUniverse[i][j])) {
                    liveCount++;
                }
            }
        }
        return liveCount;
    }




    public String[][] displayAll (String[][] startingGeneration) {
        String[][] currentGeneration = startingGeneration;


        for (int i = 1; i <= generations; i++) {
            System.out.println("Generation " + i);
            System.out.println("Alive: " + countAlive(currentGeneration));
            displayGeneration(currentGeneration);


            for (int h = 0; h < size; h++){
                for (int g = 0; g < size; g++) {
                    currentGeneration = GenerationAlgorithm.createGenerations(currentGeneration);
                }
            }

        }
        return currentGeneration;
    }


    public String[][] displayCurrent (String[][] startingGeneration) {
        String[][] nextGeneration;
        nextGeneration = GenerationAlgorithm.createGenerations(startingGeneration);
        return nextGeneration;
    }



    /*@Override
    public String toString() {
        String[][] universeToPrint = createGenerations();
        //String[][] universeToPrint = creatingExpandedUniverse(creatingUniverse());
        StringBuilder matrixUniverse = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixUniverse.append(universeToPrint[i][j]);
            }
            }
            matrixUniverse.append("\n");
        }
        return String.valueOf(matrixUniverse);
    }*/
}
