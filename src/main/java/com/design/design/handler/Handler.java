package com.design.design.handler;

/**
 * 是所有处理器的抽象父类
 */
public abstract class Handler {

    protected  Handler successor=null;

    public void setSuccessor(Handler successor){
        this.successor=successor;
    }

    //是抽象方法
    public abstract void handle();
}
