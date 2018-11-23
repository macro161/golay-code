public class Decoding {
    public int[] decode(int[] code) { //Metodas skitas dekoduoti vektoriu. Parametrai uzkoduotas skaiciu masyvas, grazina atkoduota skaiciu masyva
        System.out.print("Gautas kodas");
        Utilities.displayArray(code);

        int[] decodedMessage = null;
        int[] u = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        boolean decoded = false;

        for (int h = 0; h < 2; h++) {
            //Pradedamas vykdyti dekodavimo algoritmas
            ////////////////////////////////////////////////////////////////////////
            //Part 1
            int[] syndromOne = Utilities.oneDimension(Utilities.multiplyMatrix(Utilities.multiDimension(code), Matrix.H));
            Utilities.moduloArray(syndromOne);
            System.out.print("Sindromas 1 :");
            Utilities.displayArray(syndromOne);
            ////////////////////////////////////////////////////////////////////////
            //Part 2

            if (Utilities.vectorWeight(syndromOne) <= 3) {
                for (int i = 0; i < 12; i++) {
                    u[i] = syndromOne[i];
                }
                System.out.print("Klaidu struktura: ");
                Utilities.displayArray(u);
                decoded = true;
                break;
            }

            ////////////////////////////////////////////////////////////////////////
            //Part 3
            boolean partThree = false;

            for (int i = 0; i < Matrix.B.length; i++) {
                if (Utilities.vectorWeight(Utilities.addVectors(syndromOne, Utilities.getRowFromMatrix(Matrix.B, i))) <= 2) {
                    int[] u1 = Utilities.addVectors(syndromOne, Utilities.getRowFromMatrix(Matrix.B, i));
                    Utilities.moduloArray(u1);
                    for (int j = 0; j < 12; j++) {
                        u[j] = u1[j];
                    }
                    u[12 + i] = 1;
                    partThree = true;
                    decoded = true;
                    break;
                }
            }
            if (partThree) {
                System.out.print("Klaidu struktura: ");
                Utilities.moduloArray(u);
                Utilities.displayArray(u);
                break;
            }
            ////////////////////////////////////////////////////////////////////////
            //Part 4
            int[] syndromTwo = Utilities.oneDimension(Utilities.multiplyMatrix(Utilities.multiDimension(syndromOne), Matrix.B));
            Utilities.moduloArray(syndromTwo);
            System.out.print("Sindromas 2 :");
            Utilities.displayArray(syndromTwo);
            ////////////////////////////////////////////////////////////////////////
            //Part 5
            if (Utilities.vectorWeight(syndromTwo) <= 3) {
                for (int i = 12; i < 24; i++) {
                    u[i] = syndromTwo[i - 12];
                }
                System.out.print("Klaidu struktura: ");
                Utilities.moduloArray(u);
                Utilities.displayArray(u);
                decoded = true;
                break;
            }
            ////////////////////////////////////////////////////////////////////////
            //Part 6
            boolean partSix = false;
            for (int i = 0; i < Matrix.B.length; i++) {
                int[] row = Utilities.getRowFromMatrix(Matrix.B, i);
                int[] syndromRow = Utilities.addVectors(syndromTwo, row);
                Utilities.moduloArray(syndromRow);

                if (Utilities.vectorWeight(syndromRow) <= 2) {
                    u[i] = 1;
                    for (int j = 12; j < 24; j++) {
                        u[j] = syndromRow[j - 12];
                    }
                    partSix = true;
                    decoded = true;
                    break;
                }
            }
            if (partSix) {
                System.out.print("Klaidu struktura:");
                Utilities.moduloArray(u);
                Utilities.displayArray(u);
                break;
            }
            break;
        }

        if (decoded) {
            decodedMessage = Utilities.addVectors(code, u); // Sudedam klaidos vektoriu su gautu kodu
            Utilities.moduloArray(decodedMessage);
            System.out.print("Issiustas vektorius: ");
            Utilities.displayArray(decodedMessage);
        } else {
            System.out.println("Dekoduoti nepavyko");
        }
        ////////////////////////////////////////////////////////////////////////
        return decodedMessage;
    }
}

