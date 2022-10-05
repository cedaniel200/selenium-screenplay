package com.cedaniel200.automation.screenplay.actions;

import java.util.function.Supplier;
import java.util.logging.Logger;

public class Check {

    private final Supplier<Boolean> supplier;
    private final Logger log = Logger.getLogger(Check.class.getName());

    public Check(Supplier<Boolean> supplier) {
        this.supplier = supplier;
    }

    public void then(Runnable runnable){
        try{
            if(evaluateCondition()) runnable.run();
        } catch (Exception e) {
            log.info("check failed: " + e.getMessage());
        }
    }

    public void thenThrow(Supplier<AssertionError> errorSupplier){
        try{
            if(evaluateCondition()) throw errorSupplier.get();
        } catch (Exception e) {
            log.info("check failed: " + e.getMessage());
        }
    }

    private boolean evaluateCondition() {
        return Boolean.TRUE.equals(supplier.get());
    }

    public static Check upOnIf(Supplier<Boolean> supplier){
        return new Check(supplier);
    }

}
