package com.utils;


import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * This class utilises Faker api to generate fake data needed for the apis
 * and more method could be added based upon usage
 */
public class FakeDataBuilder {

    static Faker faker = new Faker();

    public static String getRandomID() {
        return faker.number().digits(30);
    }

    public static String getRandomName() {
        return faker.name().name();
    }

    public static String getRandomCountry() {
        return faker.country().name();
    }

    public static String getRandomLogo() {
        return RandomStringUtils.randomAlphabetic(30);
    }

    public static String getRandomHeadquarter() {
        return faker.country().capital();
    }

    public static String getRandomSlogan() {
        return RandomStringUtils.randomAlphabetic(30);
    }

    public static Object getRandomYear() {
        return faker.number().numberBetween(1800, 2200);
    }

    public static String getRandomWebsite() {
        return "https://www." + RandomStringUtils.randomAlphabetic(15) + ".com";
    }

    public static String getRandomTitle() {
        return RandomStringUtils.randomAlphabetic(15);
    }

    public static int getRandomPrice() {
        return faker.number().randomDigitNotZero();
    }

    public static String getRandomDescription() {
        return RandomStringUtils.randomAlphabetic(30);
    }
}
