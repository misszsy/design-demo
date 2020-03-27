package com.design.oop.ability;

import com.design.oop.ability.able.Tweetable;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class TweetAbility implements Tweetable {

    @Override
    public void tweet() {
        System.out.println("我是会叫的鸟");
    }
}
