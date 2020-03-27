package com.design.design.factory;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class InvalidRuleConfigException extends RuntimeException {

    public InvalidRuleConfigException(){
        super();
    }

    public InvalidRuleConfigException(String messgae){
        super(messgae);
    }
}
