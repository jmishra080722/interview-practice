package org.example.designpattern.observerdesignpattern.observer;

import org.example.designpattern.observerdesignpattern.observable.IStocksObservable;

public class SmsNotificationObserver implements INotificationObserver {

    private long phoneNumber;
    private IStocksObservable observable;

    public SmsNotificationObserver(long phoneNumber, IStocksObservable observable){
        this.phoneNumber = phoneNumber;
        this.observable = observable;
    }

    @Override
    public void update() {
        //System.out.println("SmsNotificationObserver called");
        sendSms(phoneNumber,  "IPhone is available");
    }

    private void sendSms(long phoneNumber, String message) {
        System.out.println("SMS sent to "+phoneNumber +" that "+message);
    }
}
