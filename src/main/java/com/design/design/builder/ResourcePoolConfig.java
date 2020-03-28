package com.design.design.builder;

import org.springframework.util.StringUtils;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class ResourcePoolConfig {
    private static final int DEFAULT_MAX_TOTAL=8;
    private static final int DEFAULT_MAX_IDLE=8;
    private static final int DEFAULT_MIN_IDLE=0;

    private String name;
    private int maxTotal=DEFAULT_MAX_TOTAL;
    private int maxIdle=DEFAULT_MAX_IDLE;
    private int minIdle=DEFAULT_MIN_IDLE;

    public ResourcePoolConfig(Builder builder){
        this.name=builder.name;
        this.maxTotal=builder.maxTotal;
        this.maxIdle=builder.maxIdle;
        this.minIdle=builder.minIdle;
    }

    //未改造为Builder模式时的方式
   /* public ResourcePoolConfig(String name,Integer maxTotal,Integer maxIdle,Integer minIdle){
        if(StringUtils.isEmpty(name)){
            throw new IllegalArgumentException("name should not be empty.");
        }
        this.name=name;

        if(maxTotal!=null){
            if(maxTotal <=0){
                throw new IllegalArgumentException("maxTotal should be positive.");
            }
        }
        this.maxTotal=maxTotal;

        if (maxIdle != null) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("maxIdle should not be negative.");
            }
          this.maxIdle = maxIdle;
        }
        if (minIdle != null) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("minIdle should not be negative.");
            }
          this.minIdle = minIdle;
        }
    }*/

    /**
     * 将Builder类设计为静态内部类
     * 也可以设计为独立的非内部类ResourcePoolConfigBuilder
     */
    public static class Builder{

        private static final int DEFAULT_MAX_TOTAL=8;
        private static final int DEFAULT_MAX_IDLE=8;
        private static final int DEFAULT_MIN_IDLE=0;

        private String name;
        private int maxTotal=DEFAULT_MAX_TOTAL;
        private int maxIdle=DEFAULT_MAX_IDLE;
        private int minIdle=DEFAULT_MIN_IDLE;


        public ResourcePoolConfig build(){
            if(StringUtils.isEmpty(name)){
                throw new IllegalArgumentException("name should not be empty.");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("...");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("...");
            }
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name){
            if(StringUtils.isEmpty(name)){
                throw new IllegalArgumentException("name should not be empty.");
            }
            this.name=name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal){
            if(maxTotal < 0){
                throw new IllegalArgumentException("...");
            }
            this.maxTotal=maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle){
            if(maxIdle < 0){
                throw new IllegalArgumentException("...");
            }
            this.maxIdle=maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle){
            if(minIdle < 0){
                throw new IllegalArgumentException("...");
            }
            this.minIdle=minIdle;
            return this;
        }
    }



    public static void main(String[] args) {
        /**
         * ResourcePoolConfig 只有 4 个可配置项，对应到构造函数中，也只有 4 个参数
         * 但是，如果可配置项逐渐增多，变成了 8 个、10 个，甚至更多，那继续沿用现在的设计思路，构造函数的参数列表会变得很长，代码在可读性和易用性上都会变差。
         * 在使用构造函数的时候，我们就容易搞错各参数的顺序，传递进错误的参数值，导致非常隐蔽的 bug。
         */
        //ResourcePoolConfig resourcePoolConfig=new ResourcePoolConfig("dbconnectionpool",16,null,null);
        //使用建造者模式后的创建对象方式
        ResourcePoolConfig   config=new ResourcePoolConfig.Builder()
                             .setName("123")
                             .setMaxTotal(16)
                             .setMaxIdle(10)
                             .setMinIdle(12).build();
    }
}
