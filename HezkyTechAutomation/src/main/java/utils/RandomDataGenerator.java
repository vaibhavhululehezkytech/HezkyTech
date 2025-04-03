package utils;

import java.util.Random;

public class RandomDataGenerator {
	
	private RandomDataGenerator() {
	    throw new IllegalStateException("RandomDataGenerator class");
	  }

    public static String getRandomNumberWithinRange(int min, int max) {
        int number = new Random().nextInt((max - min) + 1) + min;
        return String.valueOf(number);
    }

    public static String generateRandomNumberOfLength(int strLen) {
        // chose a random integer from this String
        String number = "123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(strLen);

        for (int i = 0; i < strLen; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = new Random().nextInt(number.length());

            // add Character one by one in end of sb
            sb.append(number.charAt(index));
        }

        return sb.toString();
    }

    public static String generateRandomStringOfLength(int strLen) {
        // chose a Character random from this String
        String alphaNumericString = "abcdefghijklmnopqrstuvwxyz0123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(strLen);

        for (int i = 0; i < strLen; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = new Random().nextInt(25);

            // add Character one by one in end of sb
            sb.append(alphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    public static String getRandomEmailAddress(int strlen) {

        return generateRandomStringOfLength(strlen) + "@mailsac.com";
    }

}
