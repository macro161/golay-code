import java.util.Arrays;

public class Coding {

    public int[] codeInformation(String information){

        String[] informationArray = information.split("");
        int[] intElements = Arrays.asList(informationArray).stream().mapToInt(Integer::parseInt).toArray();

        int[] result = Utilities.oneDimension(Utilities.multiplyMatrix(Utilities.multiDimension(intElements),Matrix.G));

        Utilities.moduloArray(result);

        return result;
    }

    public int[] codeInformationPerfect(String information)
    {
        int [] encodedMessage;
        String[] informationArray = information.split("");
        int[] intElements = Arrays.asList(informationArray).stream().mapToInt(Integer::parseInt).toArray();

        encodedMessage = Utilities.oneDimension(Utilities.multiplyMatrix(Utilities.multiDimension(intElements),Matrix.G11));
        Utilities.moduloArray(encodedMessage);

        int [] result = new int [24];
        Utilities.copyArray(result,encodedMessage);

        if(Utilities.vectorWeight(result) % 2 == 0){
            result[23] = 1;
        }

        return result;
    }
}
