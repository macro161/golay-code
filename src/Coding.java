import java.util.Arrays;
import java.util.Scanner;

public class Coding {

    int [][] B = new int[12][12];
    int [][] G = new int[12][24];
    int [][] I = new int[12][24];

    public void SendInformation(String information){
        createBMatrix();
        createGMatrix();
        createIMatrix();

        Utilities.displayArray(encode(information));
    }


    public void createBMatrix(){


        String vector = "11011100010";
        String[] elements = vector.split("");
        int[] intElements = Arrays.asList(elements).stream().mapToInt(Integer::parseInt).toArray();


        for(int i = 0; i < 11 ; i++){
            for(int j = 0; j < 11 ; j++){
                B[i][j] = intElements[j];
            }
            B[i][11] = 1;
            shiftLeft(intElements);
        }

        for(int i =0; i < 11; i++){
            B[11][i] = 1;
        }

        B[11][11] = 0;

        Utilities.displayMatrix(B);
        System.out.println("");

    }

    public void createGMatrix(){

        String vector = "100000000000";
        String[] elements = vector.split("");
        int[] intElements = Arrays.asList(elements).stream().mapToInt(Integer::parseInt).toArray();
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12 ; j++){
                G[i][j] = B [i][j];
            }

            int x = 0;

            for(int k = 12; k < 24; k++){

                G[i][k] = intElements[x];
                x++;
            }

            shiftRight(intElements);
        }

        Utilities.displayMatrix(G);

        System.out.println("");


    }

    public void createIMatrix(){
        String vector = "100000000000";
        String[] elements = vector.split("");
        int[] intElements = Arrays.asList(elements).stream().mapToInt(Integer::parseInt).toArray();
        for(int i = 0; i < 12; i++){

            for(int j = 0; j < 12; j++){
                I[i][j] = intElements[j];
            }
            shiftRight(intElements);

            int x = 0;

            for(int k = 12; k < 24 ; k++){
                I[i][k] = B [i][x];
                x++;
            }

        }

        Utilities.displayMatrix(I);

        System.out.println("");

    }

    public int[] shiftLeft(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int start = nums[0];
        System.arraycopy(nums, 1, nums, 0, nums.length - 1);
        nums[nums.length -1] = start;
        return nums;
    }

    public int[] shiftRight(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int start = nums[nums.length-1];
        System.arraycopy(nums, 0, nums, 1, nums.length - 1);
        nums[0] = start;
        return nums;
    }

    public int[] encode(String information){

        String[] informationArray = information.split("");
        int[] intElements = Arrays.asList(informationArray).stream().mapToInt(Integer::parseInt).toArray();


        return Utilities.matrixMultiplication(intElements, G);


    }


}
