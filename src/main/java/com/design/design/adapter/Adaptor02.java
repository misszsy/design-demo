package com.design.design.adapter;

/**
 * 对象适配器：基于组合
 */
public class Adaptor02 implements ITarget{

    private Adaptee adaptee;

    public Adaptor02(Adaptee adaptee){
        this.adaptee=adaptee;
    }

    @Override
    public void f1(){
        adaptee.fa(); //委托给Adaptee
    }

    @Override
    public void f2(){
        adaptee.fb();
    }

    @Override
    public void f3(){
        adaptee.fc();
    }
}
