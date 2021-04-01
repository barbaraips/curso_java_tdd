import com.sun.jdi.InvalidTypeException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    static List<String> converterCamelCase(String original) {

        try {
            validateString(original);
        } catch (InvalidTypeException e) {
            //
        }

        List<String> splittedString = Arrays.asList(original.split("(?<=[a-z])(?=[A-Z0-9])|(?<=[A-Z0-9])(?=[A-Z][a-z])"));

        for (String entry : splittedString) {
            if (!entry.matches("([A-Z]*)")) {
                splittedString.set(splittedString.indexOf(entry), entry.toLowerCase());
            }
        }

        return splittedString;
    }

    static void validateString(String original) throws InvalidTypeException {

        Pattern p = Pattern.compile("^([0-9]*)|(\\W)");
        Matcher m = p.matcher(original);

        if (m.find()) {
            throw new InvalidTypeException();
        }
    }
}
