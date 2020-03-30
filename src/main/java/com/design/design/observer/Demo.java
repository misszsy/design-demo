package com.design.design.observer;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class Demo {

    public static void main(String[] args) {
        ConcreteSubject subject=new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObservers(new Message());
    }
}
