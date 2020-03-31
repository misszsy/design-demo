package com.design.design.handler.template;

import com.design.design.handler.Handler;

/**
 * 处理器类
 * 如果能处理请求，就不继续往下传递
 * 如果不能处理，则交由后面的处理器来处理，也就是调用 successor.handle()
 */
public class HandlerA extends HandlerTemplate {

    @Override
    public boolean doHandle() {
      boolean handled=false;
       return handled;
    }
}
