package org.handler;

import org.bill.Bill;
import org.bill.BillGenerator;
import org.junit.jupiter.api.Test;
import org.model.Good;
import org.utils.TypeGoodEnum;
import org.model.shopping.ShoppingCart;
import org.model.shopping.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {

    @Test()
    public void basic_sales_tax_applies_10_percent_tax(){

        Good eligible = new Good();
        eligible.setType(TypeGoodEnum.OTHER);
        eligible.setPrice(14.99);

        TaxCalculator taxCalculator = new TaxCalculator();
        taxCalculator.calculate(eligible);

        assertEquals(1.5, taxCalculator.calculate(eligible));
    }

    @Test
    public void basic_sales_tax_does_noy_applies_on_book(){

        Good eligible = new Good();
        eligible.setType(TypeGoodEnum.BOOKS);
        eligible.setPrice(14.99);
        eligible.setImported(true);

        TaxCalculator taxCalculator = new TaxCalculator();
        taxCalculator.calculate(eligible);

        assertEquals(0.75, taxCalculator.calculate(eligible));
    }

    @Test
    public void all_eligible_taxes_applies(){

        Good eligible = new Good();
        eligible.setType(TypeGoodEnum.OTHER);
        eligible.setPrice(14.99);
        eligible.setImported(true);

        TaxCalculator taxCalculator = new TaxCalculator();
        taxCalculator.calculate(eligible);

        assertEquals(2.25, taxCalculator.calculate(eligible));
    }

    @Test
    public void input1_test(){
        ShoppingCart shoppingCart = new ShoppingCart();
        ShoppingItem shoppingFirstItem = new ShoppingItem();
        shoppingFirstItem.setQuantity(1);
        Good goodBook = new Good();
        goodBook.setType(TypeGoodEnum.BOOKS);
        goodBook.setPrice(12.49);
        goodBook.setName("book");
        shoppingFirstItem.setGood(goodBook);

        ShoppingItem shoppingSecondItem = new ShoppingItem();
        shoppingSecondItem.setQuantity(1);
        Good goodMusic = new Good();
        goodMusic.setName("music CD");
        goodMusic.setType(TypeGoodEnum.OTHER);
        goodMusic.setPrice(14.99);
        shoppingSecondItem.setGood(goodMusic);

        ShoppingItem shoppingThirdItem = new ShoppingItem();
        shoppingThirdItem.setQuantity(1);
        Good goodChocolate= new Good();
        goodChocolate.setType(TypeGoodEnum.FOOD);
        goodChocolate.setName("chocolate bar");
        goodChocolate.setPrice(0.85);
        shoppingThirdItem.setGood(goodChocolate);

        List<ShoppingItem> items = new ArrayList<>();
        items.add(shoppingFirstItem);
        items.add(shoppingSecondItem);
        items.add(shoppingThirdItem);

        shoppingCart.setItems(items);

        BillGenerator generator = new BillGenerator();
        Bill bill = generator.generatedBill(shoppingCart);

        assertEquals(bill.getTotalTax(), 1.50);
        assertEquals(bill.getTotalPriceIncludedTax(), 29.830000000000005);
        assertEquals(bill.getBillItems().get(0).getPrice(), 12.49);
        assertEquals(bill.getBillItems().get(1).getPrice(), 16.490000000000002);
        assertEquals(bill.getBillItems().get(2).getPrice(), 0.85);

        System.out.println(bill.printBillDetail());
    }

    @Test
    public void input2_test(){
        ShoppingCart shoppingCart = new ShoppingCart();
        ShoppingItem shoppingFirstItem = new ShoppingItem();
        shoppingFirstItem.setQuantity(1);
        Good goodFood = new Good();
        goodFood.setType(TypeGoodEnum.FOOD);
        goodFood.setImported(true);
        goodFood.setPrice(10.00);
        goodFood.setName("box of chocolates");
        shoppingFirstItem.setGood(goodFood);

        ShoppingItem shoppingSecondItem = new ShoppingItem();
        shoppingSecondItem.setQuantity(1);
        Good goodParfum = new Good();
        goodParfum.setName("bottle of perfume");
        goodParfum.setType(TypeGoodEnum.OTHER);
        goodParfum.setPrice(47.50);
        goodParfum.setImported(true);
        shoppingSecondItem.setGood(goodParfum);

        List<ShoppingItem> items = new ArrayList<>();
        items.add(shoppingFirstItem);
        items.add(shoppingSecondItem);

        shoppingCart.setItems(items);

        BillGenerator generator = new BillGenerator();
        Bill bill = generator.generatedBill(shoppingCart);

        assertEquals(bill.getTotalTax(), 7.65);
        assertEquals(bill.getTotalPriceIncludedTax(), 65.15);
        assertEquals(bill.getBillItems().get(0).getPrice(), 10.50);
        assertEquals(bill.getBillItems().get(1).getPrice(), 54.65);

        System.out.println(bill.printBillDetail());
    }


    @Test
    public void input3_test(){
        ShoppingCart shoppingCart = new ShoppingCart();
        ShoppingItem shoppingFirstItem = new ShoppingItem();
        shoppingFirstItem.setQuantity(1);
        Good goodFood = new Good();
        goodFood.setType(TypeGoodEnum.OTHER);
        goodFood.setImported(true);
        goodFood.setPrice(27.99);
        goodFood.setName("bottle of perfume");
        shoppingFirstItem.setGood(goodFood);

        ShoppingItem shoppingSecondItem = new ShoppingItem();
        shoppingSecondItem.setQuantity(1);
        Good goodParfum = new Good();
        goodParfum.setName("bottle of perfume");
        goodParfum.setType(TypeGoodEnum.OTHER);
        goodParfum.setPrice(18.99);
        shoppingSecondItem.setGood(goodParfum);

        ShoppingItem shoppingThirdItem = new ShoppingItem();
        shoppingThirdItem.setQuantity(1);
        Good goodFood2 = new Good();
        goodFood2.setName("packet of headache pills");
        goodFood2.setType(TypeGoodEnum.FOOD);
        goodFood2.setPrice(9.75);
        shoppingThirdItem.setGood(goodFood2);

        ShoppingItem shoppingForthItem = new ShoppingItem();
        shoppingForthItem.setQuantity(1);
        Good goodFood3 = new Good();
        goodFood3.setName("box of chocolates");
        goodFood3.setType(TypeGoodEnum.FOOD);
        goodFood3.setImported(true);
        goodFood3.setPrice(11.25);
        shoppingForthItem.setGood(goodFood3);

        List<ShoppingItem> items = new ArrayList<>();
        items.add(shoppingFirstItem);
        items.add(shoppingSecondItem);
        items.add(shoppingThirdItem);
        items.add(shoppingForthItem);
        shoppingCart.setItems(items);

        BillGenerator generator = new BillGenerator();
        Bill bill = generator.generatedBill(shoppingCart);

        assertEquals(bill.getTotalTax(), 6.700000000000001);
        assertEquals(bill.getTotalPriceIncludedTax(), 74.67999999999999);

        System.out.println(bill.printBillDetail());
    }
}