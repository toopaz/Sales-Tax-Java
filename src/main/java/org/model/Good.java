package org.model;

import org.utils.TypeGoodEnum;

/**
 * Good
 */
public class Good {

    private String name;
    private Double price;
    private TypeGoodEnum type;
    private boolean imported;


    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public TypeGoodEnum getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setType(TypeGoodEnum type) {
        this.type = type;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public boolean isImported() {
        return imported;
    }
}
