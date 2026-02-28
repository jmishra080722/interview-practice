package org.example.designpattern.structural.factory;

import java.io.InvalidObjectException;

public class FactoryMainDemo {
    public static void main(String[] args) throws InvalidObjectException {
        PaymentFactory paymentFactory = new PaymentFactory();
        Payment payment = paymentFactory.pay(PaymentConstant.accountTransfer);
        payment.doPayment("1234", 2000);
    }
}
