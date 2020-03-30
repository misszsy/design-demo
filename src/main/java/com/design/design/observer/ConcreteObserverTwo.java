package com.design.design.observer;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class ConcreteObserverTwo implements Observer {

    @Override
    public void update(Message message) {
        //TODO: 获取消息通知，执行自己的逻辑...
        System.out.println("ConcreteObserverTwo is notified");
    }
}
