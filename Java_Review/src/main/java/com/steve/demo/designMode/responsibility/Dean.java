package com.steve.demo.designMode.responsibility;

/**
 * @Author: STEVE
 * @Description: 院长
 * @since: 2023/12/19
 */
public class Dean extends Leader {

    public Dean(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        if (leaveNode.getNumber() <= 10) { // 小于十天院长审批
            System.out.println("院长" + name + "审批" + leaveNode.getPerson() + "同学的请假条,请假天数为" + leaveNode.getNumber() + "天。");
        } else {
            // 否则传递给校长
            if (this.successor != null) {
                this.successor.handleRequest(leaveNode);
            }
        }
    }

}
