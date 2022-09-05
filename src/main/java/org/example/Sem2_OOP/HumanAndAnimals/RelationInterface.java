package org.example.Sem2_OOP.HumanAndAnimals;

import org.example.Sem2_OOP.HumanAndAnimals.Animal.Animal;
import org.example.Sem2_OOP.HumanAndAnimals.Human.Human;

import java.util.List;

public interface RelationInterface {
    void addAnimalToHuman(Human human, Animal animal);
    List<Animal> returnAnimalsByHuman(Human human);
    void callTheAnimal(Human human, Animal animal);

    void commandVoice(Human human, Animal animal);
}
