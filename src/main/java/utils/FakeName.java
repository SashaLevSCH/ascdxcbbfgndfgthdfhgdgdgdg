package utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class FakeName {

    public static String fakename() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        return firstName;
    }

    public static String fakelastname() {
        Faker faker = new Faker();
        String lastName = faker.name().lastName();
        return lastName;
    }

    public static String generateRandomEmail() {
        int rand_int1 = ThreadLocalRandom.current().nextInt();
        String email = "sidecarhealthtesting+scqa"+rand_int1 + "@gmail.com";
        return email;
    }

//    public static void main(String[] args) {
//        fakeName t = new fakeName();
//        t.fakename();
//    }
}