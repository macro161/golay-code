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

    static int[]  addVectors(int a[], int b[]){

        int size = a.length;

        if(a.length > b.length){
            size = b.length;
        }

        int[] result = new int[size];
        for(int i=0;i < size;i++){
            result[i] += a[i];
            result[i] += b[i];
        }
        return result;
    }

    static int[] getRowFromMatrix(int a[][], int row)
    {
        int[] result = new int[a[1].length];

        for(int i = 0; i < result.length;i++)
        {
            result[i] = a[row][i];
        }


        return result;
    }

    static void displayArray(int[] array) {
        System.out.println("");
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
                //System.out.println(message[j] + " * " + HMatrix[j][i]);
                s[i] += test;
            }
           // System.out.println("//////////////////////");
        }
        return s;
    }

    static int[] secondSyndrom (int[] syndrom, int[][]BMatrix){
        int[] syndtwo = new int[12];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {

                int test = syndrom[j] * BMatrix[j][i];
                //System.out.println(message[j] + " * " + HMatrix[j][i]);
                syndtwo[i] += test;
            }
            // System.out.println("//////////////////////");
        }
        return syndtwo;
    }

    static int vectorWeight(int [] vector)
    {
        int result = 0;

        for(int i = 0;i < vector.length; i++){
            if(vector[i] == 1) {
                result++;
            }
        }
        return result;
    }


}
