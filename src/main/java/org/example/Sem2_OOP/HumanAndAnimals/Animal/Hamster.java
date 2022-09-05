package org.example.Sem2_OOP.HumanAndAnimals.Animal;

/**
 * @author DimS on 05.09.2022
 */
public class Hamster extends Animal{
    public Hamster(String nickName) {
        super(nickName);
    }

    @Override
    public void voice() {
        System.out.println("Фыр-фыр");
    }

    @Override
    public void move(Integer length) {
        System.out.println("Хомяк высунулся из домика.");
    }

    @Override
    public void moveAway(Integer length) {
        System.out.println("Хомяк прячется в домик");
    }

    @Override
    public void roar() {
        System.out.println("Фыр-фыр");
    }
}
