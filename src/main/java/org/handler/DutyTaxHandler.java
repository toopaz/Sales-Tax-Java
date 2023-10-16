package org.handler;

import org.model.Good;
import org.utils.Helper;

/**
 * Duty handler
 */
public class DutyTaxHandler extends BaseTaxHandler{
    @Override
    public double calculateTax(Good good) {
            return Helper.roundUp(good.getPrice() * 0.05, 0.05);
    }

    @Override
    protected boolean applyTax(Good good) {
        return good.isImported();
    }
}
