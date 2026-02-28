package org.example.designpattern.structural.factory;

import java.io.InvalidObjectException;

public class PaymentFactory {
    public Payment pay(String paymentMethod) throws InvalidObjectException {
        if(paymentMethod.equalsIgnoreCase(PaymentConstant.creditCard)){
            return new CreditCardTransfer();
        } else if (paymentMethod.equalsIgnoreCase(PaymentConstant.accountTransfer)) {
            return new AccountTransfer();
        }else {
            throw new InvalidObjectException("Invalid payment option selected");
        }
    }
}
