package com.steve.demo.designMode.responsibility;

/**
 * @Author: STEVE
 * @Description: 系主任
 * @since: 2023/12/19
 */
public class DepartmentHead extends Leader {

    public DepartmentHead(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        if (leaveNode.getNumber() <= 7) { // 小于七天系主任审批
            System.out.println("系主任" + name + "审批" + leaveNode.getPerson() + "同学的请假条,请假天数为" + leaveNode.getNumber() + "天。");
        } else {
            // 否则传递给院长
            if (this.successor != null) {
                this.successor.handleRequest(leaveNode);
            }
        }
    }

}
