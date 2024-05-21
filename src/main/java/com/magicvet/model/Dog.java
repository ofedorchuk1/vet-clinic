package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet{

    public static final String XS = "XS";
    public static final String S = "S";
    public static final String M ="M";
    public static final String L = "L";
    public static final String XL = "XL";
    public static final String XXL = "XXL";
    private String size;
    public Dog(){

    }
    public Dog(String size){
        this.size = size;
    }
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
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
}
