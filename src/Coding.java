import java.util.Arrays;

public class Coding {

    public int[] codeInformation(String information){

        String[] informationArray = information.split("");
        int[] intElements = Arrays.asList(informationArray).stream().mapToInt(Integer::parseInt).toArray();

        int[] result = Utilities.oneDimension(Utilities.multiplyMatrix(Utilities.multiDimension(intElements),Matrix.G));

        Utilities.moduloArray(result);

        return result;
    }
}
