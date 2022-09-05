package org.example.Sem2_OOP.HumanAndAnimals.Animal;

/**
 * @author DimS on 05.09.2022
 */
public class Parrot extends Animal{
    public Parrot(String nickName) {
        super(nickName);
    }

    @Override
    public void voice() {
        System.out.println("Попка - дурак!");
    }

    @Override
    public void move(Integer length) {
        System.out.printf("Попугай придвинулся на %d см \n", length);
    }

    @Override
    public void moveAway(Integer length) {
        System.out.printf("Попугай отодвинулся на %d см \n", length);
    }

    @Override
    public void roar() {
        System.out.println("Попка - дурак!");
    }
}
