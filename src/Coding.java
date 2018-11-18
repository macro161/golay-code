import java.util.Arrays;

public class Coding {

    int [][] B = new int[12][12];
    int [][] G = new int[12][24];
    int [][] I = new int[12][24];

    public void SendVector(String vector){
        createBMatrix(vector);
    }


    public void createBMatrix(String vector){

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
    }

    public void createGMatrix(){

    }

    public void createIMatrix(){

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

    public int[] rightLeft(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int start = nums[nums.length-1];
        System.arraycopy(nums, 0, nums, 1, nums.length - 1);
        nums[0] = start;
        return nums;
    }


}
