package com.design.design.template.callback;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class AClass {

    public static void main(String[] args) {
        BClass b=new BClass();
        b.process(new ICallback() {
            @Override
            public void methodToCallback() {
                System.out.println("Call back me.");
            }
        });
    }
}
