package com.design.design.handler02;


public class ApplicationHandler {

    public static void main(String[] args) {
        HandlerChain chain=new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
    }
}
