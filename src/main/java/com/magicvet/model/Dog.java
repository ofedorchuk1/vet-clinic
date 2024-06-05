package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet{

    private Size size;
    public Dog(){

    }
    public Dog(Size size, HealthState healthState){
        super();
        this.size = size;
        this.setHealthState(healthState);
    }
    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Dog {" +
                "type='" + getType() + '\'' +
                ", name='" + getName() + '\'' +
                ", sex='" + getSex() + '\'' +
                ", age='" + getAge() + '\'' +
                ", size='" + size + '\'' +
                ", ownerName='" + getOwnerName() + '\'' +
                ", registrationDate= " + getRegistrationDate().format(FORMATTER) +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(getType(), dog.getType())
                && Objects.equals(getSex(), dog.getSex())
                && Objects.equals(getAge(), dog.getAge())
                && Objects.equals(getName(), dog.getName())
                && Objects.equals(getOwnerName(), dog.getOwnerName())
                && Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }
    public enum Size{
        XS(1),
        S(2),
        M(3),
        L(4),
        XL(5),
        UNKNOWN(0);
        private final int value;
        Size(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
        public static Size fromString(String value){
            for(Size size : values()){
                if(size.toString().equals(value)){
                    return size;
                }
            }
            System.out.println("Unable to parse value '" + value
                    + "'. Using default : " + UNKNOWN);
            return UNKNOWN;
        }
    }
}
