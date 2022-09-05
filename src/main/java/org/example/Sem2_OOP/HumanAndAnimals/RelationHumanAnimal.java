package org.example.Sem2_OOP.HumanAndAnimals;

import org.example.Sem2_OOP.HumanAndAnimals.Animal.Animal;
import org.example.Sem2_OOP.HumanAndAnimals.Human.Human;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelationHumanAnimal implements RelationInterface {

    /*    private Human human;
        private List<Animal> animal;*/
    private Map<Human, List<Animal>> humanToAnimals;

    public RelationHumanAnimal() {
        humanToAnimals = new HashMap<>();
    }

    @Override
    public void addAnimalToHuman(Human human, Animal animal) {
        if (humanToAnimals.containsKey(human)) {
            humanToAnimals.get(human).add(animal);
        } else {
            List<Animal> forAdding = new ArrayList<>();
            forAdding.add(animal);
            humanToAnimals.put(human, forAdding);
        }
    }

    @Override
    public List<Animal> returnAnimalsByHuman(Human human) {
        return humanToAnimals.get(human);
    }

    @Override
    public void callTheAnimal(Human human, Animal animal) {
        if(humanToAnimals.containsKey(human)){
            if(humanToAnimals.get(human).contains(animal)){
                animal.move(10);
            }else{
                animal.moveAway(10);
            }
        }
    }

    @Override
    public void commandVoice(Human human, Animal animal) {
        if(humanToAnimals.containsKey(human)){
            if(humanToAnimals.get(human).contains(animal)){
                animal.voice();
            }else {
                animal.roar();
            }
        }
    }


    /*    public RelationHumanAnimal(Human human) {
        this.human = human;
        animal = new ArrayList<>();
    }*/
}

