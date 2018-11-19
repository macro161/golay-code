import java.util.Random;

public class Utilities {

    static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[1].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] /*% 2*/ + " ");
        }
    }

    static int[] moduloArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] % 2;
        }
        return array;
    }

    static int[][] generateRandomMatrix(int x, int y) {
        Random rand = new Random();
        int[][] matrix = new int[x][y];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) Math.round(Math.random());
            }
        }
        return matrix;
    }

    static int[] matrixMultiplication(int[] information, int[][] gMatrix) {

        int[] result = new int[24];

        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 12; j++) {
                int test = information[j] * gMatrix[j][i];
                result[i] += test;
            }
        }
        return result;
    }

    static int[] firstSyndrom(int[][] HMatrix, int[] message) {

        int[] s = new int[12];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 24; j++) {

                int test = message[j] * HMatrix[j][i];
                s[i] += test;
            }
        }
        return s;
    }


}
