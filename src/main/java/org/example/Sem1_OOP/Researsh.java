package org.example.Sem1_OOP;

import java.util.HashSet;
import java.util.Set;

public class Researsh {
    protected Set<Relation> allRelation = new HashSet<>();

    public Set<Person> findRelation(String name, RelationType type) {
        Set<Person> result = new HashSet<>();
        switch (type){
            case PARENT:
            case CHILD:
            case MARRIED:
                result = findRelationOnce(name, type);
                break;
            case UNCLE:
                result.addAll(findRelationOnce(name, RelationType.UNCLE));
                for (Person pers1 : findRelationOnce(name, RelationType.CHILD)) {
                    for(Person pers2 : findRelationOnce(pers1.getName(), RelationType.CHILD)) {
                        for(Person pers3 : findRelationOnce(pers2.getName(), RelationType.PARENT)) {
                            result.add(pers3);
                        }
                        result.remove(pers2);
                    }
                    result.remove(pers1);
                }
                break;
            case GRANDPARENT:
                result.addAll(findRelationOnce(name, RelationType.GRANDPARENT));
                for (Person pers1 : findRelationOnce(name, RelationType.CHILD)) {
                    for(Person pers2 : findRelationOnce(pers1.getName(), RelationType.CHILD)) {
                        result.add(pers2);
                    }
                }
                break;
            case SIBS:
                result.addAll(findRelationOnce(name, RelationType.SIBS));
                for (Person pers1 : findRelationOnce(name, RelationType.CHILD)) {
                    for(Person pers2 : findRelationOnce(pers1.getName(), RelationType.PARENT)) {
                        result.add(pers2);
                        if(pers2.getName() == name) result.remove(pers2);
                    }
                }
                break;
            case GRANDCHILD:
                result.addAll(findRelationOnce(name, RelationType.GRANDCHILD));
                for (Person pers1 : findRelationOnce(name, RelationType.PARENT)) {
                    for(Person pers2 : findRelationOnce(pers1.getName(), RelationType.PARENT)) {
                        result.add(pers2);
                    }
                }
                break;
            case GREAT_GRANDPARENT:
                result.addAll(findRelationOnce(name, RelationType.GREAT_GRANDPARENT));
                for (Person pers1 : findRelationOnce(name, RelationType.CHILD)) {
                    for(Person pers2 : findRelationOnce(pers1.getName(), RelationType.CHILD)) {
                        for(Person pers3 : findRelationOnce(pers2.getName(), RelationType.CHILD)) {
                            result.add(pers3);
                        }
                    }
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return result;
    }
    private Set<Person> findRelationOnce(String name, RelationType type){
        Set<Person> result = new HashSet<>();
        for (Relation relation : allRelation) {
            if (relation.member1.getName().equals(name) && relation.relationType == type) {
                result.add(relation.member2);
            }
        }
        return result;
    }
}
