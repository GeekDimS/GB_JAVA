package org.example.Sem2_OOP.HumanAndAnimals.Animal;

public class Dog extends Animal{

    public Dog(String nickName) {
        super(nickName);
    }

    @Override
    public void voice() {
        System.out.println("Гав-гав");
    }

    @Override
    public void move(Integer length) {
        System.out.printf("Собака подошла ближе на %d метров \n", length);
    }

    @Override
    public void moveAway(Integer length) {
        System.out.printf("Собака отбежала на %d метров \n", length);
    }

    @Override
    public void roar() {
        System.out.println("Рррррррр!!!");
    }
}
