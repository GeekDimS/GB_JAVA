package org.example.Sem3_OOP;

import java.util.ArrayList;
import java.util.List;

public class Wardrobe {
    static private Integer countId = 0;
    private Integer id;
    private EnamColor color;
    private List<String> itemList;
    private ScannerFingerprint sc;
    private boolean isOpen;


    public Integer getId() {
        return id;
    }

    public EnamColor getColor() {
        return color;
    }

    public Wardrobe(EnamColor color) {
        this.id = ++countId;
        this.color = color;
        this.itemList = new ArrayList<>();
        this.isOpen = false;
        this.sc = new ScannerFingerprint();
    }

    public void addItem(String item) {
        itemList.add(item);
    }
    public void delItem(String item) {
        itemList.remove(item);
    }

    public List<String> getItemList() {
        return itemList;
    }

    public List<String> pullAllItemsOut() {
        List<String> result = new ArrayList<>(getItemList());
        itemList.clear();
        return result;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
    public void addFingerprint(String fp){
        this.sc.addKey(fp);
    }
    public void deleteFingerprint(String fp){
        this.sc.deleteKey(fp);
    }
    public boolean keyOk(String fp){
        return this.sc.keyOk(fp);
    }
}
