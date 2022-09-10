package org.example.Sem3_OOP;

public class Main {
    public static void main(String[] args) {

        Human human1 = new Human("Вася");
        Human human2 = new Human("Вера");
        Wardrobe wardrobe1 = new Wardrobe(EnamColor.BLACK);
        Wardrobe wardrobe2 = new Wardrobe(EnamColor.WHITE);

        ServiceWardrobe serviceWardrobe = new ServiceWardrobe();
        serviceWardrobe.setOwner(wardrobe1, human1);
        serviceWardrobe.setOwner(wardrobe2,human2);

        serviceWardrobe.open(wardrobe1, human2);
        serviceWardrobe.open(wardrobe1, human1);
        serviceWardrobe.open(wardrobe1, human2);

        serviceWardrobe.putItem(wardrobe1,human1,"Book");
        serviceWardrobe.putItem(wardrobe1, human2, "Shirt");

        System.out.println(serviceWardrobe.viewItemList(wardrobe1));
        System.out.println(serviceWardrobe.viewItemList(wardrobe2));
        serviceWardrobe.close(wardrobe1);
        System.out.println(serviceWardrobe.takeItemAll(wardrobe1, human1));
        System.out.println(serviceWardrobe.viewItemList(wardrobe1));
    }
}
