import com.sun.jdi.InvalidTypeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

    @Test
    void testWordSplit() {
        List<String> list1 = Arrays.asList("camel", "case");
        List<String> list2 = Arrays.asList("numero", "CPF", "contribuinte");
        List<String> list3 = Arrays.asList("numero", "CPF");

        Assertions.assertEquals(list1, Main.converterCamelCase("camelCase"));
        Assertions.assertEquals(list2, Main.converterCamelCase("numeroCPFContribuinte"));
        Assertions.assertEquals(list3, Main.converterCamelCase("numeroCPF"));
    }

    @Test
    void testWordNumbersSplit() {
        List<String> list = Arrays.asList("recupera", "10", "primeiros");
        Assertions.assertEquals(list, Main.converterCamelCase("recupera10Primeiros"));
    }

    @Test
    void testOneWordOnly() {
        List<String> list1 = Collections.singletonList("nome");
        List<String> list2 = Collections.singletonList("nome");
        List<String> list3 = Collections.singletonList("CPF");

        Assertions.assertEquals(list1, Main.converterCamelCase("nome"));
        Assertions.assertEquals(list2, Main.converterCamelCase("nome"));
        Assertions.assertEquals(list3, Main.converterCamelCase("CPF"));
    }


    @Test
    void testInvalidString() {
        String word1 = "10Primeiros";
        String word2 = "nome#Composto";
        assertThrows(InvalidTypeException.class,
            () -> {
                Main.validateString(word1);
                Main.validateString(word2);
            });
    }


}