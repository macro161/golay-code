import java.util.Random;
import java.util.Scanner;

public class Channel {
    public void chanell(int[] code, float errorPossibility) { // Nepatikimo kanalo metodas su atitinkama tikimybe pakeiciantis vektoriaus reiksme
        Random r = new Random();
        int[] errorPlaces = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < code.length; i++) {
            if (r.nextDouble() < errorPossibility) { // Jeigu atsitiktinis skaicius tarp 0 ir 1 yra mazesnis negu nurodyta klaidos tikimybe bit'as apsivers
                Utilities.flipBit(code, i + 1);
                errorPlaces[i] = 1;
            }
        }
        System.out.println("Is kanalo isejes vektorius : ");
        Utilities.displayArray(code);
        System.out.println("Klaidu vietos");
        Utilities.displayArray(errorPlaces);
    }
}
