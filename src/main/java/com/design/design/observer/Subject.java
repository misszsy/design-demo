package com.design.design.observer;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public interface Subject {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Message message);
}
