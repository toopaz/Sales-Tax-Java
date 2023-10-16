package org.handler;

import org.model.Good;

/**
 * Contract for manage tax operations
 */
public interface ITaxHandler {

    /**
     * Calculate goods
     * @param good
     * @return double
     */
    public double calculate(Good good);

    /**
     * apply next handler
     * @param taxHandler
     */
    void setNext(ITaxHandler taxHandler);
}
