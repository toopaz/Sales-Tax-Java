package org.model.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<ShoppingItem> items = new ArrayList<>();

    public List<ShoppingItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingItem> items) {
        this.items = items;
    }
}
