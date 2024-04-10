package main.java.com.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String PASSWORD = "default";
    static Scanner SCANNER = new Scanner(System.in);
    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String NAME_PATTERN = "^[a-zA-Z\\-]{3,}$";
    public static void main(String[] args) {
        run();
    }
    static void run(){
        if(auth()){
            registerNewClient();
        }
        }

    static void registerNewClient() {
        System.out.println("Please provide a client details.");
        System.out.print("Email: ");
        String email = SCANNER.nextLine();

        if(isEmailValid(email)){
            Client client = buildClient(email);
            System.out.println("New client: " + client.firstName + " " + client.lastName + " ("+ client.email+")");
        } else{
            System.out.println("Provided email is invalid.");
        }
    }

    private static Client buildClient(String email) {
        Client client = new Client();
        client.email = email;

        String firstName;
        System.out.print("First name: ");
        do{
            firstName = SCANNER.nextLine();
            if(isNameValid(firstName)) System.out.print("First name is invalid. Try again.\nFirst name: ");
        } while (isNameValid(firstName));
        client.firstName = firstName;

        System.out.print("Last name: ");
        client.lastName = SCANNER.nextLine();

        String lastName;
        System.out.print("Last name: ");
        do{
            lastName = SCANNER.nextLine();
            if(isNameValid(lastName)) System.out.print("Last name is invalid. Try again.\nLast name: ");
        } while (isNameValid(lastName));
        client.lastName = lastName;

        return client;
    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return !matcher.matches();
    }

    static boolean auth(){
        boolean accepted = false;
        for(int  i = 0; i <3; i++){
            System.out.print("Password: ");
            String input = SCANNER.nextLine();

            if(PASSWORD.equals(input)){
                accepted = true;
                break;
            } else{
                System.out.println("Access denied. Please check your password.");
            }
        }
        System.out.println(accepted ? "Welcome to Magic Vet!" : "Application has been blocked");
        return accepted;
    }

}