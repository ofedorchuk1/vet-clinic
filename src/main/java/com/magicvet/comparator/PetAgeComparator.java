package main.java.com.magicvet.comparator;

import main.java.com.magicvet.model.Pet;

import java.util.Comparator;

public class PetAgeComparator implements Comparator<Pet> {
    @Override
    public int compare(Pet p1, Pet p2) {
        return convertAgeToNumber(p1.getAge()) - convertAgeToNumber(p2.getAge());
    }
    private Integer convertAgeToNumber (String age){
        try {
            return Integer.valueOf(age);
        } catch (NumberFormatException exception){
            System.out.println("Invalid input: " + age + " is not a valid integer.");
        }
        return 0;
    }
            
}
