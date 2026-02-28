package org.example.designpattern.creational.factory;

public class CreditCardTransfer implements Payment{

    @Override
    public void doPayment(String toAcc, long amount) {
        System.out.println("Doing CREDIT CARD to account transfer....");
    }
}
