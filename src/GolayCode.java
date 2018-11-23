import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class GolayCode {

    Coding coding = new Coding();
    Channel channel = new Channel();
    Decoding decoding = new Decoding();


    public void program() {
        //Utilities.displayArray(coding.codeInformationPerfect("101101100101"));                   // result 1 0 1 1 0 1 1 0 0 1 0 1 1 0 0 1 1 0 1 0 1 0 0 0
        //decoding.decode(new int []{1,1,1,1,1,1,1,0,1,1,1,1,0,1,0,0,1,0,0,1,0,0,1,0}); // result 1 0 0 0 0 0 0 0 0 0 0 1
        //decoding.decode(new int []{0,0,1,0,0,1,0,0,1,1,0,1,1,0,1,0,0,0,1,0,1,0,0,0});     // result 1 1 0 0 0 1 0 0 1 0 0 1
        //decoding.decode(new int []{0,0,0,1,1,1,0,0,0,1,1,1,0,1,1,0,1,1,0,1,0,0,0,0});     // result 1 1 1 0 0 1 1 1 1 1 0 1
        //int [] code = coding.codeInformation("101101100101"); //1 0 1 1 0 1 1 0 0 1 0 1 1 0 0 1 1 0 1 0 1 0 0 0
        //int [] code = coding.codeInformationPerfect("101101100101");
        //decoding.decode(new int []{0,0,1,0,0,1,0,0,1,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0});
        //decoding.decode(code);

        boolean run = true;

        Scanner reader = new Scanner(System.in);
        int n;

        while (run) {
            System.out.println("\nIveskite pasirinkima");
            System.out.println("1. Siusti vektoriu");
            System.out.println("2. Siusti teksta");
            System.out.println("3. Baigti darba");

            try {
                n = reader.nextInt();
            } catch (Exception e) {
                System.out.println("Blogas pasirinkimas");
                break;
            }
            switch (n) {
                case 1:
                    sendVector();
                    break;
                case 2:
                    sendText();
                    break;
                case 3:
                    System.out.println("Baigti darba");
                    break;
                default:
                    System.out.println("Neteisingas pasirinkimas");
            }
        }
    }

    public void sendVector() { //Metodas skirtas vykdyti vektoriaus siuntima
        Scanner read = new Scanner(System.in);
        System.out.print("Iveskite vektoriu: ");
        String vector = read.nextLine();
        if (vector.matches("^[01]+$") && vector.length() == 12) { // Patikrinam ar vektorius susideda tik is ir
            System.out.print("Jusu vektorius: " + vector);
            coding.codeInformationPerfect(vector);
            System.out.println();
        } else {
            System.out.println("Blogai ivedete vektoriu");
        }
        int[] encodedMessage = coding.codeInformationPerfect(vector); //Uzkoduojamas ivestas vektorius

        System.out.print("Jusu uzkuoduota zinute: ");
        Utilities.displayArray(encodedMessage);
        changeCode(encodedMessage); // Pakeiciami jo bitai pagal poreiki

        int[] finalVector = new int[24];
        Utilities.copyArray(finalVector, encodedMessage);

        if (Utilities.vectorWeight(finalVector) % 2 == 0) {
            finalVector[23] = 1;
        }

        System.out.println("Kanalas");
        System.out.println("Iveskite klaidos tikimybe: ");
        float errorPossibility = read.nextFloat();

        channel.chanell(finalVector, errorPossibility); // Perleidziama per nepatikima kanala
        finalVector = decoding.decode(finalVector); // Dekoduojame vektoriu

        if (finalVector != null) {
            Utilities.displayOriginalMessage(finalVector);
        }
    }

    public void changeCode(int[] code) { // Matodas skirtas pakeisti pasirinkta bita is masyvo(1 i 0 ir 0 i 1). Kaip parametra gauna vectoriaus masyva
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

    public void sendText() {    //Teksto siuntimui skitas metodas
        System.out.println("Koki zodi norite siusti?");
        Scanner read = new Scanner(System.in);
        String word = read.nextLine(); // Ivedamas zmotis kuri norime siusti
        char[] letters = word.toCharArray(); // Isskaidome ji i char'u masyva
        int[] ascii = new int[letters.length];
        String[] information = new String[ascii.length];


        for (int i = 0; i < ascii.length; i++) { // Charus pakeiciasia i desimtaines ascii reiksmes
            ascii[i] = (int) letters[i];
        }

        for (int i = 0; i < ascii.length; i++) {
            information[i] = Integer.toBinaryString(ascii[i]); // Suvormuojamas binjarinis vektorius pagal ascii reiksmes
        }

        Utilities.normalizeInformation(information); // prodedama nuliu kiek truksta iki  12 bitu

        int[][] encodedString = new int[information.length][24];
        for (int i = 0; i < information.length; i++) {
            encodedString[i] = coding.codeInformationPerfect(information[i]); // Visos raides uzkoduojamas
        }

        int[][] finalVector = new int[information.length][24];

        System.out.println("Kanalas");
        System.out.println("Iveskite klaidos tikimybe: ");

        float errorPossibility = read.nextFloat();

        for (int i = 0; i < information.length; i++) {
            Utilities.copyArray(finalVector[i], encodedString[i]);

            if (Utilities.vectorWeight(finalVector[i]) % 2 == 0) {
                finalVector[i][23] = 1;
            }

            channel.chanell(finalVector[i], errorPossibility); //Raides perleidizamos per nepatikima kanala

            finalVector[i] = decoding.decode(finalVector[i]); // Dekoduojamas gautas vektorius
            if (finalVector[i] == null) {
                finalVector[i] = Utilities.nullVector();
            }

            if (finalVector[i] != null) {
                Utilities.displayOriginalMessage(finalVector[i]);
            }
        }

        String[] binnaryString = Utilities.convertToStringArray(finalVector);
        int[] asciiValue = new int[binnaryString.length];
        System.out.println("\nDekoduota zinute:");
        for (int i = 0; i < binnaryString.length; i++) {
            asciiValue[i] = Integer.parseInt(binnaryString[i], 2); // Visos dekoduotos zinutes atgal paverciamos i teksta ir parodomos vartotojui
            if ((char) asciiValue[i] == 64) {
                System.out.print(" ");
            } else {
                System.out.print((char) asciiValue[i]);
            }
        }

        //System.out.println((char)asciiValue);


    }
}


