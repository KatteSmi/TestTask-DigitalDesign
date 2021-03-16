import java.util.Arrays;
import java.util.regex.Pattern;

public class UnpackingString {
    public static String stringTransformation(char[] inputString) throws NullPointerException {
        StringBuilder outputString = new StringBuilder();
        int result = 0;
        int quantityBrace = 0;
        int firstBrace = 0;

        for (int i = 0; i < inputString.length; i ++) {

            if (Character.isLetter(inputString[i]) && quantityBrace == 0)
                outputString.append(inputString[i]);

            if (Character.isDigit(inputString[i]) && quantityBrace == 0)
                result = Integer.parseInt(String.valueOf(inputString[i]));

            if (inputString[i] == '[') {
                quantityBrace++;
                if (quantityBrace == 1) {
                    firstBrace = i;
                }
            }

            if (inputString[i] == ']') {
                quantityBrace--;
                if (quantityBrace == 0) {
                    outputString.append(stringTransformation(Arrays
                            .copyOfRange(inputString, firstBrace + 1, i))
                            .repeat(result));
                    firstBrace = 0;
                    result = 0;
                }
            }
        }
        return outputString.toString();
    }

    public static boolean validationCheck (String inputString){
        int quantityBrace = 0;

        for (int i = 0; i < inputString.length(); i ++){

            if (Character.isDigit(inputString.toCharArray()[i]))
                if (inputString.toCharArray()[i+1]!='[') {
                    return false;
                }

            if (inputString.toCharArray()[i] == '[') {
                quantityBrace++;
            }

            if (inputString.toCharArray()[i] == ']') {
                quantityBrace--;
                if (quantityBrace < 0) {
                    return false;
                }
            }
        }

        if (quantityBrace != 0) {
            return false;
        }

        return (Pattern.matches("[a-zA-Z\\[\\]\\d]+",inputString));
    }
}
