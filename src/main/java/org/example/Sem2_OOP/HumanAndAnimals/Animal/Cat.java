package org.example.Sem2_OOP.HumanAndAnimals.Animal;

public class Cat extends Animal{

    public Cat(String nickName) {
        super(nickName);
    }

    @Override
    public void voice() {
        System.out.println("Мяу-мяу");
    }

    @Override
    public void move(Integer length) {
        System.out.printf("Кот подошёл на %d метров \n", length);
    }

    @Override
    public void moveAway(Integer length) {
        System.out.printf("Кот не обращает внимания \n", length);
    }

    @Override
    public void roar() {
        System.out.println("Фрррррррр!!!");
    }
}
