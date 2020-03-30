package com.design.design.composite.oa;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public abstract class HumanResource {

    protected   long id;
    protected   double salary;


    public HumanResource(long id){
        this.id=id;
    }

    public long getId() {
        return id;
    }

    public abstract double calculateSalary();
}
