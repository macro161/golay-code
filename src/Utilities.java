import java.util.ArrayList;

public class Utilities {

    static int[][] multiplyMatrix(int[][] A, int[][] B) {

        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        int[][] C = new int[aRows][bColumns];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0;
            }
        }

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    } //Algebrinis metodas skirtas matricu daugymai. Parametrai du dvimaciai skaiciu masyvai, grazina dvimati skaiciu masyva

    static int[] addVectors(int a[], int b[]) {

        int size = a.length;

        if (a.length > b.length) {
            size = b.length;
        }

        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] += a[i];
            result[i] += b[i];
        }
        return result;
    } //Algebrinis metodas skirtas sudeti du vektorius, parametrai du skaiciu masyvai, grazina skaiciu masyba

    static int[] getRowFromMatrix(int a[][], int row) {
        int[] result = new int[a[1].length];

        for (int i = 0; i < result.length; i++) {
            result[i] = a[row][i];
        }


        return result;
    } // Metodas skirtas paimti eilutei is matricos. Parametrai dvimatis masyvas is kurio bus paimta eilute ir skaicius nurodantis eilutes numeri

    static void displayArray(int[] array) {
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] /*% 2*/ + " ");
        }
        System.out.println(" ");
    } //Metodas atvaizduojantis masyva, parametras skaiciu masyvas

    static void moduloArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] % 2;
        }
    } //Metodas ivyukdantis modulio operacija masyvui, parametras skaiciu masyvas

    static int vectorWeight(int[] vector) {
        int result = 0;

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == 1) {
                result++;
            }
        }
        return result;
    } //Metodas pasakantis vektoriaus svori. Parametras skaitinis vektoriaus masyvas, grazina skaiciu

    static int[][] multiDimension(int[] numbers) {
        int result[][] = new int[1][numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[0][i] = numbers[i];
        }
        return result;
    } // Metodas skitas vienmati masyva paversti dvimaciu. Parametrai skaiciu masyvas kuri nori paversti dvimaciu

    static int[] oneDimension(int[][] numbers) {
        ArrayList<Integer> numbers1Dim = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            for (int x = 0; x < numbers[i].length; x++) {
                numbers1Dim.add(numbers[i][x]);
            }
        }

        int[] ret = new int[numbers1Dim.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = numbers1Dim.get(i).intValue();
        }
        return ret;
    } // Metodas skirtas dvimati masyva paversti vienmaciu. Parametrai skaiciu masyvas kuri nori paversti vienmaciu, grazina vienamati masyva

    static void copyArray(int[] firstArray, int[] secondArray) {
        for (int i = 0; i < secondArray.length; i++) {
            firstArray[i] = secondArray[i];
        }
    } //Matodas skirtas nukopijuoti viena masyva ant kito. Parametrai du vienmaciai skaiciu masyvai.

    static void flipBit(int[] vector, int position) {
        if (position < vector.length) {
            if (vector[position - 1] == 1) {
                vector[position - 1] = 0;
            } else {
                vector[position - 1] = 1;
            }
        } else {
            System.out.println("Ivedete bloga pozicija");
        }
    } // Metodas skirtas pakeisti bito reiksme masyve. Parametrai skaiciu masyvas ir pozicija kurios reiksme nori pakeisti

    static void displayOriginalMessage(int[] vector) {

        System.out.println("Pradine zinute");
        for (int i = 0; i < 12; i++) {
            System.out.print(vector[i]);
        }
    } // Metodas skirtas atsausdinti pirmus 12 skaiciu masyvo elementu kurie reprezentuos pradine zinute. Parametrai dekoduota zinute skaiciu masyvo pavidalu

    static void normalizeInformation(String[] information) {
        for (int i = 0; i < information.length; i++) {
            int length = information[i].length();
            for (int j = 0; j < 12 - length; j++) {
                information[i] += "0";
            }
        }
    } // Metodas skirtas uzpildyti masyve likusias vietas nuliai. Parametrai string'u masyvas

    static String[] convertToStringArray(int[][] information) {
        String[] binnaryStrings = new String[information.length];

        for (int i = 0; i < binnaryStrings.length; i++) {
            binnaryStrings[i] = "";
            for (int j = 0; j < 12; j++) {
                binnaryStrings[i] += information[i][j];
            }
            for (int j = 0; j < 5; j++) {
                //if(binnaryStrings[i].charAt(11-j) == '0'){
                binnaryStrings[i] = binnaryStrings[i].substring(0, binnaryStrings[i].length() - 1);


            }

        }

        return binnaryStrings;
    } // Metodas konvertuojantis dvimati skaiciu masyva i String'u masyva

    static int[] nullVector() {
        int[] vector = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        return vector;
    } // Metodas grazinantis vektoriu uzpildyta nuliais.

}
