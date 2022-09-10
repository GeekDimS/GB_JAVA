package org.example.Sem3_OOP;

import java.util.HashSet;

/**
 * @author DimS on 10.09.2022
 */
public class ScannerFingerprint {
    private HashSet<String> keyArr;

    public ScannerFingerprint() {
        this.keyArr = new HashSet<>();
    }

    public void addKey(String key) {
        keyArr.add(key);
    }

    public void deleteKey(String key) {
        keyArr.remove(key);
    }

    public boolean keyOk(String key) {
        return keyArr.contains(key);
    }

}
