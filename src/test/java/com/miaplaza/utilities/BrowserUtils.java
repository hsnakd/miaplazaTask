package com.miaplaza.utilities;


import com.github.javafaker.Faker;

public class BrowserUtils {

    /*
This method will accept int (in seconds) and execute Thread.sleep for a given duration
 */
    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException ignored) {
        }
    }

    public static String generateTurkishPhoneNumber(Faker faker) {
        // Generate a random phone number in the format 5XX-XXX-XXXX
        String prefix = "5" + faker.number().numberBetween(30, 59); // Prefixes between 530 and 559
        String middle = faker.number().digits(3); // 3-digit middle part
        String last = faker.number().digits(4); // 4-digit last part

        return prefix + middle + last;
    }

}


