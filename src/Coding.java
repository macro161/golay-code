import java.util.Arrays;
import java.util.Scanner;

public class Coding {

    int[][] B = new int[12][12];
    int[][] G = new int[12][24];
    int[][] H = new int[24][12];
    int[][] Bh = new int[12][11];
    int[][] Gh = new int[12][23];

    public void SendInformation(String information) {


        System.out.println("B matrix");
        createBMatrix();

        System.out.println("Bh matrix");
        createBhMatrix();

        System.out.println("G matrix");
        createGMatrix();

        System.out.println("H matrix");
        createHMatrix();

        System.out.println("Gh matrix");
        createGhMatrix();

        test();

        System.out.println("Encoded message");
        //int[] information = new int[]{0,0,1,0,0,1,0,0,1,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0};
        //int[] encodedMessage = new int[]{0,0,1,0,0,1,0,0,1,1,0,1,1,0,1,0,0,0,1,0,1,0,0,0}; //exp 1
          //int[] encodedMessage = new int[]{0,0,1,0,0,1,0,0,1,1,0,1,1,0,1,0,0,0,1,0,1,0,0,0}; esample 2
         // int[] encodedMessage = new int[]{0,0,0,1,1,1,0,0,0,1,1,1,0,1,1,0,1,1,0,1,0,0,0,0};
        //int[] encodedMessage = new int[]{1,0,1,1,1,1,1,0,1,1,1,1,0,1,0,0,1,0,0,1,0,0,1,0}; //exp 2
        //int[] encodedMessage = encode("101110101011");
            //encodedMessage[0]= 0;

         //int [] encodedMessage = new int []{1,0,1,1,1,1,1,0,1,1,1,1,0,1,0,0,1,0,0,1,0,0,1,0}; //Example 1
        // int [] encodedMessage = new int []{0,0,1,0,0,1,0,0,1,1,0,1,1,0,1,0,0,0,1,0,1,0,0,0}; //Example 2
        // int [] encodedMessage = new int []{0,0,0,1,1,1,0,0,0,1,1,1,0,1,1,0,1,1,0,1,0,0,0,0}; //Example 3
        // int [] encodedMessage = new int []{0,0,1,0,0,1,0,0,1,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0}; //Golay Example

        int [] encodedMessage = encodeh("101101110101");
        //int [] encodedMessage = encode("101101110101");
        encodedMessage = Utilities.moduloArray(encodedMessage);
        Utilities.displayArray(encodedMessage);
        //encodedMessage[0] = 0;
        //encodedMessage[4] = 1;
        //encodedMessage[5] = 0;
        //Utilities.displayArray(Utilities.moduloArray(encodedMessage));
        if(Utilities.vectorWeight(encodedMessage) % 2 == 0){
            encodedMessage[23] = 1;
        }

        //encodedMessage[23] = 1;

        //Utilities.displayArray(encodedMessage);
        //encodedMessage[0] = 0;
        //encodedMessage[1] = 1;
        //encodedMessage[2] = 0;
        //encodedMessage[3] = 0;
       // encodedMessage[2] = 0;
        //encodedMessage[5] = 0;
        //System.out.println("");
        Utilities.displayArray(encodedMessage);



        //if(Utilities.vectorWeight(encodedMessage)%2 ==0){
        //    encodedMessage[23] = 1;
       // }

       // Utilities.displayArray(encodedMessage);


        int[] u = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};




        ////////////////////////////////////////////////////////////////////////
        //Part 1
        //System.out.println("Sindromas");
        int[] synd = Utilities.firstSyndrom(H, encodedMessage);
        Utilities.moduloArray(synd);
        //Utilities.displayArray(synd);
        ////////////////////////////////////////////////////////////////////////
        //Part 2
        if(Utilities.vectorWeight(synd) <= 3)
        {
            for(int i = 0; i < 12;i++){
                u[i] = synd[i];
            }

            u = Utilities.moduloArray(u);

            //Utilities.displayArray(u);
            Utilities.displayArray(Utilities.moduloArray(Utilities.addVectors(encodedMessage,u)));
            ending();
        }
        ////////////////////////////////////////////////////////////////////////
        //Part 3
        for(int i = 0; i < B.length; i++) {
            if (Utilities.vectorWeight(Utilities.addVectors(synd, Utilities.getRowFromMatrix(B, i))) <= 2) {
                int[] u1 = Utilities.addVectors(synd, Utilities.getRowFromMatrix(B, i));
                for (int j = 0; j < 12; j++) {
                    u[j] = u1[j];
                }
                u[11 + i] = 1;
                break;
            }
        }


