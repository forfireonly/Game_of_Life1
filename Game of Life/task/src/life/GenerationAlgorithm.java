package life;


import java.util.Arrays;

public class GenerationAlgorithm {

     public static String[][] createGenerations (String [][] universeOne) {


         int size = universeOne.length;
         String[][] universeTwo = new String[size][size];
         int expendedSize = size + 2;
         int neigborCounter;

         String[][] expandedUniverse = creatingExpandedUniverse(universeOne);
        // System.out.println(Arrays.deepToString(expandedUniverse));

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
                                // alive++;

                             } else {
                                 universeTwo[i - 1][j - 1] = " ";
                             }
                         } else {
                             if (neigborCounter == 3) {
                                 universeTwo[i - 1][j - 1] = "O";
                                // alive++;
                             } else {
                                 universeTwo[i - 1][j - 1] = " ";
                             }
                         }
                     }
                 }


         //System.out.println(Arrays.deepToString(universeTwo));
         return universeTwo;
             }

    public static  String[][] creatingExpandedUniverse(String[][] universeToExpend) {
        int size = universeToExpend.length;
        int expendedSize = size + 2;
        String[][] newExpandedUniverseArray = new String[expendedSize][expendedSize];
        for (int i = 0; i < size; i++) {
            System.arraycopy(universeToExpend[i], 0, newExpandedUniverseArray[i + 1], 1, size);
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



}
