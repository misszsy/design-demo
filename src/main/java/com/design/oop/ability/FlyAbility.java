package com.design.oop.ability;

import com.design.oop.ability.able.Flyable;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class FlyAbility implements Flyable {

    @Override
    public void fly() {
        System.out.println("我是会飞的鸟");
    }
}
