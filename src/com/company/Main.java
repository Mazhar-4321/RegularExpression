package com.company;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private User user = new User();

    public static void main(String[] args) {
        System.out.println("Welcome To Regular Expressions Program");
        Main main = new Main();
        main.validateUserRegistration();
    }

    private void validateUserRegistration() {
        user.setFirstName(validateName("firstName"));
        user.setLastName(validateName("lastName"));
    }

    private String validateName(String firstNameOrLastName) {
        System.out.println("Please Enter Your " + firstNameOrLastName);
        String name = scanner.next();
        String pattern = "^[A-Z][a-zA-Z0-9[^a-zA-Z0-9]]{2,}";
        while (!name.matches(pattern)) {
            System.out.println("Invalid " + firstNameOrLastName + ", it must start with Uppercase Alphabet followed by atleast two characters");
            System.out.println("Please Re enter your " + firstNameOrLastName);
            name = scanner.next();
        }
        System.out.println("The " + firstNameOrLastName + " entered is registered successfully");
        return name;
    }
}
