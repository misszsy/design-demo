package com.design.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observers=new ArrayList<>();

    /**
     * 注册观察者
     * @param observer
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * 删除观察者
     * @param observer
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知观察者
     * @param message
     */
    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
