package org.example.Sem3_OOP;

import java.util.List;

public class ServiceWardrobe implements ActionWardrobe {

    @Override
    public void open(Wardrobe wd, Human hm) {
        if (this.isOpen(wd)) {
            System.out.println("Шкаф уже открыт");
        } else {
            if (wd.keyOk(hm.getFingerprint())) {
                wd.setOpen(true);
                System.out.println("Шкаф открыли");
            } else {
                System.out.println("Шкаф закрыт на замок");
            }
        }
    }

    @Override
    public void close(Wardrobe wd) {
        if (this.isOpen(wd)) {
            wd.setOpen(false);
            System.out.println("Шкаф закрыли");
        } else {
            System.out.println("Шкаф уже закрыт");
        }
    }

    @Override
    public boolean isOpen(Wardrobe wardrobe) {
        return wardrobe.isOpen();
    }

    public void putItem(Wardrobe wd, Human human, String item) {
        if (this.isOpen(wd)) {
            wd.addItem(item);
            System.out.printf("Вещь %s положили в шкаф", item);
            System.out.println();
        } else {
            System.out.println("Шкаф закрыт на замок");
        }
    }
    public void takeItem(Wardrobe wd, Human human, String item) {
        if (this.isOpen(wd)) {
            wd.delItem(item);
            System.out.printf("Вещь %s забрали из шкафа", item);
            System.out.println();
        } else {
            System.out.println("Шкаф закрыт на замок");
        }
    }

    public List<String> takeItemAll(Wardrobe wd, Human human) {
        if (this.isOpen(wd)) {
            System.out.println("Шкаф очищен от всех вещей: ");
            return wd.pullAllItemsOut();
        } else {
            System.out.println("Шкаф закрыт на замок");
            return null;
        }
    }

    public List<String> viewItemList(Wardrobe wd) {
        if (this.isOpen(wd)) {
            return wd.getItemList();
        }else {
            System.out.println("Шкаф закрыт на замок");
            return null;
        }
    }
    public void setOwner(Wardrobe wd, Human hm){
        wd.addFingerprint(hm.getFingerprint());
    }
    public void deleteOwner(Wardrobe wd, Human hm){
        wd.deleteFingerprint(hm.getFingerprint());
    }

}
