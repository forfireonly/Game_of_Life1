package life;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Universe {

    private int size;
    private long seed;
    private int generations;

    public static int generation = 0;
    public static int alive = 0;


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
    public void displayGenerations(String[][] universe) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(universe[i][j]);
            }
            System.out.println();
        }
    }

    public String[][] createGenerations() throws InterruptedException {
        String[][] universeOne = creatingUniverse();
        String[][] universeTwo = new String[size][size];
        int expendedSize = size + 2;
        int neigborCounter;
        //int alive;
        String[][] expandedUniverse;
        //int generation = 0;
        if (generations == 0) {
            displayGenerations(universeOne);
            //return universeOne;
        } else {


            while (generations > 0){
                expandedUniverse = creatingExpandedUniverse(universeOne);
                alive = 0;
                //GameOfLife newView = new GameOfLife();
                for (int i = 1; i < expendedSize - 1; i++) {
                    for (int j = 1; j < expendedSize - 1; j++){
                        neigborCounter = 0;

                        if (expandedUniverse[i - 1][j].equals("O")) {
                            neigborCounter++;
                        }
                        if (expandedUniverse[i][j - 1].equals("O")) {
                            neigborCounter++;
                        }
                        if (expandedUniverse[i + 1][j].equals("O")) {
                            neigborCounter++;
                        }
                        if (expandedUniverse[i][j + 1].equals("O")) {
                            neigborCounter++;
                        }

                        if (expandedUniverse[i - 1][j - 1].equals("O")) {
                            neigborCounter++;
                        }

                        if (expandedUniverse[i - 1][j + 1].equals("O")) {
                            neigborCounter++;
                        }

                        if (expandedUniverse[i + 1][j - 1].equals("O")) {
                            neigborCounter++;
                        }

                        if (expandedUniverse[i + 1][j + 1].equals("O")) {
                            neigborCounter++;
                        }

                        if (expandedUniverse[i][j].equals("O")) {
                            if (neigborCounter == 2 || neigborCounter == 3) {
                                universeTwo[i - 1][j - 1] = "O";
                                alive++;
                            } else {
                                universeTwo[i - 1][j - 1] = " ";
                            }
                        } else {
                            if (neigborCounter == 3) {
                                universeTwo[i - 1][j - 1] = "O";
                                alive++;
                            } else {
                                universeTwo[i - 1][j - 1] = " ";
                            }
                        }

                    }
                }
                generation++;
                System.out.println("Generation #" + generation);
                System.out.println("Alive: " + alive);
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        universeOne[i][j] = universeTwo[i][j];
                    }
                }
                generations--;

                displayGenerations(universeOne);

                //GameOfLife newView = new GameOfLife();
               // newView.visualize(universeOne, size);
                //GameOfLife.initialize();
                //newView.revalidate();
                GameOfLife gameField = new GameOfLife();
                JPanel universePanel = new JPanel();
                universePanel.setLayout(new GridLayout(size, size, 0, 0));
                //universePanel.setOpaque(true);
                for (int x = 0; x < size; x++) {
                    for (int y = 0; y < size; y++) {

                        JButton button = new JButton();
                        button.setEnabled(false);
                        button.setOpaque(true);
                        if (universeOne[x][y].equals("O")) {
                            button.setBackground(Color.BLACK);
                        }
                        universePanel.add(button);
                    }
                }
                gameField.add(universePanel);
                gameField.setVisible(true);

                TimeUnit.MILLISECONDS.sleep(3000);
                clearScreen();
                if (generation != generations) {
                    gameField.dispose();
                }

            }


        }

        return universeOne;

    }

    public String[][] creatingExpandedUniverse(String[][] universeToExpend) {
        int expendedSize = size + 2;
        String[][] newExpandedUniverseArray = new String[expendedSize][expendedSize];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newExpandedUniverseArray[i + 1][j + 1] = universeToExpend[i][j];
            }
        }
        for (int i = 0; i < size; i ++) {
            newExpandedUniverseArray[0][i + 1] = universeToExpend[size-1][i];
            newExpandedUniverseArray[expendedSize - 1][i + 1] = universeToExpend[0][i];
            newExpandedUniverseArray[i + 1][0] = universeToExpend[i][size - 1];
            newExpandedUniverseArray[i + 1][expendedSize - 1] = universeToExpend[i][0];

        }
        newExpandedUniverseArray[0][0] = universeToExpend[size - 1][size - 1];
        newExpandedUniverseArray[0][expendedSize - 1] = universeToExpend[size - 1][0];
        newExpandedUniverseArray[expendedSize - 1][0] = universeToExpend[0][size - 1];
        newExpandedUniverseArray[expendedSize - 1][expendedSize - 1] = universeToExpend[0][0];

        return newExpandedUniverseArray;
    }

    public String[][] creatingUniverse() {
        String[][] newUniverseArray = new String[size][size];
        Random randomno = new Random();
        //randomno.setSeed(seed);
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





