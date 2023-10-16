package org.utils;

public enum TypeGoodEnum {
    BOOKS(1),
    FOOD (2) ,
    MEDICAL (3),
    OTHER (4);

    public final int type;

    private TypeGoodEnum(int type) {
        this.type = type;
    }



}
