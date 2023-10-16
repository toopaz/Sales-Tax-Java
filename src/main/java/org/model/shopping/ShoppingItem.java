package org.model.shopping;

import org.model.Good;

public class ShoppingItem {
    private int quantity;
    private Good good;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }
}
