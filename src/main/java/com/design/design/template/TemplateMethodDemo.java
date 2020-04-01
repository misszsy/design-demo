package com.design.design.template;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class TemplateMethodDemo {

    public static void main(String[] args) {
        AbstractClass abstractClass=new ConcreateClass();
        abstractClass.templateMethod();
    }
}
