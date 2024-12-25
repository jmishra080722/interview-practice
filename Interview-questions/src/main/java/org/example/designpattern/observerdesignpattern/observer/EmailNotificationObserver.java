package org.example.designpattern.observerdesignpattern.observer;

import org.example.designpattern.observerdesignpattern.observable.IStocksObservable;

public class EmailNotificationObserver implements INotificationObserver {

    private IStocksObservable observable;
    private String email;

    public EmailNotificationObserver(String email, IStocksObservable observable){
        this.email = email;
        this.observable = observable;
    }

    @Override
    public void update() {
        //System.out.println("EmailNotificationObserver called");
        sendEmail(email, "IPhone is available");
    }

    private void sendEmail(String email, String message) {
        System.out.println("Email sent to "+email+" that "+message);
    }
}
