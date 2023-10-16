package org.handler;

import org.model.Good;

/**
 * Tax calculator handler
 */
public class TaxCalculator {

    private final ITaxHandler firstHandler;

    public TaxCalculator() {
        this.firstHandler =  new BasicTaxHandler();
        ITaxHandler secondHandler = new DutyTaxHandler();
        firstHandler.setNext(secondHandler);
    }

    public double calculate(Good good){
        return firstHandler.calculate(good);
    }
}
