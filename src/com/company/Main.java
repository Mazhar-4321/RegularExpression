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
        user.setEmail(validateEmail());
        user.setMobileNumber(validateMobileNumber());
        user.setPassword(validatePassword());
    }

    private String validatePassword() {
        System.out.println("Please Enter password");
        String pattern = "(?=.*[0-9])(?=.*[A-Z])(^([a-zA-Z0-9[^a-zA-Z0-9]]{8,})$)";
        String password = scanner.next();
        String errorMessageRule1 = "Must contain at least 8 characters";
        String errorMessageRule2 = "Must contain at least 1 Upper Case character";
        String errorMessageRule3 = "Must contain at least 1 Number";
        while (!password.matches(pattern)) {
            System.out.println("Invalid Password :" + errorMessageRule1 + "," + errorMessageRule2 + " ," + errorMessageRule3);
            System.out.println("Please Enter Password");
            password = scanner.next();
        }
        System.out.println("The password entered is registered successfully");
        return password;
    }

    private String validateMobileNumber() {
        System.out.println("Please Enter Your Mobile Number");
        String mobileNumber;
        scanner.nextLine();
        String pattern = "^(91 [1-9][0-9]{9})$";
        mobileNumber = scanner.nextLine();
        while (!mobileNumber.matches(pattern)) {
            System.out.println("Invalid Mobile Number : must follow '91 XXXXXXXXXX' pattern and First Number cant be 0");
            System.out.println("Please Enter Mobile Number :");
            mobileNumber = scanner.nextLine();
        }
        System.out.println("The mobile Number entered is registered successfully");
        return mobileNumber;
    }

    private String validateEmail() {
        System.out.println("Please Enter Your Email");
        String email = scanner.next();
        String pattern = "^([a-zA-z]{3,}[0-9._+-]*(\\.[a-z]{2,})?@([a-z]{2,}|[0-9]{1})\\.[a-z]{2,}(\\.[a-z]{2,})?)$";
        while (!email.matches(pattern)) {
            System.out.println("Invalid email : must follow 'abc.xyz@bl.co.in'  pattern");
            System.out.println("Where abc,bl and co are mandatory and xyz,in are optional, @ and . positions are precise");
            System.out.println("Please Re enter email");
            email = scanner.next();
        }
        System.out.println("The email entered is registered successfully");
        return email;
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
