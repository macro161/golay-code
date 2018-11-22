import java.util.ArrayList;

public class Utilities {

    static int[][] multiplyMatrix(int[][] A, int[][] B) {

        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        int[][] C = new int[aRows][bColumns];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0;
            }
        }

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[1].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static int[] addVectors(int a[], int b[]){

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

    static int[] getRowFromMatrix(int a[][], int row) {
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
        System.out.println(" ");
    }

    static void moduloArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] % 2;
        }
    }

    static int vectorWeight(int [] vector) {
        int result = 0;

        for(int i = 0;i < vector.length; i++){
            if(vector[i] == 1) {
                result++;
            }
        }
        return result;
    }

    static int [][] multiDimension(int [] numbers){
        int result[][] = new int[1][numbers.length];
        for(int i = 0 ; i < numbers.length;i++){
            result[0][i] = numbers[i];
        }
        return result;
    }

    static int [] oneDimension(int [][] numbers){
        ArrayList<Integer> numbers1Dim = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++)
        {
            for (int x = 0; x < numbers[i].length; x++)
            {
                numbers1Dim.add(numbers[i][x]);
            }
        }

        int[] ret = new int[numbers1Dim.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = numbers1Dim.get(i).intValue();
        }
        return ret;
    }

    static void copyArray(int [] firstArray, int [] secondArray ){
        for(int i = 0; i < secondArray.length;i++)
        {
            firstArray[i] = secondArray[i];
        }
    }
}
