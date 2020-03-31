package com.design.design.handler.template;

import com.design.design.handler.Handler;

/**
 * 利用模板模式+职责链模式
 */
public abstract class HandlerTemplate {

    protected HandlerTemplate successor=null;

    public void setSuccessor(HandlerTemplate successor){
        this.successor=successor;
    }

    public final void handle(){
        boolean handled=doHandle();
        if (successor!=null && !handled){
            successor.handle();
        }
    }

    protected abstract boolean doHandle();
}
