package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authenticator {
    static String PASSWORD = "default";

    static boolean auth(){
        boolean accepted = false;
        for(int  i = 0; i <3; i++){
            System.out.print("Password: ");
            String input = Main.SCANNER.nextLine();

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
