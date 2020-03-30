package com.design.design.observer;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class ConcreteObserverOne implements Observer {

    @Override
    public void update(Message message) {
        //TODO:获取消息通知自，执行逻辑
        System.out.println("ConcreteObserverOne is notified");
    }



}
