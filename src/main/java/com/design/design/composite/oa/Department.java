package com.design.design.composite.oa;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class Department extends HumanResource {

    private List<HumanResource> subNodes=new ArrayList<>();

    public Department(long id){
        super(id);
    }

    @Override
    public double calculateSalary() {
        double totalSalary=0;
        for (HumanResource hr:subNodes) {
            totalSalary +=hr.calculateSalary();
        }
        this.salary=totalSalary;
        return totalSalary;
    }

    public void addSubNode(HumanResource hr){
        subNodes.add(hr);
    }
}
