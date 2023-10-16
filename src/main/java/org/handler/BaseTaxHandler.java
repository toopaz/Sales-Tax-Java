package org.handler;

import org.model.Good;

public abstract class BaseTaxHandler implements ITaxHandler {

    protected ITaxHandler next;
    protected Good good;
    protected double taxe;

    @Override
    public double calculate(Good good) {
        this.good = good;
        taxe = 0;
        if(applyTax(good)) {
            taxe = calculateTax(good);
        }

        if (next != null) {
            taxe += next.calculate(good);
        }

        return taxe;
    }

    protected abstract double calculateTax(Good good);

    protected abstract boolean applyTax(Good good);

    @Override
    public void setNext(ITaxHandler next) {
        this.next = next;
    }

}
