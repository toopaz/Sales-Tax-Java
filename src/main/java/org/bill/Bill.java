package org.bill;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Bill {

    private List<BillItem> billItems = new ArrayList<>() ;
    private double totalTax;
    private double totalPriceIncludedTax;

    private static final DecimalFormat df = new DecimalFormat("0.00");
    public List<BillItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<BillItem> billItems) {
        this.billItems = billItems;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getTotalPriceIncludedTax() {
        return totalPriceIncludedTax;
    }

    public void setTotalPriceIncludedTax(double totalPriceIncludedTax) {
        this.totalPriceIncludedTax = totalPriceIncludedTax;
    }

    public void addItem(BillItem billItem){
        billItems.add(billItem);
    }

    /**
     * print bill detail
     * @return
     */
    public String printBillDetail() {
        String imported = "";
        StringBuilder builder = new StringBuilder();
        for(BillItem billItem: billItems){
            imported = billItem.getGood().isImported() ? "imported " : "";
            builder.append(billItem.getQuantity())
                    .append(" ")
                    .append(imported)
                    .append(billItem.getGood().getName())
                    .append(":")
                    .append(df.format((billItem.getGood().getPrice() +  billItem.getTax())* billItem.getQuantity()))
                    .append("\n");
        }
        df.setRoundingMode(RoundingMode.UP);
        builder.append("Sales Taxes: ")
                .append(df.format(totalTax))
                .append("\n")
                .append("Total: ")
                .append(df.format(totalPriceIncludedTax))
                .append("\n");

        return builder.toString();
    }
}
