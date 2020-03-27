package com.design.oop.ability;

import com.design.oop.ability.able.EggLayable;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class EggLayAbility implements EggLayable {

    @Override
    public void layEgg() {
        System.out.println("我是会叫的鸟");
    }
}
