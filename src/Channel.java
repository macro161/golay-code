import java.util.Random;
import java.util.Scanner;

public class Channel {
    public void chanell(int [] code){
        Scanner reader = new Scanner(System.in);
        Random r = new Random();
        double randomValue = r.nextDouble();
        float errorPossibility = 0;
        int errors = 0;
        int [] errorPlaces = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        System.out.println("Kanalas");
        System.out.println("Iveskite klaidos tikimybe: ");
        errorPossibility = reader.nextFloat();

        for(int i = 0; i < code.length;i++){
            if(r.nextDouble() < errorPossibility)
            {
                Utilities.flipBit(code, i+1);
                errorPlaces[i] = 1;
            }
        }

        System.out.println("Is kanalo isejes vektorius : ");
        Utilities.displayArray(code);
        System.out.println("Klaidu vietos");
        Utilities.displayArray(errorPlaces);


    }
}
