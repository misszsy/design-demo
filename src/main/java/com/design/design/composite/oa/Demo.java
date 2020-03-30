package com.design.design.composite.oa;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class Demo {

    private static final long ROOT_ID=1001;

    public void buildOrganization(){
        Department department=new Department(ROOT_ID);
        buildOrganization(department);
    }

    private void buildOrganization(Department department){
        List<Long> subDepartmentIds=new ArrayList<>();//根据当前传参部门ID从数据查询出其子节点
        for (Long subDepartmentId : subDepartmentIds) {
            Department subDepartment=new Department(subDepartmentId);
            department.addSubNode(subDepartment);  //当前部门添加进子部门
            buildOrganization(subDepartment); //递归
        }

        List<Long> employeeIds=new ArrayList<>();//根据当前传参部门ID从数据查询出其部门员工
        for (Long employeeId : employeeIds) {
            double salary=0L;  //employeeRepo.getEmployeeSalary(employeeId) 根据员工ID获取工资
            department.addSubNode(new Employee(employeeId,salary));
        }
    }
}
