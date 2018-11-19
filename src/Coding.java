import java.util.Arrays;
import java.util.Scanner;

public class Coding {

    int[][] B = new int[12][12];
    int[][] G = new int[12][24];
    int[][] H = new int[24][12];

    public void SendInformation(String information) {


        System.out.println("B matrix");
        createBMatrix();

        System.out.println("G matrix");
        createGMatrix();

        System.out.println("H matrix");
        createHMatrix();

        System.out.println("Encoded message");
        int[] encodedMessage = new int[]{ 1,0,1,1,1,1,1,0,1,1,1,1,0,1,0,0,1,0,0,1,0,0,1,0}/*encode(information)*/;
        Utilities.moduloArray(encodedMessage);
        Utilities.displayArray(encodedMessage);
        System.out.println("");

        System.out.println("Sindromas");
        int[] synd = Utilities.firstSyndrom(H, encodedMessage);
        Utilities.moduloArray(synd);
        Utilities.displayArray(synd);

    }


    public void createBMatrix() {


        String vector = "11011100010";
        String[] elements = vector.split("");
        int[] intElements = Arrays.asList(elements).stream().mapToInt(Integer::parseInt).toArray();


        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                B[i][j] = intElements[j];
            }
            B[i][11] = 1;
            shiftLeft(intElements);
        }

        for (int i = 0; i < 11; i++) {
            B[11][i] = 1;
        }

        B[11][11] = 0;

        Utilities.displayMatrix(B);
        System.out.println("");

    }

    public void createHMatrix() {

        String vector = "100000000000";
        String[] elements = vector.split("");
        int[] intElements = Arrays.asList(elements).stream().mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                H[i][j] = intElements[j];
            }

            shiftRight(intElements);
        }

        int x = 0;
        for (int i = 12; i < 24; i++) {
            for (int j = 0; j < 12; j++) {
                H[i][j] = B[x][j];
            }
            x++;

        }
        Utilities.displayMatrix(H);

        System.out.println("");
    }

    public void createGMatrix() {
        String vector = "100000000000";
        String[] elements = vector.split("");
        int[] intElements = Arrays.asList(elements).stream().mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < 12; i++) {

            for (int j = 0; j < 12; j++) {
                G[i][j] = intElements[j];
            }
            shiftRight(intElements);

            int x = 0;

            for (int k = 12; k < 24; k++) {
                G[i][k] = B[i][x];
                x++;
            }

        }

        Utilities.displayMatrix(G);

        System.out.println("");

    }

    public int[] shiftLeft(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int start = nums[0];
        System.arraycopy(nums, 1, nums, 0, nums.length - 1);
        nums[nums.length - 1] = start;
        return nums;
    }

    public int[] shiftRight(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int start = nums[nums.length - 1];
        System.arraycopy(nums, 0, nums, 1, nums.length - 1);
        nums[0] = start;
        return nums;
    }

    public int[] encode(String information) {

        String[] informationArray = information.split("");
        int[] intElements = Arrays.asList(informationArray).stream().mapToInt(Integer::parseInt).toArray();


        return Utilities.matrixMultiplication(intElements, G);


    }


}
