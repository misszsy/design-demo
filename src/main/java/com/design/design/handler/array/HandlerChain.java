package com.design.design.handler.array;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain {

    private List<IHandler> handlers=new ArrayList<>();

    public void addHandler(IHandler handler){
        this.handlers.add(handler);
    }

    public void handle(){
        for (IHandler handler : handlers) {
            //处理器处理是否成功
            boolean handled=handler.handle();
            //成功则结束循环，不成功则继续调用下个处理器
            if(handled){
                break;
            }
        }
    }
}
