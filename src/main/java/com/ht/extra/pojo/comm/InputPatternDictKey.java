package com.ht.extra.pojo.comm;

public class InputPatternDictKey {
    private String dictName;

    private String inputItemName;

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getInputItemName() {
        return inputItemName;
    }

    public void setInputItemName(String inputItemName) {
        this.inputItemName = inputItemName == null ? null : inputItemName.trim();
    }
}