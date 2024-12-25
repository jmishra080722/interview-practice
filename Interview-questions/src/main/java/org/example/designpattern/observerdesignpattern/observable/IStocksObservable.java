package org.example.designpattern.observerdesignpattern.observable;

import org.example.designpattern.observerdesignpattern.observer.INotificationObserver;

public interface IStocksObservable {

    void add(INotificationObserver iNotificationObserver);

    void remove(INotificationObserver iNotificationObserver);

    void notifyAllObserver();

    void updateStocks(int stocks);


}
