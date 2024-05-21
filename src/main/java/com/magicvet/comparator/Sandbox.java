package main.java.com.magicvet.comparator;

import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.Size.M, Pet.HealthState.GOOD),
                new Dog(Dog.Size.S, Pet.HealthState.EXCELLENT),
                new Dog(Dog.Size.XL, Pet.HealthState.POOR),
                new Dog(Dog.Size.XL, Pet.HealthState.GOOD),
                new Dog(Dog.Size.XS, Pet.HealthState.CRITICAL),
                new Dog(Dog.Size.S, Pet.HealthState.CRITICAL)
        };
        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getHealthState().getValue() - o2.getHealthState().getValue();
            }
        });
        for (Dog dog : dogs){
            System.out.println(dog.getHealthState());
        }
    }
}
