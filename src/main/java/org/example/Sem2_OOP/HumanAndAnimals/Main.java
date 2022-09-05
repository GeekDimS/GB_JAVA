package org.example.Sem2_OOP.HumanAndAnimals;

import org.example.Sem2_OOP.HumanAndAnimals.Animal.Animal;
import org.example.Sem2_OOP.HumanAndAnimals.Animal.Cat;
import org.example.Sem2_OOP.HumanAndAnimals.Animal.Dog;
import org.example.Sem2_OOP.HumanAndAnimals.Animal.Parrot;
import org.example.Sem2_OOP.HumanAndAnimals.Human.Human;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Вася");
        Human human2 = new Human("Егор");
        Cat animalCat = new Cat("Мурка");
        Animal animalDog = new Dog("Барбос");
        Animal animalParrot = new Parrot(("Попка"));
        RelationInterface relations = new RelationHumanAnimal();
        relations.addAnimalToHuman(human1, animalCat);
        relations.addAnimalToHuman(human1, animalDog);
        relations.addAnimalToHuman(human2, animalParrot);
        System.out.println(relations.returnAnimalsByHuman(human1));
        //System.out.println(animalDog instanceof Cat);
        System.out.println(t(animalCat, Animal.class));
        relations.callTheAnimal(human1, animalCat);
        relations.commandVoice(human1, animalDog);
        relations.commandVoice(human2, animalDog);  // Команда "голос" чужому псу
        relations.callTheAnimal(human2, animalCat);  // Зовём чужого кота
        relations.commandVoice(human2, animalParrot);

    }
    public static boolean t(Animal animal, Class<?> cls){
/*        if (cls.isInstance(animal)){
            return true;
        };
        return false;*/
        return cls.isInstance(animal);
    }
}
