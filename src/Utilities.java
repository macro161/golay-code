import java.util.Random;

public class Utilities {

    static void displayMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length ; i++){
            for(int j = 0; j< matrix[1].length ;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static int[][] generateRandomMatrix(int x, int y)
    {
        Random rand = new Random();
        int [][] matrix = new int[x][y];
        for (int i=0; i<matrix.length; i++) {
        for (int j=0; j<matrix[i].length; j++) {
            matrix[i][j] = (int) Math.round( Math.random() )  ;;
        }
    }

        return matrix;
    }
}
