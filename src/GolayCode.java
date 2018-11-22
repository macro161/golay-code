import java.util.Scanner;

public class GolayCode {

    Coding coding = new Coding();
    Channel channel = new Channel();
    Decoding decoding = new Decoding();


    public void program() {
        //Utilities.displayArray(coding.codeInformation("101101100101"));                   // result 1 0 1 1 0 1 1 0 0 1 0 1 1 0 0 1 1 0 1 0 1 0 0 0
        //decoding.decode(new int []{1,1,1,1,1,1,1,0,1,1,1,1,0,1,0,0,1,0,0,1,0,0,1,0}); // result 1 0 0 0 0 0 0 0 0 0 0 1
        //decoding.decode(new int []{0,0,1,0,0,1,0,0,1,1,0,1,1,0,1,0,0,0,1,0,1,0,0,0});     // result 1 1 0 0 0 1 0 0 1 0 0 1
        //decoding.decode(new int []{0,0,0,1,1,1,0,0,0,1,1,1,0,1,1,0,1,1,0,1,0,0,0,0});     // result 1 1 1 0 0 1 1 1 1 1 0 1
        //int [] code = coding.codeInformation("101101100101"); //1 0 1 1 0 1 1 0 0 1 0 1 1 0 0 1 1 0 1 0 1 0 0 0
        //int [] code = coding.codeInformationPerfect("101101100101");
        //decoding.decode(new int []{0,0,1,0,0,1,0,0,1,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0});
        //decoding.decode(code);

        boolean run = true;

        Scanner reader = new Scanner(System.in);

        while (run) {
            System.out.println("Iveskite pasirinkima");
            System.out.println("1. Siusti vektoriu");
            System.out.println("2. Siusti teksta");
            System.out.println("3. Siusti paveiksliuka");
            int n = reader.nextInt();
            switch (n) {
                case 1:
                    sendVector();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Baigti darba");
                    break;
                default:
                    System.out.println("Neteisingas pasirinkimas");
            }
        }
    }

    public void sendVector() {
        Scanner read = new Scanner(System.in);
        System.out.print("Iveskite vektoriu: ");
        String vector = read.nextLine();
        if (vector.matches("^[01]+$") && vector.length() == 12) {
            System.out.print("Jusu vektorius: " + vector);
            coding.codeInformationPerfect(vector);
            System.out.println();
        } else {
            System.out.println("Blogai ivedete vektoriu");
        }
        int[] encodedMessage = coding.codeInformationPerfect(vector);

        System.out.print("Jusu uzkuoduota zinute: ");
        Utilities.displayArray(encodedMessage);
        changeCode(encodedMessage);
        passThroughChannel(encodedMessage);
    }

    public void changeCode(int[] code) {
        boolean run = true;

        Scanner read = new Scanner(System.in);
        while (run) {
            System.out.println("Ar norite pakeisti vektoriu?");
            System.out.println("1. Taip");
            System.out.println("2. Ne");
            int x = read.nextInt();
            if (x == 2) {
                run = false;
            }
            if (x == 1) {
                System.out.println("Kuria pozicija norite pakeisti?: ");
                int position = read.nextInt();
                Utilities.flipBit(code, position);
                System.out.println("Naujas vektorius: ");
                Utilities.displayArray(code);
            }
        }


    }

    public void passThroughChannel(int [] encodedMessage){

    }

    public void sendText() {
    }

    public void sendImage() {
    }
}


