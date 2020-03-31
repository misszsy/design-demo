package com.design.design.handler02;

/**
 * 基于链表的职责链变体方式
 */
public abstract class Handler {

    protected Handler successor=null;

    public void setSuccessor(Handler successor){
        this.successor=successor;
    }

    public final void handle(){
        doHandle();
        if(successor!=null){
            successor.handle();
        }
    }

    protected abstract void doHandle();
}
