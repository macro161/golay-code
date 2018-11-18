import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Coding coding = new Coding();

        //int [][] matrix = Utilities.generateRandomMatrix(12,12);
        //Utilities.displayMatrix(matrix);

        System.out.println("Hello World!");
        System.out.println("1. Siusti vektoriu");
        System.out.println("2. Siusti teksta");
        System.out.println("3. Siusti paveiksleli");
        System.out.print("Jusu pasirinkimas: ");

        Scanner reader = new Scanner(System.in);
        int n;

        while(true) {
            n = reader.nextInt();
            switch (n) {
                case 1:
                    String vector;
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Iveskite norima vektoriu");
                    //vector = sc.nextLine();
                    coding.createBMatrix("12345678901");

                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Neteisinga ivestis, bandykite is naujo");
            }
        }
    }
}
