package org.handler;

import org.model.Good;
import org.utils.TypeGoodEnum;
import org.utils.Helper;

/**
 * basic tax handler
 */
public class BasicTaxHandler extends BaseTaxHandler{
    @Override
    public double calculateTax(Good good) {
        return Helper.roundUp(good.getPrice() * 0.10, 0.05);
    }

    protected boolean applyTax(Good good){
            if(good.getType() != TypeGoodEnum.OTHER){
                return false;
            }
        return true;
    }
}
