package org.example.Sem1_OOP;

import java.util.List;

public class Tree {
    public static void main(String[] args) {

        Person human1 = new Person("Вася", "Чернов", 25, SexType.MAN);
        Person human2 = new Person("Александр", "Чернов", 60, SexType.MAN);
        Person human3 = new Person("Любовь", "Чернова", 59, SexType.WOMAN);
        Person human4 = new Person("Маша", "Чернова", 2, SexType.WOMAN);
        Person human5 = new Person("Лена", "Чернова", 25, SexType.WOMAN);
        Person human6 = new Person("Филимон", "Чернов", 58, SexType.MAN);
        Person human7 = new Person("Борис", "Чернов", 80, SexType.MAN);

        Relation relation1 = new Relation(human1, human4, RelationType.PARENT);
        Relation relation2 = new Relation(human5, human4, RelationType.PARENT);
        Relation relation3 = new Relation(human2, human1, RelationType.PARENT);
        Relation relation4 = new Relation(human3, human1, RelationType.PARENT);

        Relation relation5 = new Relation(human1, human2, RelationType.CHILD);
        Relation relation6 = new Relation(human1, human3, RelationType.CHILD);
        Relation relation7 = new Relation(human4, human1, RelationType.CHILD);
        Relation relation8 = new Relation(human4, human5, RelationType.CHILD);

        Relation relation9 = new Relation(human2, human3, RelationType.MARRIED);
        Relation relation10 = new Relation(human2, human6, RelationType.SIBS);
        Relation relation11 = new Relation(human2, human7, RelationType.CHILD);
        Relation relation12 = new Relation(human6, human7, RelationType.CHILD);
        Relation relation13 = new Relation(human7, human2, RelationType.PARENT);
        Relation relation14 = new Relation(human7, human6, RelationType.PARENT);


        Researsh allRelation = new Researsh();

        allRelation.allRelation.addAll(List.of(relation1,relation2,relation3,relation4,relation5,relation6,relation7,
            relation8,relation9,relation10));
        allRelation.allRelation.add(relation11);
        allRelation.allRelation.add(relation12);
        allRelation.allRelation.add(relation13);
        allRelation.allRelation.add(relation14);
        System.out.println(allRelation.findRelation("Вася", RelationType.UNCLE));   //поиск дяди/тёти
        System.out.println(allRelation.findRelation("Маша", RelationType.GRANDPARENT));
        System.out.println(allRelation.findRelation("Маша", RelationType.GREAT_GRANDPARENT));
        System.out.println(allRelation.findRelation("Александр", RelationType.SIBS));
        System.out.println(allRelation.findRelation("Борис", RelationType.GRANDCHILD));
        System.out.println(RelationType.CHILD.getCode());
    }
}
