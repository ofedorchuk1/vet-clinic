package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String NAME_PATTERN = "^[a-zA-Z\\-]{3,}$";

    public Optional<Client> registerNewClient() {
        Client client = null;


        System.out.println("Please provide a client details.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();

        if (isEmailValid(email)) {
            client = buildClient(email);
            System.out.println("New client: " + client.getFirstName() + " " + client.getLastName() + " (" + client.getEmail() + ")");
        } else {
            System.out.println("Provided email is invalid.");
        }

        return Optional.ofNullable(client);
    }

    private static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);

        String firstName;
        System.out.print("First name: ");
        do {
            firstName = Main.SCANNER.nextLine();
            if (isNameValid(firstName)) System.out.print("First name is invalid. Try again.\nFirst name: ");
        } while (isNameValid(firstName));
        client.setFirstName(firstName);


        String lastName;
        System.out.print("Last name: ");
        do {
            lastName = Main.SCANNER.nextLine();
            if (isNameValid(lastName)) System.out.print("Last name is invalid. Try again.\nLast name: ");
        } while (isNameValid(lastName));
        client.setLastName(lastName);

        System.out.print("Location: ");
        String location = Main.SCANNER.nextLine();

        client.setLocation(Client.Location.fromString(location));
        return client;
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return !matcher.matches();
    }
}
