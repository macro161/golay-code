import java.util.Arrays;

public class Coding {

    public int[] codeInformationPerfect(String information) { // Metodas ivykdantis informacijos uzkodavima
        int[] encodedMessage;
        String[] informationArray = information.split("");
        int[] intElements = Arrays.asList(informationArray).stream().mapToInt(Integer::parseInt).toArray();

        encodedMessage = Utilities.oneDimension(Utilities.multiplyMatrix(Utilities.multiDimension(intElements), Matrix.G11));
        Utilities.moduloArray(encodedMessage);


        return encodedMessage;
    }
}
