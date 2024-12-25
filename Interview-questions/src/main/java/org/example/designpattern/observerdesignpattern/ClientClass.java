package org.example.designpattern.observerdesignpattern;

import org.example.designpattern.observerdesignpattern.observable.LaptopObservable;
import org.example.designpattern.observerdesignpattern.observable.PhoneObservable;
import org.example.designpattern.observerdesignpattern.observable.IStocksObservable;
import org.example.designpattern.observerdesignpattern.observer.EmailNotificationObserver;
import org.example.designpattern.observerdesignpattern.observer.INotificationObserver;
import org.example.designpattern.observerdesignpattern.observer.SmsNotificationObserver;

public class ClientClass {
    public static void main(String[] args) {
        INotificationObserver emailObserver1 = new EmailNotificationObserver("email1@mail.com", new PhoneObservable());
        INotificationObserver emailObserver2 = new EmailNotificationObserver("email2@mail.com", new LaptopObservable());
        INotificationObserver smsObserver1 = new SmsNotificationObserver(1234567890, new PhoneObservable());
        INotificationObserver smsObserver2 = new SmsNotificationObserver(1234567890, new LaptopObservable());

        IStocksObservable stocksObservable = new PhoneObservable();
        stocksObservable.add(emailObserver1);
        stocksObservable.add(emailObserver2);
        stocksObservable.add(smsObserver1);
        stocksObservable.add(smsObserver2);

        stocksObservable.updateStocks(10);
    }
}
