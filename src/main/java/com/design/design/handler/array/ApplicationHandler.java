package com.design.design.handler.array;


public class ApplicationHandler {

    public static void main(String[] args) {
        HandlerChain chain=new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
    }
}
