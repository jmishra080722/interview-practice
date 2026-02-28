package org.example.designpattern.structural.factory;

public class AccountTransfer implements Payment{

    @Override
    public void doPayment(String toAcc, long amount) {
        System.out.println("Doing account to account transfer....");
    }
}
