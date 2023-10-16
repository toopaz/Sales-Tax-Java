package org.bill;

import org.handler.TaxCalculator;
import org.model.shopping.ShoppingCart;
import org.model.shopping.ShoppingItem;

public class BillGenerator {

    private final TaxCalculator taxCalculator;
    private  double totalTax;
    private double totalPrice;
    public BillGenerator() {
        this.taxCalculator = new TaxCalculator();
    }

    public Bill generatedBill(ShoppingCart shoppingCart) {
        Bill bill = new Bill();
        for(ShoppingItem item : shoppingCart.getItems()) {
            double tax = 0;
            tax = taxCalculator.calculate(item.getGood());
            this.totalTax += tax;
            this.totalPrice += item.getGood().getPrice() + tax;
            BillItem billItem = new BillItem();
            double price =( item.getGood().getPrice() +  tax )* item.getQuantity();
            billItem.setPrice(price);
            billItem.setQuantity(item.getQuantity());
            billItem.setTax(tax);
            billItem.setGood(item.getGood());
            bill.addItem(billItem);
        };
        bill.setTotalPriceIncludedTax(totalPrice);
        bill.setTotalTax(totalTax);
    return bill;
    }

}
