package org.example.Sem2_OOP.HumanAndAnimals.Animal;

public abstract class Animal implements AnimalInterface{
    private String nickName;

    public Animal(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "  " + nickName;//super.toString();
    }

}
