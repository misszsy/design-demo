package com.design.oop;

import com.design.oop.ability.EggLayAbility;
import com.design.oop.ability.TweetAbility;
import com.design.oop.ability.able.EggLayable;
import com.design.oop.ability.able.Tweetable;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class Ostrich implements Tweetable, EggLayable {

    private TweetAbility tweetAbility;

    private EggLayAbility eggLayAbility;


    public Ostrich(){
        tweetAbility=new TweetAbility();
        eggLayAbility=new EggLayAbility();
    }

    @Override
    public void tweet() {
        tweetAbility.tweet(); //委托机制
    }

    @Override
    public void layEgg() {
        
        eggLayAbility.layEgg();  //委托机制
    }
}
