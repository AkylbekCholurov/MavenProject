package io.techleadacademy;

import com.github.javafaker.Faker;

public class TestData {
//    public static void main(String[] args) {
//        System.out.println(TestData.getRandomFirstName());
//        System.out.println(TestData.getRandomAddress());
//    }

        public static String getRandomFirstName () {
            Faker faker = new Faker();

            return faker.name().firstName();
        }

        public static String getRandomLastName () {
            Faker faker = new Faker();
            System.out.println(faker.name().lastName());
            return faker.name().lastName();
        }

        public static String getRandomPhoneNum () {
            Faker faker = new Faker();
            return faker.phoneNumber().phoneNumber();
        }

        public static String getRandomAddress () {
            Faker faker = new Faker();
            return faker.address().fullAddress();
        }

}
