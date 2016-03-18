package no.westerdals.pg4600.autocompletelivedemo;

import org.junit.Assert;
import org.junit.Test;

public class MessageGeneratorTest {

    @Test
    public void testMessageIsCorrect() {
        // given

        // when
        String message = MessageGenerator.countrySelectedMessage("Norway");

        // when
        String expected = "You selected Norway. Good job!";
        Assert.assertEquals(
                "Message should be positive",
                expected,
                message
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void handlesBadValues() {
        MessageGenerator.countrySelectedMessage(null);
    }
}
