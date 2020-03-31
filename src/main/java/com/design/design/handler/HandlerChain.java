package com.design.design.handler;

/**
 * 是处理器链，从数据结构角度看
 * 它就是一个记录了链头，链尾的链表，记录链尾是诶了方便添加处理器
 */
public class HandlerChain {

    //链头
    private Handler head=null;

    //链尾
    private Handler tail=null;

    //添加处理器
    public void addHandler(Handler handler){
        handler.setSuccessor(null);
        /*
            添加处理器的时候，链头如果为空，则把 handlerA 设置为链头和链尾
         */
        if(head==null){
            head=handler;
            tail=handler;
            return;
        }
        //添加处理器的时候,如果链头部位空，则链尾设置 处理器 进去，并把当前处理器设置到链尾
        tail.setSuccessor(handler);
        tail=handler;
    }

    public void handle(){
        if(head!=null){
            head.handle();
        }
    }
}
