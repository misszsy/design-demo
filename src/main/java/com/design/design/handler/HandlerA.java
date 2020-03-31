package com.design.design.handler;

/**
 * 处理器类
 * 如果能处理请求，就不继续往下传递
 * 如果不能处理，则交由后面的处理器来处理，也就是调用 successor.handle()
 */
public class HandlerA extends Handler {

    @Override
    public void handle() {
        boolean handled=false;
        //判断是否处理成功和时候有下一个处理器
        if(!handled && successor!=null){
            //否则调用下个处理器
            successor.handle();
        }
    }
}