        //System.out.println("negras");
        u = Utilities.moduloArray(u);
        //Utilities.displayArray(u);
        Utilities.displayArray(Utilities.moduloArray(Utilities.addVectors(encodedMessage,u)));
        ending();

        ////////////////////////////////////////////////////////////////////////
        //Part 4

        int [] syndTwo = Utilities.secondSyndrom(synd,B);
        //System.out.println("antras sindromas");
        //Utilities.displayArray(Utilities.moduloArray(syndTwo));
        ////////////////////////////////////////////////////////////////////////
        //Part 5
        if(Utilities.vectorWeight(syndTwo) <=3){
            for(int i =12; i < u.length; i++){
                u[i] = syndTwo[i-12];
            }
        }

        u = Utilities.moduloArray(u);
        //System.out.println("Galas");

        //Utilities.displayArray(u);
        Utilities.displayArray(Utilities.moduloArray(Utilities.addVectors(encodedMessage,u)));
        ending();
        ////////////////////////////////////////////////////////////////////////
        //Part 6

        for(int i = 0; i < B.length; i++){
            int[] row = Utilities.getRowFromMatrix(B,i);
            int[] syndrow =Utilities.moduloArray(Utilities.addVectors(syndTwo,row));

            if(Utilities.vectorWeight(syndrow) <= 2){
                u[i] = 1;
                for(int j = 12; j< 24; j++){
                    u[j] = syndrow[j-12];
                }
                break;
            }

        }
        u = Utilities.moduloArray(u);
        //System.out.println("virsus");
        int [] finalResult = Utilities.addVectors(encodedMessage,u);
        Utilities.displayArray(Utilities.moduloArray(Utilities.addVectors(encodedMessage,u)));
        ending();
        ////////////////////////////////////////////////////////////////////////
        //Part 7
        ////////////////////////////////////////////////////////////////////////



    }

    public void ending(){
        System.out.println("Cia baigiasi mato kancios");
    }

    public void createGhMatrix(){
        String vector = "100000000000";
        String[] elements = vector.split("");
        int[] intElements = Arrays.asList(elements).stream().mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < 12; i++) {

            for (int j = 0; j < 12; j++) {
                Gh[i][j] = intElements[j];
            }
            shiftRight(intElements);



            for (int k = 12; k < 23; k++) {
                Gh[i][k] = Bh[i][k-12];

            }

        }

        //Utilities.displayMatrix(Gh);

        System.out.println("");
    }

    public void createBhMatrix(){
        String vector = "11011100010";
        String[] elements = vector.split("");
        int[] intElements = Arrays.asList(elements).stream().mapToInt(Integer::parseInt).toArray();


        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                Bh[i][j] = intElements[j];
            }

            shiftLeft(intElements);
        }

        for(int i = 0;i < 11;i++){
            Bh[11][i] = 1;
        }



        //Utilities.displayMatrix(Bh);
        System.out.println("");
    }

    public void createBMatrix() {


        String vector = "11011100010";
        String[] elements = vector.split("");
        int[] intElements = Arrays.asList(elements).stream().mapToInt(Integer::parseInt).toArray();


        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                B[i][j] = intElements[j];
            }
            B[i][11]=1;
            shiftLeft(intElements);
        }

        for (int i = 0; i < 11; i++) {
            B[11][i] = 1;
        }

        B[11][11]=0;

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
       // Utilities.displayMatrix(H);

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



            for (int k = 12; k < 24; k++) {
                G[i][k] = B[i][k-12];

            }

        }

       // Utilities.displayMatrix(G);

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

    public int[] encodeh(String information){
        String[] informationArray = information.split("");
        int[] intElements = Arrays.asList(informationArray).stream().mapToInt(Integer::parseInt).toArray();

        return Utilities.matrixMultiplicationh(intElements, Gh);
    }

    public void test(){
        /*System.out.println("Testas prasideda cia");
        int [] encodedmessage = encodeh("101110101011");
        Utilities.displayArray(Utilities.moduloArray(encodedmessage));
        if(Utilities.vectorWeight(encodedmessage) % 2 == 0){
            encodedmessage[23] = 1;
        }

        System.out.println("svoris " + Utilities.vectorWeight(encodedmessage));
        System.out.println("Testas baigiasi cia");*/
    }


}
