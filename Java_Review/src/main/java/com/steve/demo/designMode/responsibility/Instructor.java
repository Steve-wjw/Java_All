package com.steve.demo.designMode.responsibility;

/**
 * @Author: STEVE
 * @Description: 辅导员
 * @since: 2023/12/19
 */
public class Instructor extends Leader {

    public Instructor(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        if (leaveNode.getNumber() <= 3) { // 小于三天辅导员审批
            System.out.println("辅导员" + name + "审批" + leaveNode.getPerson() + "同学的请假条,请假天数为" + leaveNode.getNumber() + "天。");
        } else {
            // 否则传递给系主任
            if (this.successor != null) {
                this.successor.handleRequest(leaveNode);
            }
        }
    }

}