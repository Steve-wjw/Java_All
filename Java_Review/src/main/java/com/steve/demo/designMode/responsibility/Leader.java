package com.steve.demo.designMode.responsibility;

/**
 * @Author: STEVE
 * @Description: 抽象处理者
 * @since: 2023/12/19
 */
public abstract class Leader {

    /* 姓名 */
    public String name;

    /* 后继者 */
    protected Leader successor;

    public Leader(String name) {
        this.name = name;
    }

    public void setSuccessor(Leader successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(LeaveNode leaveNode);

}
