package com.design.design.template;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public abstract class AbstractClass {

    public final void templateMethod(){

        method1();

        method2();
    }

    protected abstract void method1();
    protected abstract void method2();

}
