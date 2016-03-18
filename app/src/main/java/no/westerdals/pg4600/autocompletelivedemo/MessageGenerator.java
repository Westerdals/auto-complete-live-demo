package no.westerdals.pg4600.autocompletelivedemo;

public class MessageGenerator {
    public static String countrySelectedMessage(String country) {
        if (country == null) {
            throw new IllegalArgumentException("Country cannot be null");
        }

        return "You selected " + country + ". Good job!";
    }
}
