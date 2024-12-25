package org.example.designpattern.observerdesignpattern.observable;

import org.example.designpattern.observerdesignpattern.observer.INotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class LaptopObservable implements IStocksObservable{
    private List<INotificationObserver> observerList = new ArrayList<>();
    private int allStocks = 0;

    @Override
    public void add(INotificationObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(INotificationObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAllObserver() {
        for(INotificationObserver observer: observerList){
            observer.update();
        }
    }

    @Override
    public void updateStocks(int stocks) {
        if(allStocks == 0){
            notifyAllObserver();
        }
        allStocks += stocks;
    }
}
