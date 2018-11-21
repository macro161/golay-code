import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Coding coding = new Coding();
        Channel channel = new Channel();
        Decoding decoding = new Decoding();

        boolean run = true;

        //Utilities.displayArray(coding.codeInformation("101101100101"));                   // result 1 0 1 1 0 1 1 0 0 1 0 1 1 0 0 1 1 0 1 0 1 0 0 0
        //decoding.decode(new int []{1,1,1,1,1,1,1,0,1,1,1,1,0,1,0,0,1,0,0,1,0,0,1,0});     // result 1 0 0 0 0 0 0 0 0 0 0 1
        //decoding.decode(new int []{0,0,1,0,0,1,0,0,1,1,0,1,1,0,1,0,0,0,1,0,1,0,0,0});     // result 1 1 0 0 0 1 0 0 1 0 0 1
        //decoding.decode(new int []{0,0,0,1,1,1,0,0,0,1,1,1,0,1,1,0,1,1,0,1,0,0,0,0});     // result 1 1 1 0 0 1 1 1 1 1 0 1
        //int [] code = coding.codeInformation("101101100101"); //1 0 1 1 0 1 1 0 0 1 0 1 1 0 0 1 1 0 1 0 1 0 0 0

        //decoding.decode(code);

        Scanner reader = new Scanner(System.in);

        while(run){
            System.out.printf("Iveskite pasirinkima");
            int n = reader.nextInt();
            switch (n){
                case 1:
                    System.out.println("Siusti vektoriu");
                    break;
                case 2:
                    System.out.println("Siusti teksta");
                    break;
                case 3:
                    System.out.println("Siusti paveiksliuka");
                    break;
                case 4:
                    System.out.println("Baigti darba");
                    break;
                default:
                    System.out.println("Neteisingas pasirinkimas");
            }
        }
        System.out.printf("Programa baigia darba");
        reader.close();
    }
}
